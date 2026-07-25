using System;
using System.Collections.Generic;
using System.Globalization;
using System.Runtime.CompilerServices;
using System.Text;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DomainEntity = DataDictionary.Domain.Models.Domain;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Parser.Helpers;

namespace DataDictionary.Parser.Visitors
{
    public class DataDictionaryModelBuilderVisitor
    {
        private readonly ConstraintModelBuilderVisitor _constraintBuilder = new();
        private readonly Dictionary<string, DomainEntity> _domainsByName = new();
        private readonly Dictionary<string, Structure> _structuresByName = new();
        public DataDictionaryModel Visit(DataDictionaryParser.DataDictionaryContext context)
        {
            int id = int.Parse(context.INT().GetText());
            string name = Helper.ProcessString(context.STRING(0).GetText());
            string author = Helper.ProcessString(context.STRING(1).GetText());
            string version = Helper.ProcessString(context.STRING(2).GetText());
            if (!DateTime.TryParseExact(context.DATE().GetText(),
                "dd.MM.yyyy.", CultureInfo.InvariantCulture, DateTimeStyles.None, out DateTime dateOfCreation))
            {
                throw new ArgumentException("Invalid date format");
            }
            List<LogicalFunction>? logicalFunctions = context.logicalFunctionDecl()?.Select(BuildLogicalFunction).ToList();
            List<SemanticDomain>? semanticDomains = context.semanticDomainDecl()?.Select(BuildSemanticDomain).ToList();
            List<Structure>? structures = context.structureDecl()?.Select(ctx => BuildStructure(ctx, 0, string.Empty)).ToList();
            // ove vrednosti za id i name ce biti pregazene za definisanje korene strukture
            return new DataDictionaryModel(id, name, author, version, dateOfCreation, structures, logicalFunctions, semanticDomains);
        }

        private LogicalFunction BuildLogicalFunction(DataDictionaryParser.LogicalFunctionDeclContext context)
        {
            int id = int.Parse(context.INT().GetText());
            string name = Helper.ProcessString(context.STRING().GetText());
            ConstraintExpression constraint = _constraintBuilder.Build(context.constraint());
            bool result = context.BOOLEAN().GetText() == "true";
            return new LogicalFunction(id, name, constraint, result);
        }
        private SemanticDomain BuildSemanticDomain(DataDictionaryParser.SemanticDomainDeclContext context)
        {
            int id = int.Parse(context.INT().GetText());
            string name = Helper.ProcessString(context.STRING().GetText());
            DomainEntity baseDomain = BuildDomain(context.domainReference());
            ConstraintExpression? definitionalConstraint = null;
            if (context.constraint() != null)
            {
                definitionalConstraint = _constraintBuilder.Build(context.constraint());
            }
            if (context.enumeratedDomainDecl() != null)
            {
                return BuildEnumeratedDomain(context.enumeratedDomainDecl(), id, name, baseDomain);
            }
            SemanticDomain semanticDomain = new SemanticDomain(id, name, baseDomain, definitionalConstraint);
            _domainsByName.Add(name, semanticDomain);
            return semanticDomain;
        }

        private EnumeratedDomain BuildEnumeratedDomain(DataDictionaryParser.EnumeratedDomainDeclContext context,
            int id, string name, DomainEntity baseDomain)
        {
            List<Value> values = new List<Value>();
            foreach (var valueCtx in context.value())
            {
                values.Add(BuildValue(valueCtx));
            }
            EnumeratedDomain enumeratedDomain = new EnumeratedDomain(id, name, baseDomain, values);
            _domainsByName.Add(name, enumeratedDomain);
            return enumeratedDomain;
        }
        private Structure BuildStructure(DataDictionaryParser.StructureDeclContext context, int id, string name)
        {
            StructureType structureType;
            if (context.INT() != null)
            {
                id = int.Parse(context.INT().GetText());
            }
            if (context.STRING() != null)
            {
                name = Helper.ProcessString(context.STRING().GetText());
            }
            if (context.STRUCTURE_TYPE() != null)
            {
                structureType = context.STRUCTURE_TYPE().GetText() switch
                {
                    "dataFlow" => StructureType.DataFlow,
                    "dataStore" => StructureType.DataStore,
                    _ => throw new ArgumentException($"Unknown structure type: {context.STRUCTURE_TYPE().GetText()}")
                };
            }
            else
            {
                throw new ArgumentException("Structure type is required.");
            }
            List<Construction> constructions = context.constructionDecl().Select(BuildConstruction).ToList(); ;
            Structure structure = new Structure(id, name, structureType, constructions);
            _structuresByName.Add(name, structure);
            return structure;
        }

        private Construction BuildConstruction(DataDictionaryParser.ConstructionDeclContext context)
        {
            if (context.aggregationDecl() != null)
            {
                return BuildAggregation(context.aggregationDecl());
            }
            else if (context.setDecl() != null)
            {
                return BuildSet(context.setDecl());
            }
            else if (context.specializationDecl() != null)
            {
                return BuildSpecialization(context.specializationDecl());
            }
            throw new ArgumentException("Unknown construction type.");
        }

        private Component BuildComponent(DataDictionaryParser.ComponentDeclContext context)
        {
            int id = int.Parse(context.INT().GetText());
            string name = Helper.ProcessString(context.STRING().GetText());

            // structure (declaration) or structure reference
            if (context.structureDecl() != null)
            {
                return BuildStructure(context.structureDecl(), id, name);
            }
            else if (context.structureReference() != null)
            {
                Structure structure;
                if (context.structureReference().STRING() != null)
                {
                    string structureName = Helper.ProcessString(context.structureReference().STRING().GetText());
                    if (!_structuresByName.TryGetValue(structureName, out structure))
                        throw new ArgumentException($"Unknown structure: {structureName}");
                    return structure;
                }
                throw new ArgumentException("Structure reference must have a name.");
            }

            //field
            else if (context.fieldDecl() != null)
            {
                return BuildField(context.fieldDecl(), id, name);
            }
            throw new ArgumentException("Unknown component type.");
        }

