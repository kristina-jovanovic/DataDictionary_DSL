using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class DateTimePickerControl : DataControl
    {
        public required object Mode { get; set; } //proveriti, enum mozda
        public DateTime? Min { get; set; }
        public DateTime? Max { get; set; }
        public required string Format { get; set; } //proveriti, ubaciti neki enum mozda

        [SetsRequiredMembers]
        public DateTimePickerControl(int id, string name, object dataType, object defaultValue,
             string label, bool isReadOnly, bool isRequired, object mode, string format,
            DateTime? min = null, DateTime? max = null)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired)
        {
            Mode = mode;
            Min = min;
            Max = max;
            Format = format;
        }
    }
}



