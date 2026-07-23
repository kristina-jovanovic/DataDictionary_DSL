using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    public class PredefinedDomain : Domain
    {
        public required PredefinedDomainType Type { get; set; }
        [SetsRequiredMembers]
        public PredefinedDomain(int id, string name, PredefinedDomainType type) : base(id, name)
        {
            Type = type;
        }
    }

}
