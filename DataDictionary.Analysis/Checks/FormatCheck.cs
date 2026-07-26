using System.Text.RegularExpressions;
using DataDictionary.Domain;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Format je regex i:
    //  - moze da bude samo nad String domenom
    //  - mora da bude sintaksno validan regularni izraz
    public class FormatCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var field in symbols.AllFields)
            {
                if (field.Format == null) continue;
                var baseType = DomainHelper.ResolveBaseType(field.DefinedOverDomain);
                if (baseType == null) continue;

                if (baseType.Value != PredefinedDomainType.String)
                {
                    yield return new SemanticError(
                        $"Field '{field.Name}' has a format but its domain is {baseType.Value}; format is only allowed on String.",
                        SemanticRule.InvalidType, field.Name);
                    continue;   // nema smisla validirati regex ako domen nije String
                }

                if (!IsValidRegex(field.Format))
                    yield return new SemanticError(
                        $"Field '{field.Name}' has an invalid regular expression format: \"{field.Format}\".",
                        SemanticRule.InvalidType, field.Name);
            }
        }

        // yield ne sme unutar try/catch, pa validaciju radimo u zasebnoj metodi
        private static bool IsValidRegex(string pattern)
        {
            try
            {
                _ = new Regex(pattern);
                return true;
            }
            catch (ArgumentException)   // Regex baca ArgumentException za nevalidnu sintaksu
            {
                return false;
            }
        }
    }
}
