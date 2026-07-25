using System;
using System.Collections.Generic;
using System.Text;
using Antlr4.Runtime;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Parser.ErrorHandling
{
    internal class DataDictionaryErrorListener : BaseErrorListener, IAntlrErrorListener<int>
    {
        public List<Error> Errors { get; } = new();
        // Parser: sintaksne greske
        public override void SyntaxError(TextWriter output, IRecognizer recognizer,
        IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            // koji su tokeni bili ocekivani na tom mestu:
            string? expected = e?.GetExpectedTokens()?.ToString(recognizer.Vocabulary);

            Errors.Add(new SyntaxError(
                line, charPositionInLine, msg,
                offendingToken: offendingSymbol?.Text,
                offendingTokenType: offendingSymbol?.Type ?? 0,
                expected: expected));
        }
        // Lekser: leksicke greske
        public void SyntaxError(TextWriter output, IRecognizer recognizer, int offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            var lexer = (Lexer)recognizer;
            // tekst koji lekser trenutno pokusava da prepozna:
            string offending = lexer.InputStream is ICharStream cs
                ? ((char)offendingSymbol).ToString()
                : msg;
            Errors.Add(new LexicalError(line, charPositionInLine, offending, msg));
        }
    }
}
