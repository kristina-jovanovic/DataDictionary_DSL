using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    public class Construction
    {
        public required ConstructionType ConstructionType { get; set; }
        public required List<Component> Components { get; set; }
        [SetsRequiredMembers]
        public Construction(ConstructionType constructionType, List<Component> components)
        {
            ConstructionType = constructionType;
            Components = components;
        }

    }
}
