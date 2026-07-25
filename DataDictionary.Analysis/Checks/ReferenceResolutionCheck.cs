using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Svaka referenca na komponentu mora da se razresi na TACNO jedno polje u celom recniku
    //   symbols.FindFields(name).Count == 0  -> UndefinedReference
    //   symbols.FindFields(name).Count > 1   -> dvosmislena referenca
    public class ReferenceResolutionCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var field in symbols.AllFields)
                foreach (var e in CheckConstraintReferences(field.Constraint, $"Field '{field.Name}'", symbols))
                    yield return e;

            //semanticki domeni ne mogu da budu definisani preko polja, necemo proveravati ta ogranicnja
            //logicke funkcije ne mogu da imaju ArithmeticExpression ogranicenje, pa necemo ni proveravati
            //to se proverava u ConstraintTypeCheck
        }
        private IEnumerable<SemanticError> CheckConstraintReferences(
            ConstraintExpression? constraint, string owner, SymbolTable symbols)
        {
            if (constraint is not ArithmeticConstraint ac) yield break;
            foreach (var refName in CollectReferences(ac.Expression))
            {
                var matches = symbols.FindFields(refName);
                if (matches.Count == 0)
                    yield return new SemanticError($"{owner} references unknown component '{refName}'.",
                        SemanticRule.UndefinedReference, refName);
                else if (matches.Count > 1)
                    yield return new SemanticError($"Reference '{refName}' in {owner} is ambiguous ({matches.Count} matches).",
                        SemanticRule.AmbiguousReference, refName);
            }
        }

        private List<string> CollectReferences(ArithmeticExpression expression)
        {
            var references = new List<string>();
            switch (expression)
            {
                case ComponentReferenceExpression cre:
                    references.Add(cre.ComponentName);
                    break;
                case AggregateFunctionExpression ae:
                    references.Add(ae.ComponentName);
                    break;
                case BinaryArithmeticExpression bae:
                    references.AddRange(CollectReferences(bae.Left));
                    references.AddRange(CollectReferences(bae.Right));
                    break;
                case NumericLiteralExpression:
                    break;   // literal — nema referenci
                default:
                    throw new ArgumentException($"Unknown arithmetic expression: {expression.GetType().Name}");
            }
            return references;
        }
    }
}
