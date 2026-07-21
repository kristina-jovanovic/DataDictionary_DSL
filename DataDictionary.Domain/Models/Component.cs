using System.Diagnostics.CodeAnalysis;
using System.Linq.Expressions;

namespace DataDictionary.Domain.Models
{
    public class Component
    {
        public required int Id { get; set; }
        public required string Name { get; set; }

        [SetsRequiredMembers]
        public Component(int id, string name)
        {
            Id = id;
            Name = name;
        }
    }
}
