using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    // Placeholder za referencu na strukturu koju vizitor nije razresio
    // (permisivna gradnja - ne baca izuzetak): nepoznata struktura ili ciklicna referenca.
    // Name = trazeno (nerazreseno) ime. Ovu pojavu prijavljuje StructureReferenceCheck
    // u semantickoj fazi (paralelno UnresolvedDomain / DomainReferenceCheck).
    public class UnresolvedStructure : Structure
    {
        [SetsRequiredMembers]
        public UnresolvedStructure(string name)
            : base(0, name, StructureType.DataStore, new List<Construction>())
        {
        }
    }
}
