using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class Panel : Control
    {
        public string? Title { get; set; }
        public string? TabGroupName { get; set; }
        public required List<Control> Controls { get; set; }
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



