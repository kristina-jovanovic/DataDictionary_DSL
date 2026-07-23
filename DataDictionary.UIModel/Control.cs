using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class Control
    {
        public required int Id { get; set; }
        public required string Name { get; set; }

        [SetsRequiredMembers]
        public Control(int id, string name)
        {
            Id = id;
            Name = name;
        }
    }

}



