using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models.Constraints;

namespace DataDictionary.Domain.Models
{
    public class Field : Component
    {
        public required Domain DefinedOverDomain { get; set; }
        public Nullability? Nullability { get; set; }
        public string? Format { get; set; } // ovo ce da bude regex ili cobol like zapis, treba uraditi proveru kroz semantiku
        public ConstraintExpression? Constraint { get; set; }
        public Value? DefaultValue { get; set; }
        public string? Note { get; set; }
        [SetsRequiredMembers]
        public Field(int id, string name, Domain domain, Nullability? nullability = null,
            string? format = null, ConstraintExpression? constraint = null,
            Value? defaultValue = null, string? note = null) : base(id, name)
        {
            DefinedOverDomain = domain;
            Nullability = nullability;
            Format = format;
            Constraint = constraint;
            DefaultValue = defaultValue;
            Note = note;
        }
    }
}
