using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models.Constraints.Value
{
    public class ValueConstraint : ConstraintExpression
    {
        public required List<ComparisonExpression> Expressions { get; set; }
        public List<LogicalOperator>? Operators { get; set; }
        public ValueConstraint(List<ComparisonExpression> expressions, List<LogicalOperator>? operators)
        {
            if(operators != null && operators.Count != expressions.Count - 1)
            {
                throw new ArgumentException("Operators count must be one less than expressions count.");
            }
            Expressions = expressions;
            Operators = operators;
        }
    }
}
