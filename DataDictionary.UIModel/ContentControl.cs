using System.Diagnostics.CodeAnalysis;
using System.Reflection.Metadata;

namespace DataDictionary.UIModel
{
    public class ContentControl : Control
    {
        public required object Value { get; set; } //object? proveriti.. mozda koristiti Value iz Domain
        [SetsRequiredMembers]
        public ContentControl(int id, string name, object value) : base(id, name)
        {
            Value = value;
        }
    }
    public class LabelControl : ContentControl
    {
        [SetsRequiredMembers]
        public LabelControl(int id, string name, object value) : base(id, name, value)
        {

        }
    }
    public class ProgressBarControl : ContentControl
    {
        [SetsRequiredMembers]
        public ProgressBarControl(int id, string name, object value) : base(id, name, value)
        {

        }
    }
}



