using Antlr4.Runtime;
using DataDictionary.Domain.Models;
using DataDictionary.Parser.ErrorHandling;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;
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

            lexer.RemoveErrorListeners();
            lexer.AddErrorListener(errorListener);

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
                var type = ex is SemanticException ? ErrorType.Semantic : ErrorType.Syntax;
                return new ParseResult
                {
                    Success = false,
                    Errors = new List<Error>
                    {
                        new Error(ex.Line ?? 0, ex.Column ?? 0, type, ex.Message)
                    }
                };
            }
            catch (Exception ex)
            {
                // Vizitor na nekim "semanticki losim" mestima baca ArgumentException
                // (npr. nepoznat semanticki domen / struktura, neispravan datum)
                // Model nema pozicije u izvoru, pa Line/Column ostaju 0
                return new ParseResult
                {
                    Success = false,
                    Errors = new List<Error>
                    {
                        new Error(0, 0, ErrorType.Semantic, ex.Message)
                    }
                };
            }
        }
    }
}
