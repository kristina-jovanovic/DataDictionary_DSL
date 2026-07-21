using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class ArithmeticConstraint : ConstraintExpression
    {
        public required ArithmeticExpression Expression { get; set; }
        [SetsRequiredMembers]
        public ArithmeticConstraint(ArithmeticExpression exp)
        {
            Expression = exp;
        }
    }
}
