using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class TextBoxControl : DataControl
    {
        public string? Pattern { get; set; } = null;
        public int? MaxLength { get; set; } = null;
        public int? MinLength { get; set; } = null;
        public EditorStyle EditorStyle { get; set; }

        [SetsRequiredMembers]
        public TextBoxControl(int id, string name, PredefinedDomainType dataType,
            string label, bool isRequired, Value? defaultValue = null,
            string? pattern = null, int? maxLength = null, int? minLength = null, EditorStyle editorStyle = EditorStyle.SingleLine)
            : base(id, name, dataType, label, isRequired, defaultValue)
        {
            Pattern = pattern;
            MaxLength = maxLength;
            MinLength = minLength;
            EditorStyle = editorStyle;
        }
    }


}



