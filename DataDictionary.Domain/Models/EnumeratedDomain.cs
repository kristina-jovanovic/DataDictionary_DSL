using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Models.Constraints;

namespace DataDictionary.Domain.Models
{
    public class EnumeratedDomain : SemanticDomain
    {
        public required List<Value> AllowedValues { get; set; }
        [SetsRequiredMembers]
        public EnumeratedDomain(int id, string name, Domain baseDomain,
            List<Value> allowedValues, ConstraintExpression? constraint = null) : base(id, name, baseDomain, constraint)
        {
            if (allowedValues == null || allowedValues.Count < 2)
            {
                throw new ArgumentException("Allowed values cannot be null or less than 2.", nameof(allowedValues));
            }
            AllowedValues = allowedValues;
        }
    }
}
