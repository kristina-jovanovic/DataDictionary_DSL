using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    public class Structure : Component
    {
        public required StructureType StructureType { get; set; }
        public required List<Construction> Constructions { get; set; }

        [SetsRequiredMembers]
        public Structure(int id, string name, StructureType structureType,
            List<Construction> constructions) : base(id, name)
        {
            StructureType = structureType;
            Constructions = constructions;
        }
    }
}
