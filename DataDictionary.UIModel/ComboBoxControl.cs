using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class ComboBoxControl : DataControl
    {
        public bool IsEditable { get; set; }
        public string Placeholder { get; set; } = string.Empty;
        public SelectionMode SelectionModel { get; set; }
        public List<ComboBoxItem> Items { get; set; } = new List<ComboBoxItem>();
        [SetsRequiredMembers]
        public ComboBoxControl(int id, string name, PredefinedDomainType dataType,
            string label, bool isRequired, List<ComboBoxItem> items, Value? defaultValue = null,
            bool isEditable = false, string placeholder = "", SelectionMode selectionModel = SelectionMode.Single)
            : base(id, name, dataType, label, isRequired, defaultValue)
        {
            if (items == null || items.Count == 0)
            {
                throw new ArgumentException("Items list cannot be null or empty.", nameof(items));
            }
            Items = items;
            IsEditable = isEditable;
            Placeholder = placeholder;
            SelectionModel = selectionModel;
        }
    }

    public class ComboBoxItem
    {
        public required int Id { get; set; }
        public required string Label { get; set; }
        public required Value Value { get; set; }
        [SetsRequiredMembers]
        public ComboBoxItem(int id, string label, Value value)
        {
            Id = id;
            Label = label;
            Value = value;
        }
    }
}



