using System;
using System.Collections.Generic;
using System.Text;

namespace DataDictionary.Parser.Exceptions
{
    public class DataDictionaryException : Exception
    {
        public int? Line { get; }
        public int? Column { get; }
        public DataDictionaryException(string message, int? line = null, int? column = null)
            : base(message)
        {
            Line = line;
            Column = column;
        }
    }
}
