using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class FilePickerControl : DataControl
    {
        public required object FileFormat { get; set; } //tip?? object za pocetak       
        [SetsRequiredMembers]
        public FilePickerControl(int id, string name, object dataType, object defaultValue,
             string label, bool isReadOnly, bool isRequired, object fileFormat)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired)
        {
            FileFormat = fileFormat;
        }
    }
}



