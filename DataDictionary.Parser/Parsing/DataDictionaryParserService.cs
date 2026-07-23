using Antlr4.Runtime;
using DataDictionary.Domain.Models;
using DataDictionary.Parser.ErrorHandling;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Visitors;

namespace DataDictionary.Parser.Parsing
{
    public class DataDictionaryParserService
    {
        AntlrInputStream inputStream;
        DataDictionaryLexer lexer;
        CommonTokenStream tokenStream;
        DataDictionaryParser parser;

        public DataDictionaryParserService()
        {

        }

        public ParseResult Parse(string input)
        {
            inputStream = new AntlrInputStream(input);
            lexer = new DataDictionaryLexer(inputStream);
            tokenStream = new CommonTokenStream(lexer);
            parser = new DataDictionaryParser(tokenStream);

            var errorListener = new DataDictionaryErrorListener();
            parser.RemoveErrorListeners();
            parser.AddErrorListener(errorListener);
            var context = parser.dataDictionary();
            if (errorListener.Errors.Count > 0)
            {
                return new ParseResult
                {
                    Success = false,
                    Errors = errorListener.Errors
                };
            }
            DataDictionaryModelBuilderVisitor modelBuilder = new DataDictionaryModelBuilderVisitor();
            try
            {
                DataDictionaryModel model = modelBuilder.Visit(context);
                return new ParseResult
                {
                    Success = true,
                    Model = model
                };
            }
            catch (DataDictionaryException ex)
            {
                return new ParseResult
                {
                    Success = false,
                    Errors = new List<SyntaxError> {
                        new()
                        {
                            Line = ex.Line ?? 0,
                            Column = ex.Column ?? 0,
                            Message = ex.Message
                        }
                    }
                };
            }
        }
    }
}
