using System.Linq.Expressions;

namespace DataDictionary.Domain.Models
{
    public class Component
    {
        public required int Id { get; set; }
        public required string Name { get; set; }

        public Component(int id, string name)
        {
            Id = id;
            Name = name;
        }
    }
}
