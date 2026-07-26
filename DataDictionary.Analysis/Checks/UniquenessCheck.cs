using DataDictionary.Domain.Models;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Jedinstvenost:
    //  NAZIVI (referenciraju se po imenu): semanticki domeni, logicke funkcije.
    //    Nazivi polja SMEJU da se ponove pod globalnim dosegom — dvosmislenost hvata
    //    ReferenceResolutionCheck tek kad se stvarno referenciraju.
    //  ID-jevi (jedinstveni unutar svog prostora):
    //    - komponente medju sobom (struktura JESTE komponenta, pa ulaze i korene i
    //      ugnjezdene strukture i sva polja — sve u jedan prostor)
    //    - semanticki domeni medju sobom
    //    - logicke funkcije medju sobom
    public class UniquenessCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            // --- nazivi ---
            foreach (var e in DuplicateNames(
                (model.SemanticDomains ?? Enumerable.Empty<SemanticDomain>()).Select(sd => sd.Name),
                "Semantic domain"))
                yield return e;

            foreach (var e in DuplicateNames(
                (model.LogicalFunctions ?? Enumerable.Empty<LogicalFunction>()).Select(lf => lf.Name),
                "Logical function"))
                yield return e;

            // --- id-jevi ---
            // komponente = strukture + polja
            // visited (po IDENTITETU objekta): referencirana struktura je ista instanca
            // i na mestu definicije i na mestu reference — broji se samo jednom, da se ne
            // prijavi lazan "duplicate id".
            var componentIds = new List<(int id, string name)>();
            var visited = new HashSet<Component>(ReferenceEqualityComparer.Instance);
            foreach (var root in model.Structures)
                CollectComponentIds(root, componentIds, visited);
            foreach (var e in DuplicateIds(componentIds, "Component"))
                yield return e;

            // semanticki domeni
            foreach (var e in DuplicateIds(
                (model.SemanticDomains ?? Enumerable.Empty<SemanticDomain>()).Select(sd => (sd.Id, sd.Name)),
                "Semantic domain"))
                yield return e;

            // logicke funkcije
            foreach (var e in DuplicateIds(
                (model.LogicalFunctions ?? Enumerable.Empty<LogicalFunction>()).Select(lf => (lf.Id, lf.Name)),
                "Logical function"))
                yield return e;
        }

        // rekurzivno kupi id-jeve svih komponenti (polja i ugnjezdenih struktura)
        private static void CollectComponentIds(Component c, List<(int, string)> acc, HashSet<Component> visited)
        {
            // vec posecena (npr. struktura stigla preko reference) -> ne dupliraj
            if (!visited.Add(c))
                return;
            acc.Add((c.Id, c.Name));
            if (c is Structure s)
                foreach (var con in s.Constructions)
                    foreach (var comp in con.Components)
                        CollectComponentIds(comp, acc, visited);
        }

        private static IEnumerable<SemanticError> DuplicateNames(IEnumerable<string> names, string kind)
        {
            foreach (var group in names.GroupBy(n => n).Where(g => g.Count() > 1))
                yield return new SemanticError(
                    $"{kind} name '{group.Key}' is defined {group.Count()} times; names must be unique.",
                    SemanticRule.DuplicateName, group.Key);
        }

        private static IEnumerable<SemanticError> DuplicateIds(IEnumerable<(int id, string name)> items, string kind)
        {
            foreach (var group in items.GroupBy(x => x.id).Where(g => g.Count() > 1))
                yield return new SemanticError(
                    $"{kind} id {group.Key} is used by {group.Count()} elements ({string.Join(", ", group.Select(x => $"'{x.name}'"))}); ids must be unique.",
                    SemanticRule.DuplicateId);
        }
    }
}
