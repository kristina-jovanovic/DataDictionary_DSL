using DataDictionary.Domain.Models;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis
{
    // Jedno semanticko pravilo (jedna kategorija iz plana).
    // Ne baca izuzetke nego vraca sve greske koje nadje, da analyzer moze da ih skupi.
    public interface ISemanticCheck
    {
        IEnumerable<SemanticError> Check(DataDictionaryModel model, SymbolTable symbols);
    }
}
