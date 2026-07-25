using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Parser.Parsing.Errors
{
    public class Error
    {
        public required int Line { get; set; }
        public required int Column { get; set; }
        public string? Message { get; set; }
        public required ErrorType ErrorType { get; set; }
        [SetsRequiredMembers]
        public Error(int line, int column, ErrorType type, string? message = null)
        {
            Line = line;
            Column = column;
            ErrorType = type;
            Message = message;
        }
    }
}
