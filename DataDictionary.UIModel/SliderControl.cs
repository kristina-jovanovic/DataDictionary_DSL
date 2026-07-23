using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class SliderControl : DataControl
    {
        public required double Min { get; set; } //tipovi??
        public required double Max { get; set; }
        public required double Step { get; set; }
        [SetsRequiredMembers]
        public SliderControl(int id, string name, object dataType, object defaultValue,
            string label, bool isReadOnly, bool isRequired,
            double minValue, double maxValue, double step)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired)
        {
            Min = minValue;
            Max = maxValue;
            Step = step;
        }
    }
}



