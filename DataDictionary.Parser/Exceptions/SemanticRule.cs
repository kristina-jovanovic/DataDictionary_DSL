namespace DataDictionary.Parser.Exceptions
{
    public enum SemanticRule
    {
        Unknown,
        DuplicateName,        // dva entiteta/atributa istog imena
        UndefinedReference,   // referenca na nepostojeci entitet
        AmbiguousReference,   // referenca koja nije jedinstvena
        InvalidType,          // nedozvoljen tip atributa
                              // ...
    }
}
