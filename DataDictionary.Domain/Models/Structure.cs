using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    public class Structure : Component
    {
        public required StructureType StructureType { get; set; }
        public required List<Component> Components { get; set; }


    }
}
