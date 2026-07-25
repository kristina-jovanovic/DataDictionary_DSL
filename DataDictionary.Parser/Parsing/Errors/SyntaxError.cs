using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;

namespace DataDictionary.Parser.Parsing.Errors
{
    public class SyntaxError : Error
    {
        public string? OffendingToken { get; }    // tekst tokena, npr. "}"
        public int OffendingTokenType { get; }    // numericki tip tokena
        public string? ExpectedTokens { get; }    // sta je parser ocekivao umesto toga

        [SetsRequiredMembers]
        public SyntaxError(int line, int column, string? message,
            string? offendingToken = null, int offendingTokenType = 0, string? expected = null)
            : base(line, column, ErrorType.Syntax, message)
        {
            OffendingToken = offendingToken;
            OffendingTokenType = offendingTokenType;
            ExpectedTokens = expected;
        }
    }
}
