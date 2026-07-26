using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class FilePickerControl : DataControl
    {
        public string? FileFormat { get; set; }
        [SetsRequiredMembers]
        public FilePickerControl(int id, string name, string label, bool isRequired,
            Value? defaultValue = null, string? fileFormat = null)
            : base(id, name, PredefinedDomainType.Graphic, label, isRequired, defaultValue)
        {
            FileFormat = fileFormat;
        }
    }
}



