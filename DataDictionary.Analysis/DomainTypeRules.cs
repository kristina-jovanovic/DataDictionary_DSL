using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;

namespace DataDictionary.Analysis
{
    internal static class DomainTypeRules
    {
        // numericki tipovi (nad kojima ima smisla aritmetika, SUM/AVG...)
        public static bool IsNumeric(PredefinedDomainType type)
            => type is PredefinedDomainType.Integer or PredefinedDomainType.Real;

        // uredjeni tipovi (nad kojima ima smisla poredjenje, MIN/MAX, BETWEEN)
        public static bool IsOrdered(PredefinedDomainType type)
            => type is PredefinedDomainType.Integer or PredefinedDomainType.Real or PredefinedDomainType.Date;

        // da li vrednost (Value hijerarhija) odgovara predefinisanom tipu domena
        public static bool IsCompatible(Value value, PredefinedDomainType type) => value switch
        {
            NumericValue => type == PredefinedDomainType.Integer || type == PredefinedDomainType.Real,
            StringValue => type == PredefinedDomainType.String,
            DateValue => type == PredefinedDomainType.Date,
            BooleanValue => type == PredefinedDomainType.Logical,
            _ => false
        };
    }
}
