namespace DataDictionary.Domain.Models.Constraints.In
{
    public class InConstraint : ConstraintExpression
    {
        public required List<ConstraintValue> Values { get; set; }
        public InConstraint(List<ConstraintValue> values)
        {
            Values = values;
        }
    }
}
