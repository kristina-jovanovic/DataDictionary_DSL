using System;
using System.Collections.Generic;
using System.Text;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DomainEntity = DataDictionary.Domain.Models.Domain;


namespace DataDictionary.Domain
{
    public static class DomainHelper
    {
        // Efektivni predefinisani tip domena — prati semanticki domen do baze.
        // Guard protiv ciklusa (A base B, B base A); ciklus prijavljuje zasebna provera.
        public static PredefinedDomainType? ResolveBaseType(DomainEntity domain)
        {
            var seen = new HashSet<DomainEntity>(); //HashMap sadrzi jedinstvene elemente
            var current = domain;
            while (current is SemanticDomain sd)
            {
                if (!seen.Add(current)) return null;   // ciklus
                current = sd.BaseDomain;
            }
            return current is PredefinedDomain pd ? pd.Type : null;
        }
    }
}
