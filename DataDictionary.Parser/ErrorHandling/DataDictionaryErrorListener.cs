using System;
using System.Collections.Generic;
using System.Text;
using Antlr4.Runtime;
using DataDictionary.Parser.Parsing;

namespace DataDictionary.Parser.ErrorHandling
{
    internal class DataDictionaryErrorListener : BaseErrorListener
    {
        public List<SyntaxError> Errors { get; } = new();
        public override void SyntaxError(TextWriter output, IRecognizer recognizer,
        IToken offendingSymbol, int line, int charPositionInLine, string msg, RecognitionException e)
        {
            Errors.Add(new SyntaxError { Line = line, Column = charPositionInLine, Message = msg });
        }
    }
}
