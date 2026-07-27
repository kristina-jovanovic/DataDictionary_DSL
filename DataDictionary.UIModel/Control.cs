using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;

namespace DataDictionary.UIModel
{
    // Polimorfna serijalizacija: pri serijalizaciji List<Control> upisuje se
    // "type" diskriminator i sva svojstva stvarnog tipa kontrole
    [JsonPolymorphic(TypeDiscriminatorPropertyName = "type")]
    [JsonDerivedType(typeof(Panel), "Panel")]
    [JsonDerivedType(typeof(Collection), "Collection")]
    [JsonDerivedType(typeof(TextBoxControl), "TextBox")]
    [JsonDerivedType(typeof(CheckBoxControl), "CheckBox")]
    [JsonDerivedType(typeof(RadioButtonControl), "RadioButton")]
    [JsonDerivedType(typeof(DateTimePickerControl), "DateTimePicker")]
    [JsonDerivedType(typeof(ComboBoxControl), "ComboBox")]
    [JsonDerivedType(typeof(FilePickerControl), "FilePicker")]
    public class Control
    {
        // Opcija 1: "type" diskriminator STJ uvek pise prvi (ne moze da se pomeri),
        // ali JsonPropertyOrder gura id/name odmah iza njega -> "type, id, name, ...".
        [JsonPropertyOrder(-2)]
        public required int Id { get; set; }
        [JsonPropertyOrder(-1)]
        public required string Name { get; set; }

        [SetsRequiredMembers]
        public Control(int id, string name)
        {
            Id = id;
            Name = name;
        }
    }

}



