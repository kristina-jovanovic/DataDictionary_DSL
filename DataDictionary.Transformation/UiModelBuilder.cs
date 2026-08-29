using System.ComponentModel.DataAnnotations;
using DataDictionary.Domain;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Domain.Models.Constraints.In;
using DataDictionary.Domain.Models.Constraints.Like;
using DataDictionary.Domain.Models.Constraints.Value;
using DataDictionary.UIModel;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.Transformation
{
    // Glavni orkestrator transformacije: DataDictionaryModel -> UI model (koreni Panel).
    //
    // Princip: rekurzivni obilazak ulaznog stabla (Structure -> Construction -> Component).
    // Svaka kontrola dobija id iz ctx.Ids.Next() PRE nego sto se udje u njenu decu
    // (pre-order numeracija = kao u ciljnom JSON-u).
    //
    // Mapiranje (heuristike + odluke projekta):
    //   Struktura po konstrukciji:
    //     Aggregation             -> Panel (Flow),  deca = komponente
    //     Set                     -> Collection,    TemplateControl = Panel (Grid, showGridLines)
    //     InclusiveSpecialization -> Panel (Flow),  deca = CheckBox-ovi   (GroupName = ime strukture)
    //     ExclusiveSpecialization -> Panel (Flow),  deca = RadioButton-i  (GroupName = ime strukture)
    //   Polje po domenu:
    //     String/Integer/Real -> TextBox; Logical -> CheckBox; Date -> DateTimePicker;
    //     Graphic -> FilePicker; EnumeratedDomain -> ComboBox
    //   Osobine polja:
    //     nullability != null -> IsRequired (samo eksplicitno "null" daje IsRequired=false)
    //     format (regex)      -> TextBox.Pattern
    //     constraint          -> RestrictedValue (poredjenje/LIKE/IN/BETWEEN)
    //                            ili ComputedValue + IsReadOnly (aritmetika "= izraz")
    public sealed class UiModelBuilder
    {
        // Za svako polje: roditeljska struktura (identifikator) + da li je ta struktura Set.
        // Sluzi za targetName operanada u aritmetici (v. OperandTargetName).
        private readonly Dictionary<string, (string parentId, bool parentIsSet)> _fieldParent = new();

        public Panel Build(DataDictionaryModel model)
        {
            var ctx = new TransformationContext(new IdProvider());
            IndexFieldParents(model.Structures[0], null, false);
            // Koren je uvek Panel (korena struktura ima agregaciju kao konstrukciju).
            return (Panel)TransformStructure(model.Structures[0], ctx);
        }

        // Napuni _fieldParent: za svako polje zapamti roditeljsku strukturu i da li je Set.
        private void IndexFieldParents(Component c, string? parentId, bool parentIsSet)
        {
            if (c is Field f)
            {
                _fieldParent[NameHelper.ToIdentifier(f.Name)] = (parentId ?? "", parentIsSet);
            }
            else if (c is Structure s)
            {
                string sid = NameHelper.ToIdentifier(s.Name);
                foreach (var con in s.Constructions)
                {
                    bool isSet = con.ConstructionType == ConstructionType.Set;
                    foreach (var comp in con.Components)
                        IndexFieldParents(comp, sid, isSet);   // deca -> roditelj = ova struktura
                }
            }
        }

        // targetName operanda: u kolekciji (Set) UVEK "roditelj.ime"
        // van kolekcije "roditelj.ime" samo ako se referencira iz DRUGE strukture, a golo ime ako je iz iste
        private string OperandTargetName(string rawName, string currentScopeId)
        {
            string fid = NameHelper.ToIdentifier(rawName);
            if (!_fieldParent.TryGetValue(fid, out var info))
                return fid;   // nepoznato -> golo (fallback)
            if (info.parentIsSet || info.parentId != currentScopeId)
                return $"{info.parentId}.{fid}";
            return fid;
        }

        // Struktura -> Panel | Collection, u zavisnosti od (jedine) konstrukcije
        private Control TransformStructure(Structure structure, TransformationContext ctx)
        {
            switch (structure.Constructions[0].ConstructionType)
            {
                case ConstructionType.Aggregation:
                    //svaka struktura ima jednu glavnu konstrukciju, a moze da ima ugnjezdene
                    return BuildPanelFromAggregation(structure, structure.Constructions[0], ctx);
                case ConstructionType.Set:
                    return BuildCollectionFromSet(structure, structure.Constructions[0], ctx);
                case ConstructionType.InclusiveSpecialization:
                case ConstructionType.ExclusiveSpecialization:
                    return BuildPanelFromSpecialization(structure, structure.Constructions[0], ctx);
                default:
                    throw new ArgumentException("Unsupported Construction type.");
            }
        }

        // Komponenta -> kontrola: Field -> TransformField, Structure -> TransformStructure.
        private Control TransformComponent(Component component, Structure superStructure, TransformationContext ctx)
        {
            if (component is Structure s)
                return TransformStructure(s, ctx);
            else
                return TransformField((Field)component, superStructure, ctx);
        }

        // Polje -> DataControl
        private DataControl TransformField(Field field, Structure structure, TransformationContext ctx)
        {
            int id = ctx.Ids.Next();
            ResolvedDomain? domain = DomainResolver.Resolve(field.DefinedOverDomain);
            if (domain == null)
                throw new ArgumentException($"Domain '{field.DefinedOverDomain.Name}' could not be resolved (unknown or cyclic).");
            DataControl result = null;
            // Enumerisani domen -> ComboBox (ima prioritet nad baznim tipom: npr. enumerisani String
            // ne sme da postane TextBox). Front-end je vec popunio domain.Enumerated (v. DomainResolver).
            if (domain.IsEnumerated && domain.Enumerated != null)
            {
                result = BuildComboBoxControl(field, domain.BaseType, domain.Enumerated.AllowedValues, id, ctx);
            }
            else if (field.Constraint is InConstraint inConstraint)
            {
                // IN ogranicenje polja -> ComboBox
                result = BuildComboBoxControl(field, domain.BaseType, inConstraint.Values.Select(ToValue), id, ctx);
            }
            else
            switch (domain.BaseType)
            {
                case PredefinedDomainType.Integer:
                case PredefinedDomainType.Real:
                    // Numericki format (npr. "{n} %", "{n} RSD") ide u Pattern; nije regex.
                    // Darko zna: ako se Pattern kompajlira kao regex -> validacija, ako ne -> maska.
                    result = new TextBoxControl(
                        id,
                        NameHelper.ToIdentifier(field.Name),
                        domain.BaseType,
                        field.Name,
                        field.Nullability != Nullability.Null,
                        defaultValue: field.DefaultValue,
                        pattern: field.Format
                        );
                    break;
                case PredefinedDomainType.Date:
                    result = new DateTimePickerControl(
                        id,
                        NameHelper.ToIdentifier(field.Name),
                        field.Name,
                        field.Nullability != Nullability.Null,
                        format: field.Format,
                        defaultValue: (DateValue?)field.DefaultValue
                        );
                    break;
                case PredefinedDomainType.Graphic:
                    result = new FilePickerControl(
                        id,
                        NameHelper.ToIdentifier(field.Name),
                        field.Name,
                        field.Nullability != Nullability.Null,
                        defaultValue: field.DefaultValue,
                        fileFormat: field.Format
                        );
                    break;
                case PredefinedDomainType.String:
                    result = new TextBoxControl(
                        id,
                        NameHelper.ToIdentifier(field.Name),
                        PredefinedDomainType.String,
                        field.Name,
                        field.Nullability != Nullability.Null,
                        field.DefaultValue,
                        field.Format);
                    break;
                case PredefinedDomainType.Logical:
                    //ako je u polju, onda je "solo" opcija, tj. bice checkbox - checked ili not checked
                    result = new CheckBoxControl(
                            id,
                            NameHelper.ToIdentifier(field.Name),
                            field.Name,
                            field.Nullability != Nullability.Null,
                            structure.Name,
                            field.Name);
                    break;
                default:
                    throw new ArgumentException("Unsupported Domain type.");
            }
            string controlName = NameHelper.ToIdentifier(field.Name);
            result.ComputedValue = BuildComputedValue(field.Constraint, NameHelper.ToIdentifier(structure.Name));
            result.IsReadOnly = result.ComputedValue != null;       // racunato polje => read-only
            // IN je vec predstavljen kao ComboBox (stavke nose ogranicenje) -> ne dupliramo ga kao restrictedValue.
            ConstraintExpression? restriction = field.Constraint ?? domain.SemanticConstraint;
            if (restriction is InConstraint && result is ComboBoxControl)
                restriction = null;
            result.RestrictedValue = BuildRestrictedValue(restriction, controlName, ctx);
            return result;
        }

        // Gradi ComboBox iz liste dozvoljenih vrednosti (koristi ga i enumerisani domen i IN ogranicenje).
        // Svaka stavka dobija sledeci id iz IdProvider-a (pre-order: posle id-a same kontrole).
        private ComboBoxControl BuildComboBoxControl(Field field, PredefinedDomainType dataType,
            IEnumerable<Value> allowedValues, int id, TransformationContext ctx)
        {
            List<ComboBoxItem> items = new List<ComboBoxItem>();
            foreach (Value allowed in allowedValues)
            {
                int itemId = ctx.Ids.Next();
                items.Add(new ComboBoxItem(itemId, EnumeratedItemLabel(allowed), allowed));
            }
            return new ComboBoxControl(
                id,
                NameHelper.ToIdentifier(field.Name),
                dataType,
                field.Name,
                field.Nullability != Nullability.Null,
                items,
                defaultValue: field.DefaultValue);
        }

        // Label stavke ComboBox-a iz vrednosti domena
        private static string EnumeratedItemLabel(Value value) => value switch
        {
            StringValue s => s.Value,
            NumericValue n => n.Value.ToString(System.Globalization.CultureInfo.InvariantCulture),
            DateValue d => d.Value.ToString("yyyy-MM-dd", System.Globalization.CultureInfo.InvariantCulture),
            BooleanValue b => b.Value ? "true" : "false",
            _ => value.ToString() ?? string.Empty
        };

        // --- konstrukcije ------------------------------------------------------
        // Aggregation -> Panel (FlowLayout)
        private Panel BuildPanelFromAggregation(Structure structure, Construction construction, TransformationContext ctx)
        {
            int id = ctx.Ids.Next();
            var controls = new List<Control>();
            foreach (var control in construction.Components)
                controls.Add(TransformComponent(control, structure, ctx));

            return new Panel(
                id,
                NameHelper.ToIdentifier(structure.Name),
                controls,
                new FlowLayout(),
                title: structure.Name);
        }

        // Set -> Collection
        // TemplateControl = Panel (GridLayout, showGridLines=true) 
        private Collection BuildCollectionFromSet(Structure structure, Construction construction, TransformationContext ctx)
        {
            int collectionId = ctx.Ids.Next();
            int templateId = ctx.Ids.Next();

            List<Control> controls = new List<Control>();
            TransformationContext tc = ctx.WithTargetNamePrefix(NameHelper.ToIdentifier(structure.Name));
            foreach (var component in construction.Components)
            {
                controls.Add(TransformComponent(component, structure, tc));
            }

            Panel template = new Panel(
                templateId,
                NameHelper.ToIdentifier(structure.Name),
                controls,
                new GridLayout(true),
                structure.Name);

            return new Collection(
                collectionId,
                NameHelper.ToIdentifier(structure.Name),
                template);
        }

        // Inkluzivna/ekskluzivna specijalizacija -> Panel (FlowLayout) sa choice kontrolama
        // Inclusive -> CheckBoxControl, Exclusive -> RadioButtonControl
        private Panel BuildPanelFromSpecialization(Structure structure, Construction construction, TransformationContext ctx)
        {
            int id = ctx.Ids.Next();
            List<Control> controls = new List<Control>();

            foreach (var component in construction.Components)
            {
                // clanovi specijalizacije su polja (za sada)
                if (component is not Field field)
                    throw new ArgumentException($"For now, only fields are allowed in specializaton: {component.Name}");

                int componentId = ctx.Ids.Next();
                bool isRequired = field.Nullability == Nullability.NotNull;
                string groupName = NameHelper.ToIdentifier(structure.Name);   // naziv strukture
                string optionValue = NameHelper.ToIdentifier(field.Name);     // naziv polja

                if (construction.ConstructionType == ConstructionType.ExclusiveSpecialization)
                    controls.Add(new RadioButtonControl(
                        componentId, NameHelper.ToIdentifier(field.Name), field.Name, isRequired, groupName, optionValue));
                else
                    controls.Add(new CheckBoxControl(
                        componentId, NameHelper.ToIdentifier(field.Name), field.Name, isRequired, groupName, optionValue));
            }
            return new Panel(
                id,
                NameHelper.ToIdentifier(structure.Name),
                controls,
                new FlowLayout(),
                structure.Name);
        }

        // --- ogranicenja -------------------------------------------------------

        // Ogranicenje unosa -> RestrictedValue (ConstraintUI sa listom pravila).
        //   ValueConstraint  -> pravilo po poredjenju (targetName, operator, value) - >,<,>=,<=,...
        //   LikeConstraint   -> operator "LIKE", value = pattern
        //   InConstraint     -> operator "IN", lista vrednosti
        //   BetweenConstraint-> granice (>=/<=)
        private ConstraintUI? BuildRestrictedValue(ConstraintExpression? constraint, string controlName, TransformationContext ctx)
        {
            if (constraint is null) return null;
            string target = ctx.QualifyTargetName(controlName);

            switch (constraint)
            {
                case ValueConstraint vc:
                    return BuildRestrictedValueFromValueConstraint(vc, target);
                case LikeConstraint lc:
                    return new ConstraintUI(new()
                    {
                        new ConstraintRule
                        {
                            TargetName=target,
                            Operator="LIKE",
                            Value=new StringValue(lc.Pattern)
                        }
                    });
                case InConstraint ic:
                    return new ConstraintUI(new()
                    {
                        new ConstraintRule
                        {
                            TargetName = target,
                            Operator = "IN",
                            Operands = ic.Values.Select(v => new ConstraintOperand
                            {
                                Value = ToValue(v)
                            }).ToList()
                        }
                    });
                // BETWEEN(5,10) -> >=5 AND <=10
                case BetweenConstraint bc:
                    return new ConstraintUI(new()
                    {
                        new ConstraintRule
                        {
                            TargetName=target,
                            Operator=">=",
                            Value=ToValue(bc.LowerBound)
                        },
                        new ConstraintRule
                        {
                            TargetName=target,
                            Operator="<=",
                            Value=ToValue(bc.UpperBound)
                        },

                    }, ConstraintGroup.AND);
                case ArithmeticConstraint:
                    return null; //ovo ide u BuildComputedValue()
                default:
                    throw new ArgumentException($"Unsupported constraint type: {constraint.GetType().Name}");
            }
        }

        private ConstraintUI? BuildRestrictedValueFromValueConstraint(ValueConstraint vc, string target)
        {
            var rules = new List<ConstraintRule>();
            foreach (var e in vc.Expressions)
            {
                var op = e.IsNegated ? Negate(e.Operator) : e.Operator;
                rules.Add(new ConstraintRule
                {
                    TargetName = target,
                    Operator = CompareSymbol(op),
                    Value = ToValue(e.Value)
                });
            }
            ConstraintGroup? group = null;
            if (vc.Operators.Count > 0)
            {
                // pretpostavka - ako ima vise operatora svi su ili AND ili OR, ne moze mix
                // ako hocemo mix tu bismo morali zagradama da odvajamo prioritet,
                // za sad cemo zanemariti tu mogucnost
                if (vc.Operators[0] == LogicalOperator.And)
                    group = ConstraintGroup.AND;
                else
                    group = ConstraintGroup.OR;
            }
            return new ConstraintUI(rules, group);
        }

        private static Value ToValue(ConstraintValue cv) => cv switch
        {
            NumericConstraintValue n => new NumericValue(n.Value),
            StringConstraintValue s => new StringValue(s.Value),
            DateConstraintValue d => new DateValue(d.Value),
            DateKeywordConstraintValue k => new StringValue(k.Keyword.ToString().ToLowerInvariant()), // "today"/"now" simbolicno
            _ => throw new ArgumentException($"Unknown ConstraintValue: {cv.GetType().Name}")
        };

        private static string CompareSymbol(ComparisonOperator op) => op switch
        {
            ComparisonOperator.GreaterThan => ">",
            ComparisonOperator.LessThan => "<",
            ComparisonOperator.GreaterOrEqual => ">=",
            ComparisonOperator.LessOrEqual => "<=",
            ComparisonOperator.Equal => "=",
            ComparisonOperator.NotEqual => "!=",
            _ => throw new ArgumentException($"Nepoznat operator: {op}")
        };

        // NOT poredjenje -> obrni operator (NOT > je <=, NOT = je !=, ...)
        private static ComparisonOperator Negate(ComparisonOperator op) => op switch
        {
            ComparisonOperator.GreaterThan => ComparisonOperator.LessOrEqual,
            ComparisonOperator.LessOrEqual => ComparisonOperator.GreaterThan,
            ComparisonOperator.LessThan => ComparisonOperator.GreaterOrEqual,
            ComparisonOperator.GreaterOrEqual => ComparisonOperator.LessThan,
            ComparisonOperator.Equal => ComparisonOperator.NotEqual,
            ComparisonOperator.NotEqual => ComparisonOperator.Equal,
            _ => op
        };

        // Aritmeticko ogranicenje ("= izraz") i agregatne funkcije ("SUM (naziv)")
        // ArithmeticConstraint -> ComputedValue (+ kontrola IsReadOnly=true).
        private ConstraintUI? BuildComputedValue(ConstraintExpression? constraint, string scopeId)
        {
            if (constraint is not ArithmeticConstraint ac)
                return null;
            return new ConstraintUI(new() { ToComputedValue(ac.Expression, scopeId) });

        }

        private ConstraintRule ToComputedValue(ArithmeticExpression expression, string scopeId) => expression switch
        {
            BinaryArithmeticExpression b => new ConstraintRule
            {
                Operator = ArithmeticSymbol(b.Operator),
                Operands = new() { ToOperand(b.Left, scopeId), ToOperand(b.Right, scopeId) },
            },
            AggregateFunctionExpression a => new ConstraintRule
            {
                Operator = a.Function.ToString().ToUpperInvariant(), //SUM, AVG, ...
                Operands = new()
                {
                    new ConstraintOperand
                    {
                        TargetName = OperandTargetName(a.ComponentName, scopeId)
                    }
                }
            },
            _ => throw new ArgumentException($"Unexpected arithmetic expression: {expression.GetType().Name}")
        };

        private ConstraintOperand ToOperand(ArithmeticExpression expression, string scopeId) => expression switch
        {
            // npr. <= cena
            ComponentReferenceExpression c => new ConstraintOperand
            {
                TargetName = OperandTargetName(c.ComponentName, scopeId)
            },
            // npr. <= 5
            NumericLiteralExpression n => new ConstraintOperand
            {
                Value = new NumericValue(n.Value)
            },
            // neki slozeniji izraz
            _ => new ConstraintOperand
            {
                Expression = ToComputedValue(expression, scopeId)
            }
        };

        private string ArithmeticSymbol(ArithmeticOperator @operator) => @operator switch
        {
            ArithmeticOperator.Minus => "-",
            ArithmeticOperator.Plus => "+",
            ArithmeticOperator.Multiply => "*",
            ArithmeticOperator.Divide => "/",
            _ => throw new ArgumentException($"Unknown arithmetic operator: {@operator}")
        };


    }
}
