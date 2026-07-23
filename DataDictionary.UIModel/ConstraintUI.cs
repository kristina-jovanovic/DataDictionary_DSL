using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class ConstraintUI
    {
        public required string Group { get; set; } //tip?
        public required List<ConstraintRule> Rules { get; set; }
        public List<ConstraintUI>? NestedConstraints { get; set; } = new List<ConstraintUI>();
        [SetsRequiredMembers]
        public ConstraintUI(string group, List<ConstraintRule> rules, List<ConstraintUI>? nestedConstraints = null)
        {
            Group = group;
            Rules = rules;
            NestedConstraints = nestedConstraints;
        }
    }
    public class ConstraintRule
    {
        public required string TargetName { get; set; }
        public required string Operator { get; set; } //tip?
        public required List<object> Values { get; set; } //tip?
        public List<ConstraintRule>? NestedRules { get; set; } = new List<ConstraintRule>();
        [SetsRequiredMembers]
        public ConstraintRule(string targetName, string operator1, List<object> values,
            List<ConstraintRule>? nestedRules = null)
        {
            TargetName = targetName;
            Operator = operator1;
            Values = values;
            NestedRules = nestedRules;
        }
    }

}



