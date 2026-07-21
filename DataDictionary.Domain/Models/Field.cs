using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models.Constraints;

namespace DataDictionary.Domain.Models
{
    public class Field<T> : Component
    {
        //public string DomainReference { get; set; } //nekako proveriti, ako nije ni jedan od BaseDomain-a, onda je semanticki domen
        //mada je ovo u stvari naziv domena, svakako mora da bude string? zato sto tu treba da pise Integer,... a ne neka Int vrednost
        //ako ubacim generics <>, onda mi ovo i ne treba kao property
        public Nullability? Nullability { get; set; }
        public string? Format { get; set; } // ovo ce da bude regex ili cobol like zapis, treba uraditi proveru kroz semantiku
        public ConstraintExpression? Constraint { get; set; }
        public T? DefaultValue { get; set; }
        public string? Note { get; set; }
        public Field(int id, string name, Nullability? nullability = null,
            string? format = null, ConstraintExpression? constraint = null,
            T? defaultValue = default(T), string? note = null) : base(id, name)
        {
            Nullability = nullability;
            Format = format;
            Constraint = constraint;
            DefaultValue = defaultValue;
            Note = note;
        }
    }
}
