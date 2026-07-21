using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models.Constraints.Arithmetic
{
    public class AggregateFunctionExpression : ArithmeticExpression
    {
        public required AggregateFunction Function { get; set; }
        public required string ComponentName { get; set; }
        [SetsRequiredMembers]
        public AggregateFunctionExpression(AggregateFunction function, string componentName)
        {
            Function = function;
            ComponentName = componentName;
        }
    }
}
