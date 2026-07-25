using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    // fiksan skup od 5 tipova, postoje kao deljeni singltoni umesto da se prave
    // stalno novi objekti 
    // id-jevi su negativni da se ne bi poklopili sa id-jevima semantickih
    // domena koji dolaze iz DSL ulaza (id: 1, 2, ...).
    public static class PredefinedDomains
    {
        public static PredefinedDomain String { get; } =
            new PredefinedDomain(-1, "String", PredefinedDomainType.String);
        public static PredefinedDomain Integer { get; } =
            new PredefinedDomain(-2, "Integer", PredefinedDomainType.Integer);
        public static PredefinedDomain Real { get; } =
            new PredefinedDomain(-3, "Real", PredefinedDomainType.Real);
        public static PredefinedDomain Boolean { get; } =
            new PredefinedDomain(-4, "Logical", PredefinedDomainType.Logical);
        public static PredefinedDomain Date { get; } =
            new PredefinedDomain(-5, "Date", PredefinedDomainType.Date);
        public static PredefinedDomain Graphic { get; } =
            new PredefinedDomain(-6, "Graphic", PredefinedDomainType.Graphic);

        // mapiranje iz DSL kljucne reci (BASE_DOMAIN token) u odgovarajuci singleton
        public static PredefinedDomain FromKeyword(string keyword) => keyword switch
        {
            "String" => String,
            "Integer" => Integer,
            "Real" => Real,
            "Logical" => Boolean,
            "Date" => Date,
            "Graphic" => Graphic,
            _ => throw new ArgumentException($"Unknown predefined domain: {keyword}", nameof(keyword))
        };

        // mapiranje iz enum tipa u singleton
        public static PredefinedDomain FromType(PredefinedDomainType type) => type switch
        {
            PredefinedDomainType.String => String,
            PredefinedDomainType.Integer => Integer,
            PredefinedDomainType.Real => Real,
            PredefinedDomainType.Logical => Boolean,
            PredefinedDomainType.Date => Date,
            PredefinedDomainType.Graphic => Graphic,
            _ => throw new ArgumentException($"Unknown predefined domain type: {type}", nameof(type))
        };
    }
}
