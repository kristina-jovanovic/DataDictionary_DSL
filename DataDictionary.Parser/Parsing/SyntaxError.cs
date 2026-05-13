using System;
using System.Collections.Generic;
using System.Text;

namespace DataDictionary.Parser.Parsing
{
    public class SyntaxError
    {
        public int Line { get; set; }
        public int Column { get; set; }
        public string? Message { get; set; }

        //ideje za nadogradnju:
        //tip greske - leksicka, sintaksna, semanticka
        //token koji je izazvao gresku

    }
}
