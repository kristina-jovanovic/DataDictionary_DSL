namespace DataDictionary.Parser.Exceptions
{
    public enum SemanticRule
    {
        Unknown,
        DuplicateName,          // dva entiteta/atributa istog imena
        DuplicateId,            // dva entiteta istog id-ja u istom prostoru
        UndefinedReference,     // referenca na nepostojeci entitet
        AmbiguousReference,     // referenca koja nije jedinstvena
        InvalidConstraint,      // nedozvoljen tip ogranicenja
        InvalidType,            // nedozvoljen tip atributa
        WrongBounds,            // donja granica mora da bude manja od gornje
    }
}
