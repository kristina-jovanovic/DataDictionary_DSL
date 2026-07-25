using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Polje moze da ima ogranicenje bilo kog tipa,
    // Logicka funkcija i semanticki domen mogu da imaju value constraint, in, between i like ogranicenja
    public class ConstraintTypeCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var logicalFunction in model.LogicalFunctions!)
                foreach (var e in CheckConstraintType(logicalFunction.Definition, $"Logical Function '{logicalFunction.Name}'"))
                    yield return e;
            foreach(var semanticDomain in model.SemanticDomains!)
                foreach (var e in CheckConstraintType(semanticDomain.DefinitionalConstraint, $"Semantic Domain '{semanticDomain.Name}'"))
                    yield return e;
        }

        private IEnumerable<SemanticError> CheckConstraintType(
            ConstraintExpression? constraint, string owner)
        {
            if (constraint is ArithmeticConstraint ac)
                yield return new SemanticError($"{owner} has unsuported type of constraint as a definition: '{ac.GetType()}'.",
                        SemanticRule.InvalidConstraint);

        }
    }
}
