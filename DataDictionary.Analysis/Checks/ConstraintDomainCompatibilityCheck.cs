using System;
using System.Collections.Generic;
using System.Data;
using System.Globalization;
using System.Text;
using DataDictionary.Domain;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Domain.Models.Constraints.In;
using DataDictionary.Domain.Models.Constraints.Like;
using DataDictionary.Domain.Models.Constraints.Value;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;
using DomainEntity = DataDictionary.Domain.Models.Domain;

namespace DataDictionary.Analysis.Checks
{
    // U gramatici je definisano koje ogranicenje moze sa kojim tipovima,
    // ali moramo da proverimo da li su sve vrednosti iz ogranicenja istog DOMENA
    // nad kojim je to POLJE definisano
    public class ConstraintDomainCompatibilityCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var field in symbols.AllFields)
            {
                if (field.Constraint == null) continue;
                var baseType = DomainHelper.ResolveBaseType(field.DefinedOverDomain);
                if (baseType == null) continue;
                foreach (var e in CheckConstraint(field.Name, field.Constraint, baseType.Value))
                    yield return e;
            }
        }
        private IEnumerable<SemanticError> CheckConstraint(string field, ConstraintExpression c, PredefinedDomainType type)
        {
            switch (c)
            {
                case ValueConstraint vc:
                    foreach (var expr in vc.Expressions)
                        if (!IsCompatible(expr.Value, type))
                            yield return Error(field, expr.Value, type);
                    break;
                case InConstraint ic:
                    foreach (var v in ic.Values)
                        if (!IsCompatible(v, type))
                            yield return Error(field, v, type);
                    break;
                case BetweenConstraint bc:
                    // samo TIP vrednosti; ispravnost granica (donja < gornja) proverava BoundsCheck
                    if (!IsCompatible(bc.LowerBound, type)) yield return Error(field, bc.LowerBound, type);
                    if (!IsCompatible(bc.UpperBound, type)) yield return Error(field, bc.UpperBound, type);
                    break;
                case LikeConstraint when type != PredefinedDomainType.String:
                    yield return new SemanticError($"Field '{field}': LIKE is only allowed on String domain.",
                        SemanticRule.InvalidType, field);
                    break;
                case ArithmeticConstraint when type is not (PredefinedDomainType.Integer or PredefinedDomainType.Real):
                    yield return new SemanticError($"Field '{field}': computed (arithmetic) constraint requires a numeric domain.",
                        SemanticRule.InvalidType, field);
                    break;
            }
        }

        private SemanticError Error(string field, ConstraintValue value, PredefinedDomainType type)
        {
            return new SemanticError($"Field '{field}': All constraint values must be of the same type: {type.ToString()}. " +
                $"\nValue '{ConstraintValueStr(value)}' is the problem.", SemanticRule.InvalidType);
        }
        private string ConstraintValueStr(ConstraintValue v) => v switch
        {
            NumericConstraintValue n => n.Value.ToString(CultureInfo.InvariantCulture),
            StringConstraintValue s => $"\"{s.Value}\"",
            DateConstraintValue d => d.Value.ToString("dd.MM.yyyy."), //zameniti mozda u yyyy-MM-dd zbog Darka
            DateKeywordConstraintValue k => k.Keyword.ToString().ToLowerInvariant(),
            _ => v.ToString() ?? ""
        };

        private static bool IsCompatible(ConstraintValue value, PredefinedDomainType type) => value switch
        {
            NumericConstraintValue => type is PredefinedDomainType.Integer or PredefinedDomainType.Real,
            StringConstraintValue => type is PredefinedDomainType.String,
            DateConstraintValue or DateKeywordConstraintValue => type is PredefinedDomainType.Date,
            _ => false
        };

    }
}
