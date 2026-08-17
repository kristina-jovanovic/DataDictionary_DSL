using DataDictionary.Domain.Models;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Prijavljuje domenske reference koje vizitor nije razresio (predstavljene kao
    // UnresolvedDomain jer gradnja modela ide permisivno): domen polja i bazni tip semantickog domena
    public class DomainReferenceCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            // domen polja
            foreach (var field in symbols.AllFields)
                if (field.DefinedOverDomain is UnresolvedDomain u)
                    yield return new SemanticError(
                        $"Field '{field.Name}' references unknown domain '{u.Name}'.",
                        SemanticRule.UndefinedReference, u.Name);

            // bazni tip semantickog domena
            foreach (var sd in model.SemanticDomains ?? Enumerable.Empty<SemanticDomain>())
                if (sd.BaseDomain is UnresolvedDomain u)
                    yield return new SemanticError(
                        $"Semantic domain '{sd.Name}' has unknown base domain '{u.Name}'.",
                        SemanticRule.UndefinedReference, u.Name);
        }
    }
}
