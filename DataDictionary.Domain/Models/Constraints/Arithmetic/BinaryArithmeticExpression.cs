using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class BinaryArithmeticExpression : ArithmeticExpression
    {
        public required ArithmeticExpression Left { get; set; }
        public required ArithmeticOperator Operator { get; set; }
        public required ArithmeticExpression Right { get; set; }
        public BinaryArithmeticExpression(ArithmeticExpression left, 
            ArithmeticOperator op, ArithmeticExpression right)
        {
            Left = left;
            Operator = op;
            Right = right;
        }
    }
}
