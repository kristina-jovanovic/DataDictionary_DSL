using System.Diagnostics.CodeAnalysis;
using System.Text.Json.Serialization;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel.Enums;
using DataDictionary.UIModel.Serialization;

namespace DataDictionary.UIModel
{
    // Ogranicenje na data kontroli (RestrictedValue = unos, ComputedValue = racunata vrednost).
    // Ima bar jedno pravilo; kod vise pravila Group (AND/OR) govori kako se kombinuju.
    public class ConstraintUI
    {
        public ConstraintGroup? Group { get; set; }   // null (npr. jedno pravilo) -> ne serijalizuje se
        public required List<ConstraintRule> Rules { get; set; }
        public List<ConstraintUI>? NestedConstraints { get; set; }
        [SetsRequiredMembers]
        public ConstraintUI(List<ConstraintRule> rules, ConstraintGroup? group = null, List<ConstraintUI>? nestedConstraints = null)
        {
            Group = group;
            Rules = rules;
            NestedConstraints = nestedConstraints;
        }
    }

    // Jedno pravilo. U JSON-u je "value" JEDAN kljuc (v. ConstraintRuleJsonConverter):
    //   prosto (poredjenje / LIKE):  { targetName, operator, value }        // value = skalar
    //   racunato / IN:               { operator, value: [operand, ...] }    // value = niz
    // U C#-u su to dva razdvojena svojstva (Value = skalar, Operands = lista)
    [JsonConverter(typeof(ConstraintRuleJsonConverter))]
    public class ConstraintRule
    {
        public string? TargetName { get; set; }              // prosto pravilo; null za computed
        public required string Operator { get; set; }         // ">", "LIKE", "IN", "*", "SUM", ...
        public Value? Value { get; set; }                     // prosto pravilo: skalar -> "value": x
        public List<ConstraintOperand>? Operands { get; set; } // computed/IN: lista -> "value": [ ... ]
    }

    // Operand racunatog izraza: referenca na kontrolu, literal, ili ugnjezden izraz.
    //   { targetName }                       -> referenca
    //   { value }                            -> literal
    //   { expression: {operator, value} }    -> (a+b) unutar veceg izraza
    [JsonConverter(typeof(ConstraintOperandJsonConverter))]
    public class ConstraintOperand
    {
        public string? TargetName { get; set; }
        public Value? Value { get; set; }
        public ConstraintRule? Expression { get; set; }
    }
}
