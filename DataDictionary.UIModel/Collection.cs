using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class Collection : Control
    {
        public required Control TemplateControl { get; set; }
        [SetsRequiredMembers]
        public Collection(int id, string name, Control templateContron) : base(id, name)
        {
            TemplateControl = templateContron;
        }
    }
}



