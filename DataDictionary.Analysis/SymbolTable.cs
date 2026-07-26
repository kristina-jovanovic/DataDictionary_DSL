using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DomainEntity = DataDictionary.Domain.Models.Domain;

namespace DataDictionary.Analysis
{
    // Globalna tabela simbola — doseg referenci je CEO recnik.
    // Imena polja mogu da se ponove (npr. dva polja "Name"), pa cuvamo liste;
    // razresavanje reference: 0 = ne postoji, >1 = dvosmisleno, 1 = OK.
    public class SymbolTable
    {
        private readonly Dictionary<string, List<Field>> _fields = new();
        private readonly Dictionary<string, List<Structure>> _structures = new();
        private readonly Dictionary<string, List<SemanticDomain>> _semanticDomains = new();

        public SymbolTable(DataDictionaryModel model)
        {
            if (model.SemanticDomains != null)
                foreach (var sd in model.SemanticDomains)
                    Add(_semanticDomains, sd.Name, sd);

            foreach (var s in model.Structures)
                Index(s);
        }

        private void Index(Component c)
        {
            if (c is Structure s)
            {
                Add(_structures, s.Name, s);
                foreach (var con in s.Constructions)
                    foreach (var comp in con.Components)
                        Index(comp);
            }
            else if (c is Field f)
            {
                Add(_fields, f.Name, f);
            }
        }

        private static void Add<T>(Dictionary<string, List<T>> map, string name, T item)
        {
            if (!map.TryGetValue(name, out var list))
                map[name] = list = new List<T>();
            list.Add(item);
        }

        // razresavanje referenci (doseg = ceo recnik) 
        public IReadOnlyList<Field> FindFields(string name)
            => _fields.TryGetValue(name, out var list) ? list : Array.Empty<Field>();

        public IReadOnlyList<Structure> FindStructures(string name)
            => _structures.TryGetValue(name, out var list) ? list : Array.Empty<Structure>();

        public IReadOnlyList<SemanticDomain> FindSemanticDomains(string name)
            => _semanticDomains.TryGetValue(name, out var list) ? list : Array.Empty<SemanticDomain>();

        // sva polja / domeni (za provere jedinstvenosti, tipova...)
        public IEnumerable<Field> AllFields => _fields.Values.SelectMany(x => x);
        public IEnumerable<Structure> AllStructures => _structures.Values.SelectMany(x => x);


        
    }
}
