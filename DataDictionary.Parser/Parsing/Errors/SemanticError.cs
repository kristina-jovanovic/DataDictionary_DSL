using System.Diagnostics.CodeAnalysis;
using DataDictionary.Parser.Exceptions;   // SemanticRule

namespace DataDictionary.Parser.Parsing.Errors
{
    public class SemanticError : Error
    {
        public string? SymbolName { get; }   // ime elementa na koji se greska odnosi
        public SemanticRule Rule { get; }

        // Model nema pozicije u izvoru, pa se semanticka greska lokalizuje preko SymbolName.
        // Line/Column ostaju 0 (opciono kasnije: provuci ctx.Start iz vizitora u model).
        [SetsRequiredMembers]
        public SemanticError(string message, SemanticRule rule = SemanticRule.Unknown,
            string? symbolName = null, int line = 0, int column = 0)
            : base(line, column, ErrorType.Semantic, message)
        {
            SymbolName = symbolName;
            Rule = rule;
        }
    }
}
