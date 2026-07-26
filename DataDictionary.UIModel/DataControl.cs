using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;

namespace DataDictionary.UIModel
{
    public class DataControl : Control
    {
        public required PredefinedDomainType DataType { get; set; }
        public Value? DefaultValue { get; set; }
        public required string Label { get; set; }
        public required bool IsRequired { get; set; }
        // true samo za racunata polja (ComputedValue); podrazumevano false pa se ne serijalizuje
        [JsonIgnore(Condition = JsonIgnoreCondition.WhenWritingDefault)]
        public bool IsReadOnly { get; set; }
        public ConstraintUI? RestrictedValue { get; set; }
        public ConstraintUI? ComputedValue { get; set; }
        [SetsRequiredMembers]
        public DataControl(int id, string name, PredefinedDomainType dataType,
             string label, bool isRequired = true, Value? defaultValue = null, ConstraintUI? restrictedValue = null,
             ConstraintUI? computedValue = null)
            : base(id, name)
        {
            DataType = dataType;
            DefaultValue = defaultValue;
            Label = label;
            IsRequired = isRequired;
            RestrictedValue = restrictedValue;
            ComputedValue = computedValue;
        }
    }

}



