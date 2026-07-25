using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class ChoiceButton : DataControl
    {
        public required string GroupName { get; set; }
        public required string OptionValue { get; set; } //naziv opcije, pored checkboxa ili radiobuttona
        public required ChoiceType ChoiceType { get; set; }

        [SetsRequiredMembers]
        public ChoiceButton(int id, string name, string label, bool isRequired,
            string groupName, string optionValue, ChoiceType choiceType,
            BooleanValue? defaultValue = null) //default treba da bude false
            : base(id, name, PredefinedDomainType.Boolean, label, isRequired, defaultValue)
        {
            GroupName = groupName;
            OptionValue = optionValue;
            ChoiceType = choiceType;
        }
    }


    public class CheckBoxControl : ChoiceButton
    {
        [SetsRequiredMembers]
        public CheckBoxControl(int id, string name, string label, bool isRequired,
            string groupName, string optionValue)
            : base(id, name, label, isRequired, groupName, optionValue, ChoiceType.CheckBox)
        {

        }
    }
    public class RadioButtonControl : ChoiceButton
    {
        [SetsRequiredMembers]
        public RadioButtonControl(int id, string name, string label, bool isRequired,
            string groupName, string optionValue)
            : base(id, name, label, isRequired, groupName, optionValue, ChoiceType.RadioButton)
        {
        }
    }
}



