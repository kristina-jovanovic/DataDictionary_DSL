using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models
{
    public abstract class Domain
    {
        public required int Id { get; set; }
        public required string Name { get; set; }
        [SetsRequiredMembers]
        protected Domain(int id, string name)
        {
            Id = id;
            Name = name;
        }
    }

}
