using System;
using System.Collections.Generic;
using System.Text;
using DataDictionary.Domain.Models;

namespace DataDictionary.Parser.Visitors
{
    public class DataDictionaryModelBuilderVisitor : DataDictionaryParserBaseVisitor<DataDictionaryModel>
    {
        //DataDictionaryModel _dd = new DataDictionaryModel();
        public DataDictionaryModel Visit(DataDictionaryParser.DataDictionaryContext context)
        {
            Visit(context);
            //return _dd;
            throw new Exception();
        }
    }
}
