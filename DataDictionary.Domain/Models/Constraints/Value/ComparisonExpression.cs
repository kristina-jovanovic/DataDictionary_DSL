using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models.Constraints.Value
{
    public class ComparisonExpression
    {
        public bool IsNegated { get; set; }
        public required ComparisonOperator Operator { get; set; }
        public required ConstraintValue Value { get; set; }
        [SetsRequiredMembers]
        public ComparisonExpression(bool isNegated, ComparisonOperator operator1, ConstraintValue value)
        {
            IsNegated = isNegated;
            Operator = operator1;
            Value = value;
        }
    }
}