        private Field BuildField(DataDictionaryParser.FieldDeclContext context, int id, string name)
        {
            DomainEntity domain = null;
            string? format = null;
            ConstraintExpression? constraint = null;
            Nullability? nullability = null;
            Value? defaultValue = null;
            string? note = null;

            if (context.domainReference() != null)
            {
                domain = BuildDomain(context.domainReference());
            }
            if (context.format() != null)
            {
                format = Helper.ProcessString(context.format().GetText());
            }
            if (context.constraint() != null)
            {
                constraint = _constraintBuilder.Build(context.constraint());
            }
            if (context.NULL_CONSTRAINT() != null)
            {
                if (context.NULL_CONSTRAINT().GetText() == "null")
                    nullability = Nullability.Null;
                else if (context.NULL_CONSTRAINT().GetText() == "not null")
                    nullability = Nullability.NotNull;
            }
            if (context.value() != null)
            {
                defaultValue = BuildValue(context.value());
            }
            if (context.note() != null)
            {
                note = Helper.ProcessString(context.note().GetText());
            }
            return new Field(id, name, domain, nullability, format, constraint, defaultValue, note);
        }


        private Value BuildValue(DataDictionaryParser.ValueContext ctx)
        {
            if (ctx.STRING() != null)
                return new StringValue(Helper.ProcessString(ctx.STRING().GetText()));
            if (ctx.DATE() != null)
            {
                if (!DateTime.TryParseExact(ctx.DATE().GetText(), "dd.MM.yyyy.",
                        CultureInfo.InvariantCulture, DateTimeStyles.None, out DateTime d))
                    throw new ArgumentException("Invalid date format.", nameof(ctx));
                return new DateValue(d);
            }
            if (ctx.BOOLEAN() != null)
                return new BooleanValue(ctx.BOOLEAN().GetText() == "true");
            // preostaju INT ili REAL — oba su broj
            if (!decimal.TryParse(ctx.GetText(), NumberStyles.Any, CultureInfo.InvariantCulture, out decimal n))
                throw new ArgumentException("Invalid numeric format.", nameof(ctx));
            return new NumericValue(n);
        }

        //helper methods
        private DomainEntity BuildDomain(DataDictionaryParser.DomainReferenceContext ctx)
        {
            DomainEntity domain = null;
            if (ctx.BASE_DOMAIN() != null)
            {
                domain = PredefinedDomains.FromKeyword(ctx.BASE_DOMAIN().GetText());
            }
            else if (ctx.STRING() != null)
            {
                string domainName = Helper.ProcessString(ctx.STRING().GetText());
                if (!_domainsByName.TryGetValue(domainName, out domain))
                    throw new ArgumentException($"Unknown semantic domain: {domainName}");
            }
            return domain;
        }
        private Construction BuildSpecialization(DataDictionaryParser.SpecializationDeclContext ctx)
        {
            if (ctx.inclusiveSpecializationDecl() != null)
            {
                return BuildInclusiveSpecialization(ctx.inclusiveSpecializationDecl());

            }
            else if (ctx.exclusiveSpecializationDecl() != null)
            {
                return BuildExclusiveSpecialization(ctx.exclusiveSpecializationDecl());
            }
            throw new ArgumentException("Unknown specialization type.");
        }

        private Construction BuildExclusiveSpecialization(DataDictionaryParser.ExclusiveSpecializationDeclContext ctx)
        {
            List<Component> components = new List<Component>();
            if (ctx.componentDecl() == null || ctx.componentDecl().Length < 1)
                throw new ArgumentException("Exclusive specialization must have at least one component.");
            foreach (var component in ctx.componentDecl())
            {
                components.Add(BuildComponent(component));
            }
            return new Construction(ConstructionType.ExclusiveSpecialization, components);
        }

        private Construction BuildInclusiveSpecialization(DataDictionaryParser.InclusiveSpecializationDeclContext ctx)
        {
            List<Component> components = new List<Component>();
            if (ctx.componentDecl() == null || ctx.componentDecl().Length < 2)
                throw new ArgumentException("Inclusive specialization must have at least two components.");
            foreach (var component in ctx.componentDecl())
            {
                components.Add(BuildComponent(component));
            }
            return new Construction(ConstructionType.InclusiveSpecialization, components);
        }

        private Construction BuildSet(DataDictionaryParser.SetDeclContext ctx)
        {
            List<Component> components = new List<Component>();
            if (ctx.componentDecl() == null || ctx.componentDecl().Length < 1)
                throw new ArgumentException("Set must have at least one component.");
            foreach (var component in ctx.componentDecl())
            {
                components.Add(BuildComponent(component));
            }
            return new Construction(ConstructionType.Set, components);
        }

        private Construction BuildAggregation(DataDictionaryParser.AggregationDeclContext ctx)
        {
            List<Component> components = new List<Component>();
            if (ctx.componentDecl() == null || ctx.componentDecl().Length < 2)
                throw new ArgumentException("Aggregation must have at least two components.");
            foreach (var component in ctx.componentDecl())
            {
                components.Add(BuildComponent(component));
            }
            return new Construction(ConstructionType.Aggregation, components);
        }
    }
}
