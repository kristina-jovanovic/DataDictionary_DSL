using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models.Constraints;

namespace DataDictionary.Domain.Models
{
    public class SemanticDomain : Domain
    {
        public required Domain BaseDomain { get; set; }
        public ConstraintExpression? DefinitionalConstraint { get; set; }
        [SetsRequiredMembers]
        public SemanticDomain(int id, string name, Domain baseDomain,
            ConstraintExpression? constraint = null) : base(id, name)
        {
            BaseDomain = baseDomain;
            DefinitionalConstraint = constraint;
        }
    }
}
