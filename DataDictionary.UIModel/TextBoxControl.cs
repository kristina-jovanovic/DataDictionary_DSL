using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class TextBoxControl : DataControl
    {
        public string? Pattern { get; set; } = null;
        public int? MaxLength { get; set; } = null;
        public int? MinLength { get; set; } = null;
        public object? EditorStyle { get; set; } = null; //ovo proveriti

        [SetsRequiredMembers]
        public TextBoxControl(int id, string name, object dataType, object defaultValue,
            string label, bool isReadOnly, bool isRequired,
            string? pattern = null, int? maxLength = null, int? minLength = null, object? editorStyle = null)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired)
        {
            Pattern = pattern;
            MaxLength = maxLength;
            MinLength = minLength;
            EditorStyle = editorStyle;
        }
    }


}



