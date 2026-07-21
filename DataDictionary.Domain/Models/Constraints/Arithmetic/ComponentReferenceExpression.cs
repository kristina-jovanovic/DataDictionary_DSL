namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class ComponentReferenceExpression : ArithmeticExpression
    {
        public required string ComponentName { get; set; }
        public ComponentReferenceExpression(string componentName)
        {
            ComponentName = componentName;
        }
    }
}
