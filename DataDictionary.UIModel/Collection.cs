using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class Collection : Control
    {
        //proveriti
        public required List<Control> Controls { get; set; }
        [SetsRequiredMembers]
        public Collection(int id, string name, List<Control> controls) : base(id, name)
        {
            if (controls == null || controls.Count == 0)
                throw new ArgumentException("Controls list cannot be null or empty", nameof(controls));
            Controls = controls;
        }
    }
}



