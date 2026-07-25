using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Parser.Parsing.Errors
{
    public class LexicalError : Error
    {
        public string? OffendingText { get; }   // karakter/i koji nisu prepoznati, npr. "@"

        [SetsRequiredMembers]
        public LexicalError(int line, int column, string? offendingText, string? message = null)
            : base(line, column, ErrorType.Lexical, message)
        {
            OffendingText = offendingText;
        }
    }
}
