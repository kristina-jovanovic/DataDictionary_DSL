using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models.Constraints.In
{
    public class InConstraint : ConstraintExpression
    {
        public required List<ConstraintValue> Values { get; set; }
        [SetsRequiredMembers]
        public InConstraint(List<ConstraintValue> values)
        {
            if(values == null || values.Count<2)
            {
                throw new ArgumentException("Values count must be at least 2.");
            }
            Values = values;
        }
    }
}
