using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.Domain.Models
{
    // Placeholder za domensku referencu koju vizitor nije uspeo da razresi
    // (permisivna gradnja - ne baca izuzetak): npr. field 'domain: "Не постоји"'
    // gde takav semanticki domen ne postoji. Name = trazeno (nerazreseno) ime.
    // Ovu pojavu prijavljuje DomainReferenceCheck u semantickoj fazi
    public class UnresolvedDomain : Domain
    {
        [SetsRequiredMembers]
        public UnresolvedDomain(string name) : base(0, name)
        {
        }
    }
}
