using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace DataDictionary.UIModel
{
    public class Panel : Control
    {
        // Redosled: id, name (iz Control), pa title, layout, controls (kao u ciljnom JSON-u)
        [JsonPropertyOrder(1)]
        public string? Title { get; set; }
        [JsonPropertyOrder(2)]
        public string? TabGroupName { get; set; }
        [JsonPropertyOrder(4)]
        public required List<Control> Controls { get; set; }
        [JsonPropertyOrder(3)]
        public required Layout Layout { get; set; }
        [SetsRequiredMembers]
        public Panel(int id, string name, List<Control> controls, Layout layout,
            string? title = null, string? tabGroupName = null) : base(id, name)
        {
            if (controls == null || controls.Count == 0)
                throw new ArgumentException("Controls list cannot be null or empty", nameof(controls));
            Controls = controls;
            Title = title;
            TabGroupName = tabGroupName;
            Layout = layout;
        }
    }
}



