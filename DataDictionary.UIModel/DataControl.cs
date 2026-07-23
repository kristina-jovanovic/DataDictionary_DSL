using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class DataControl : Control
    {
        public required object DataType { get; set; } // tip?? object za pocetak
        public required object DefaultValue { get; set; } //isto proveriti

        public required string Label { get; set; }
        public required bool IsReadOnly { get; set; } 
        public required bool IsRequired { get; set; }
        public ConstraintUI? RestrictedValue { get; set; }
        public ConstraintUI? ComputedValue { get; set; }
        [SetsRequiredMembers]
        public DataControl(int id, string name, object dataType, object defaultValue,
             string label, bool isReadOnly, bool isRequired, ConstraintUI? restrictedValue = null,
             ConstraintUI? computedValue = null)
            : base(id, name)
        {
            DataType = dataType;
            DefaultValue = defaultValue;
            Label = label;
            IsReadOnly = isReadOnly;
            IsRequired = isRequired;
            RestrictedValue = restrictedValue;
            ComputedValue = computedValue;
        }
    }

}



