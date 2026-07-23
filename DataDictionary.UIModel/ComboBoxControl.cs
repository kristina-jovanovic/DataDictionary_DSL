using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class ComboBoxControl : DataControl
    {
        public required bool IsEditable { get; set; }
        public string Placeholder { get; set; } = string.Empty;
        public object SelectionModel { get; set; } = null; //proveriti
        public List<ComboBoxItem> Items { get; set; } = new List<ComboBoxItem>();
        [SetsRequiredMembers]
        public ComboBoxControl(int id, string name, object dataType, object defaultValue,
            string label, bool isReadOnly, bool isRequired, List<ComboBoxItem> items,
            bool isEditable = false, string placeholder = "", object selectionModel = null)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired)
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
        public required object Value { get; set; } //proveriti, generalno je to string
        //ali moze da bude bas taj objekat neki...mada kod nas ce biti string vrv
        [SetsRequiredMembers]
        public ComboBoxItem(int id, string label, object value)
        {
            Id = id;
            Label = label;
            Value = value;
        }
    }
}



