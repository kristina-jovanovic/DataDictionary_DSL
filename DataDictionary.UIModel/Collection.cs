using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace DataDictionary.UIModel
{
    public class Collection : Control
    {
        [JsonPropertyName("template")]
        public required Control TemplateControl { get; set; }
        [SetsRequiredMembers]
        public Collection(int id, string name, Control templateContron) : base(id, name)
        {
            TemplateControl = templateContron;
        }
    }
}



