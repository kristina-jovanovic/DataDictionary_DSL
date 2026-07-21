using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class ComponentReferenceExpression : ArithmeticExpression
    {
        public required string ComponentName { get; set; }
        [SetsRequiredMembers]
        public ComponentReferenceExpression(string componentName)
        {
            ComponentName = componentName;
        }
    }
}
