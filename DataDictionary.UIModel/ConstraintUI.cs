using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class ConstraintUI
    {
        public ConstraintGroup Group { get; set; }
        public required List<ConstraintRule> Rules { get; set; }
        public List<ConstraintUI>? NestedConstraints { get; set; } = new List<ConstraintUI>();
        [SetsRequiredMembers]
        public ConstraintUI(List<ConstraintRule> rules, ConstraintGroup group = ConstraintGroup.NONE, List<ConstraintUI>? nestedConstraints = null)
        {
            Group = group;
            Rules = rules;
            NestedConstraints = nestedConstraints;
        }
    }
    public class ConstraintRule
    {
        public required string TargetName { get; set; } //naziv kontrole - control->name
        public required string Operator { get; set; } //+,-,*,/,>,<,....
        public required Value Value { get; set; }
        public List<ConstraintRule>? NestedRules { get; set; } = new List<ConstraintRule>();
        [SetsRequiredMembers]
        public ConstraintRule(string targetName, string operator1, Value value,
            List<ConstraintRule>? nestedRules = null)
        {
            TargetName = targetName;
            Operator = operator1;
            Value = value;
            NestedRules = nestedRules;
        }
    }

}



