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

                if (baseType.Value != PredefinedDomainType.String && baseType.Value != PredefinedDomainType.Date
                    && baseType.Value != PredefinedDomainType.Integer && baseType.Value != PredefinedDomainType.Real)
                {
                    yield return new SemanticError(
                        $"Field '{field.Name}' has a format but its domain is {baseType.Value}; format is only allowed on String, Date, Integer or Real.",
                        SemanticRule.InvalidType, field.Name);
                    continue;   // format je dozvoljen za String, Date, Integer i Real
                }

                if (baseType.Value == PredefinedDomainType.String && !IsValidRegex(field.Format)) // validacija regex-a kada je format definisan nad Stringom
                    yield return new SemanticError(
                        $"Field '{field.Name}' has an invalid regular expression format: \"{field.Format}\".",
                        SemanticRule.InvalidType, field.Name);

                if (baseType.Value == PredefinedDomainType.Date && !IsValidDateFormat(field.Format)) // validacija datuma kada je format definisan nad Date
                    yield return new SemanticError(
                        $"Field '{field.Name}' has an invalid date format: \"{field.Format}\".",
                        SemanticRule.InvalidType, field.Name);

                if ((baseType.Value == PredefinedDomainType.Integer || baseType.Value == PredefinedDomainType.Real) && !field.Format.Contains("{n}")) // validacija broja kada je format definisan nad Integer ili Real
                    yield return new SemanticError(
                        $"Field '{field.Name}' has an invalid numeric format: \"{field.Format}\".", // {n} je placeholder za broj, sve osim toga je fiksno "zalepljeno" pored broja (npr. "{n} %", "{n} RSD")
                        SemanticRule.InvalidType, field.Name);
            }
        }

        private bool IsValidDateFormat(string format)
        {
            char[] allowed = { 'd', 'M', 'y', 'H', 'm', 's', '/', '.', '-', ':' };
            return format.All(c => allowed.Contains(c));
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
