namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class NumericLiteralExpression : ArithmeticExpression
    {
        public required decimal Value { get; set; }
        public NumericLiteralExpression(decimal value)
        {
            Value = value;
        }
    }
}
