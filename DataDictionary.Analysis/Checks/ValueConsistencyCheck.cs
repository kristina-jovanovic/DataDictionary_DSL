using DataDictionary.Domain.Models;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Vrednosti (nabrojive vrednosti domena i default vrednost polja) moraju da
    // odgovaraju tipu svog domena.
    public class ValueConsistencyCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            // 1) nabrojivi domeni: sve vrednosti moraju biti tipa baznog domena
            foreach (var sd in model.SemanticDomains ?? Enumerable.Empty<SemanticDomain>())
            {
                if (sd is not EnumeratedDomain ed) continue;
                var baseType = SymbolTable.ResolveBaseType(ed.BaseDomain);
                if (baseType == null) continue;   // ciklus u domenu — hvata druga provera
                foreach (var value in ed.AllowedValues)
                    if (!DomainTypeRules.IsCompatible(value, baseType.Value))
                        yield return new SemanticError(
                            $"Enumerated domain '{ed.Name}' has a value that is not of type {baseType.Value}.",
                            SemanticRule.InvalidType, ed.Name);
            }

            // 2) default vrednost polja mora da odgovara domenu polja
            foreach (var field in symbols.AllFields)
            {
                if (field.DefaultValue == null) continue;
                var baseType = SymbolTable.ResolveBaseType(field.DefinedOverDomain);
                if (baseType == null) continue;
                if (!DomainTypeRules.IsCompatible(field.DefaultValue, baseType.Value))
                    yield return new SemanticError(
                        $"Field '{field.Name}' has a default value that is not of type {baseType.Value}.",
                        SemanticRule.InvalidType, field.Name);
            }
        }
    }
}
