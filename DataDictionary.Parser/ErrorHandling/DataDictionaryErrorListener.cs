using System;
using System.Collections.Generic;
using System.Text;
using Antlr4.Runtime;
using DataDictionary.Parser.Parsing;

namespace DataDictionary.Parser.ErrorHandling
{
    internal class DataDictionaryErrorListener : BaseErrorListener
    {
        public List<SyntaxError> Errors { get; set; }
    }
}
