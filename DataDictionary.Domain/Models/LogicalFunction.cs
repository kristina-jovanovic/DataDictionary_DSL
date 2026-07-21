using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Models.Constraints;

namespace DataDictionary.Domain.Models
{
    public class LogicalFunction
    {
        public required int Id { get; set; }
        public required string Name { get; set; }
        public required ConstraintExpression Definition { get; set; }
        public required bool Result { get; set; }

        [SetsRequiredMembers]
        public LogicalFunction(int id, string name, ConstraintExpression definition, bool result)
        {
            Id = id;
            Name = name;
            Definition = definition;
            Result = result;
        }
    }
}
