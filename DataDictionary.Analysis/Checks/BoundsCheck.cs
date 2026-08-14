using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Provera granica BETWEEN ogranicenja: donja granica ne sme da bude veca od gornje ili jednaka njoj,
    // inace je opseg prazan.
    // Pokriva polja, semanticke domene i logicke funkcije.
    public class BoundsCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var f in symbols.AllFields)
                foreach (var e in CheckConstraint(f.Constraint, $"Field '{f.Name}'"))
                    yield return e;

            foreach (var sd in model.SemanticDomains ?? Enumerable.Empty<SemanticDomain>())
                foreach (var e in CheckConstraint(sd.DefinitionalConstraint, $"Semantic domain '{sd.Name}'"))
                    yield return e;

            foreach (var lf in model.LogicalFunctions ?? Enumerable.Empty<LogicalFunction>())
                foreach (var e in CheckConstraint(lf.Definition, $"Logical function '{lf.Name}'"))
                    yield return e;
        }

        private static IEnumerable<SemanticError> CheckConstraint(ConstraintExpression? constraint, string owner)
        {
            if (constraint is not BetweenConstraint bc) yield break;

            int? cmp = Compare(bc.LowerBound, bc.UpperBound);
            if (cmp is >= 0)   // donja >= gornja
                yield return new SemanticError(
                    $"{owner} has an invalid BETWEEN range: lower bound is greater than upper bound.",
                    SemanticRule.WrongBounds);
        }

        // Uporedi dve granice; null ako nisu istog uporedivog tipa
        // neusaglasenost tipova hvata ConstraintDomainCompatibilityCheck
        private static int? Compare(ConstraintValue a, ConstraintValue b)
        {
            if (a is NumericConstraintValue na && b is NumericConstraintValue nb)
                return na.Value.CompareTo(nb.Value);
            if (a is DateConstraintValue da && b is DateConstraintValue db)
                return da.Value.CompareTo(db.Value);
            return null;
        }
    }
}
