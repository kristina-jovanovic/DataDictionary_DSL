using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models.Constraints.Between
{
    public class BetweenConstraint : ConstraintExpression
    {
        public required ConstraintValue LowerBound { get; set; }
        public required ConstraintValue UpperBound { get; set; }
        [SetsRequiredMembers]
        public BetweenConstraint(ConstraintValue lowerBound, ConstraintValue upperBound)
        {
            LowerBound = lowerBound;
            UpperBound = upperBound;
        }
    }
}
