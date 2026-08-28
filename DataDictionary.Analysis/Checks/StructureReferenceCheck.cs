using DataDictionary.Domain.Models;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis.Checks
{
    // Prijavljuje reference na strukture koje vizitor nije razresio (predstavljene kao
    // UnresolvedStructure jer izgradnja modela ide permisivno): nepoznata struktura ili
    // ciklicna referenca
    public class StructureReferenceCheck : ISemanticCheck
    {
        public IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols)
        {
            foreach (var s in symbols.AllStructures)
                if (s is UnresolvedStructure u)
                    yield return new SemanticError(
                        $"Reference to unknown or cyclic structure '{u.Name}'.",
                        SemanticRule.UndefinedReference, u.Name);
        }
    }
}
