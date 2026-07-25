namespace DataDictionary.Parser.Exceptions
{
    public class SemanticException : DataDictionaryException
    {
        public string? SymbolName { get; }
        public SemanticRule Rule { get; }         // vrsta prekrsaja

        public SemanticException(string message, string? symbolName = null,
            SemanticRule rule = SemanticRule.Unknown, int? line = null, int? column = null)
            : base(message, line, column)
        {
            SymbolName = symbolName;
            Rule = rule;
        }
    }
}
