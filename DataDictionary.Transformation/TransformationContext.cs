namespace DataDictionary.Transformation
{
    // Nosi stanje koje putuje kroz rekurzivni obilazak:
    //  - Ids: deljeni brojac id-jeva (isti kroz celu gradnju)
    //  - TargetNamePrefix: prefiks za kvalifikaciju targetName-a u ogranicenjima
    //
    // Odluka #2: polja UNUTAR Collection template-a dobijaju kvalifikovan targetName
    // (npr. "СтавкаЛисте.Број"), a polja van kolekcije golo ime ("ЕПошта").
    // Zato se pri ulasku u template seta pravi child-kontekst sa postavljenim prefiksom.
    //
    // Kontekst je immutable: WithTargetNamePrefix vraca NOVI kontekst, a Ids
    // ostaje isti (deljeni) objekat, da numeracija tece neprekidno.
    public sealed class TransformationContext
    {
        public IdProvider Ids { get; }
        public string? TargetNamePrefix { get; }

        public TransformationContext(IdProvider ids, string? targetNamePrefix = null)
        {
            Ids = ids;
            TargetNamePrefix = targetNamePrefix;
        }

        // Novi kontekst sa istim brojacem, ali novim prefiksom (za Collection template).
        public TransformationContext WithTargetNamePrefix(string prefix)
            => new(Ids, prefix);

        // Kvalifikuj ime kontrole u targetName prema tekucem prefiksu.
        //   bez prefiksa -> "Број"
        //   sa prefiksom  -> "СтавкаЛисте.Број"
        public string QualifyTargetName(string controlName)
            => TargetNamePrefix is null ? controlName : $"{TargetNamePrefix}.{controlName}";
    }
}
