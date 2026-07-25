using DataDictionary.Domain.Models;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Parser.Parsing
{
    public class ParseResult
    {
        public bool Success { get; set; }
        public List<Error>? Errors { get; set; }
        public DataDictionaryModel? Model { get; set; }
    }
}