using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class ChoiceButton : DataControl
    {
        public required string GroupName { get; set; }
        public required object OptionValue { get; set; } //proveriti, pritom da li treba lista ili samo ovako?
        //treba nam vrv i bool checked
        [SetsRequiredMembers]
        public ChoiceButton(int id, string name, object dataType, object defaultValue,
             string label, bool isReadOnly, bool isRequired,
            string groupName, object optionValue)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired)
        {
            GroupName = groupName;
            OptionValue = optionValue;
        }
    }


    public class CheckBoxControl : ChoiceButton
    {
        [SetsRequiredMembers]
        public CheckBoxControl(int id, string name, object dataType, object defaultValue,
             string label, bool isReadOnly, bool isRequired,
            string groupName, object optionValue)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired,
                  groupName, optionValue)
        {

        }
    }
    public class RadioButtonControl : ChoiceButton
    {
        [SetsRequiredMembers]
        public RadioButtonControl(int id, string name, object dataType, object defaultValue,
            string label, bool isReadOnly, bool isRequired,
            string groupName, object optionValue)
            : base(id, name, dataType, defaultValue, label, isReadOnly, isRequired,
                  groupName, optionValue)
        {
        }
    }
}



