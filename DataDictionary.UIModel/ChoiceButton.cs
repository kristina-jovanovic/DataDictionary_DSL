using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class ChoiceButton : DataControl
    {
        public required string GroupName { get; set; }
        public required string OptionValue { get; set; } //naziv opcije, pored checkboxa ili radiobuttona
        

        [SetsRequiredMembers]
        public ChoiceButton(int id, string name, string label, bool isRequired,
            string groupName, string optionValue, BooleanValue? defaultValue = null) //default treba da bude false
            : base(id, name, PredefinedDomainType.Boolean, label, isRequired, defaultValue)
        {
            GroupName = groupName;
            OptionValue = optionValue;
        }
    }


    public class CheckBoxControl : ChoiceButton
    {
        [SetsRequiredMembers]
        public CheckBoxControl(int id, string name, string label, bool isRequired,
            string groupName, string optionValue)
            : base(id, name, label, isRequired, groupName, optionValue)
        {

        }
    }
    public class RadioButtonControl : ChoiceButton
    {
        [SetsRequiredMembers]
        public RadioButtonControl(int id, string name, string label, bool isRequired,
            string groupName, string optionValue)
            : base(id, name, label, isRequired, groupName, optionValue)
        {
        }
    }
}



