using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DomainEntity = DataDictionary.Domain.Models.Domain;

namespace DataDictionary.Transformation
{
    public class ResolvedDomain
    {
        // bazni predefinisani tip
        public required PredefinedDomainType BaseType { get; set; }

        // Da li je domen enumerisan -> ComboBox.
        public bool IsEnumerated { get; set; }

        // ako je IsEnumerated=true, treba da se popuni i taj EnumeratedDomain
        public EnumeratedDomain? Enumerated { get; set; }

        // ako je SemanticDomain (ali ne Enumerated), treba zapamtiti DefinitionalConstraint
        public ConstraintExpression? SemanticConstraint { get; set; }
        [SetsRequiredMembers]
        public ResolvedDomain(PredefinedDomainType type, bool isEnumerated = false, EnumeratedDomain? enumerated = null,
            ConstraintExpression? semanticConstraint = null)
        {
            BaseType = type;
            IsEnumerated = isEnumerated;
            Enumerated = enumerated;
            SemanticConstraint = semanticConstraint;
        }
    }

    public static class DomainResolver
    {
        public static ResolvedDomain? Resolve(DomainEntity domain)
        {
            PredefinedDomainType? type = DomainHelper.ResolveBaseType(domain);
            if (type == null)
                return null;

            ResolvedDomain resolvedDomain = new ResolvedDomain((PredefinedDomainType)type);
            if (domain is EnumeratedDomain ed)
            {
                resolvedDomain.IsEnumerated = true;
                resolvedDomain.Enumerated = ed;
            }
            else if (domain is SemanticDomain sd)
            {
                resolvedDomain.SemanticConstraint = sd.DefinitionalConstraint;
            }
            return resolvedDomain;
        }

    }
}
