using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models.Constraints;

namespace DataDictionary.Domain.Models
{
    public class SemanticDomain
    {
        public required int Id { get; set; }
        public required string Name { get; set; }
        public required BaseDomain BaseDomain { get; set; }
        public ConstraintExpression? Constraint { get; set; }
        public List<object>? AllowedValues { get; set; }
        public SemanticDomain(int id, string name, BaseDomain baseDomain,
            ConstraintExpression? constraint = null, List<object>? allowedValues = null)
        {
            Id = id;
            Name = name;
            BaseDomain = baseDomain;
            Constraint = constraint;
            AllowedValues = allowedValues ?? []; //new List<object>()
        }
    }
}
