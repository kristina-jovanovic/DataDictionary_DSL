using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class NumericLiteralExpression : ArithmeticExpression
    {
        public required decimal Value { get; set; }
        [SetsRequiredMembers]
        public NumericLiteralExpression(decimal value)
        {
            Value = value;
        }
    }
}
