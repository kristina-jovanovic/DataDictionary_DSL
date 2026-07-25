using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Domain.Models;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Aritmeticka (racunata) ogranicenja — provera OPERANADA i AGREGATA:
    //  - operandi (referencirana polja) moraju biti numericki
    //  - agregati: SUM/AVG nad numerickim, MIN/MAX nad uredjenim, COUNT nad bilo cim
    // Da racunato POLJE mora biti numericko proverava ConstraintDomainCompatibilityCheck.
    // Postojanje/dvosmislenost reference proverava ReferenceResolutionCheck; ovde se
    // referenca koja se ne razresi na tacno jedno polje preskace (da se ne dupla greska).
    public class ArithmeticCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var field in symbols.AllFields)
            {
                if (field.Constraint is not ArithmeticConstraint ac) continue;

                // provera operanada i agregata u izrazu
                foreach (var e in CheckExpression(field.Name, ac.Expression, symbols))
                    yield return e;
            }
        }

        private IEnumerable<SemanticError> CheckExpression(string owner, ArithmeticExpression expr, SymbolTable symbols)
        {
            switch (expr)
            {
                case NumericLiteralExpression:
                    break;   // broj — uvek numericki

                case ComponentReferenceExpression cre:
                    {
                        var type = ResolveSingleFieldType(cre.ComponentName, symbols);
                        if (type != null && !DomainTypeRules.IsNumeric(type.Value))
                            yield return new SemanticError(
                                $"In '{owner}', component '{cre.ComponentName}' is used in arithmetic but is not numeric ({type.Value}).",
                                SemanticRule.InvalidType, cre.ComponentName);
                        break;
                    }

                case AggregateFunctionExpression ae:
                    {
                        var type = ResolveSingleFieldType(ae.ComponentName, symbols);
                        if (type != null && !IsAggregateCompatible(ae.Function, type.Value))
                            yield return new SemanticError(
                                $"In '{owner}', {ae.Function} cannot be applied to '{ae.ComponentName}' of type {type.Value}.",
                                SemanticRule.InvalidType, ae.ComponentName);
                        break;
                    }

                case BinaryArithmeticExpression bae:
                    foreach (var e in CheckExpression(owner, bae.Left, symbols)) yield return e;
                    foreach (var e in CheckExpression(owner, bae.Right, symbols)) yield return e;
                    break;
            }
        }

        // Tip polja ako se ime razresi na TACNO jedno polje; inace null
        // (0 ili vise -> gresku prijavljuje ReferenceResolutionCheck).
        private static PredefinedDomainType? ResolveSingleFieldType(string name, SymbolTable symbols)
        {
            var matches = symbols.FindFields(name);
            if (matches.Count != 1) return null;
            return SymbolTable.ResolveBaseType(matches[0].DefinedOverDomain);
        }

        private static bool IsAggregateCompatible(AggregateFunction fun, PredefinedDomainType type) => fun switch
        {
            AggregateFunction.Sum or AggregateFunction.Avg => DomainTypeRules.IsNumeric(type),
            AggregateFunction.Min or AggregateFunction.Max => DomainTypeRules.IsOrdered(type),
            AggregateFunction.Count => true,
            _ => true
        };
    }
}
