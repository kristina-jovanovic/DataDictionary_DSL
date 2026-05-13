using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    public class SemanticDomain
    {
        public required int Id { get; set; }
        public required string Name { get; set; }
        public required BaseDomain BaseDomain { get; set; }
        public ConstraintExpression? Constraint { get; set; }
        public List<object>? AllowedValues { get; set; }
    }
}
