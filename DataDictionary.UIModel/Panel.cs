using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class Panel : Control
    {
        public required string Title { get; set; }
        public required string TabGroupName { get; set; }
        public required List<Control> Controls { get; set; }
        public required Layout Layout { get; set; }
        [SetsRequiredMembers]
        public Panel(int id, string name, List<Control> controls,
            string title, string tabGroupName, Layout layout) : base(id, name)
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



