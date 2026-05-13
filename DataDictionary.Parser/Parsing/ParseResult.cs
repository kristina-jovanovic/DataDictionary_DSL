using DataDictionary.Domain.Models;

namespace DataDictionary.Parser.Parsing
{
    public class ParseResult
    {
        public bool Success { get; set; }
        public List<SyntaxError>? Errors { get; set; }
        public DataDictionaryModel? Model { get; set; }
    }
}