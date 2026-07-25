using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class DateTimePickerControl : DataControl
    {
        public DateTimeMode? Mode { get; set; }
        public DateTime? Min { get; set; }
        public DateTime? Max { get; set; }
        public string? Format { get; set; }

        [SetsRequiredMembers]
        public DateTimePickerControl(int id, string name, string label, bool isRequired,
            DateTimeMode? mode = DateTimeMode.Date, string? format = null,
            DateTime? min = null, DateTime? max = null, DateValue? defaultValue = null)
            : base(id, name, PredefinedDomainType.Date, label, isRequired, defaultValue)
        {
            Mode = mode;
            Min = min;
            Max = max;
            Format = format;
        }
    }
}



