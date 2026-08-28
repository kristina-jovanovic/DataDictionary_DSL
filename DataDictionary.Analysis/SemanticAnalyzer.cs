using DataDictionary.Analysis.Checks;
using DataDictionary.Domain.Models;
using DataDictionary.Parser.Parsing.Errors;

namespace DataDictionary.Analysis
{
    // Ulazna tacka semanticke faze: gradi simbolsku tabelu, pokrece sve provere
    // i SKUPLJA sve greske (ne baca na prvu), pa korisnik vidi sve odjednom.
    public class SemanticAnalyzer
    {
        private readonly List<ISemanticCheck> _checks;

        public SemanticAnalyzer()
        {
            // redosled: reference -> tipovi ogranicenja -> vrednosti ->
            // aritmetika/agregati -> jedinstvenost -> format.
            _checks = new List<ISemanticCheck>
            {
                new DomainReferenceCheck(),
                new StructureReferenceCheck(),
                new ReferenceResolutionCheck(),
                new ConstraintTypeCheck(),
                new ConstraintDomainCompatibilityCheck(),
                new ValueConsistencyCheck(),
                new ArithmeticCheck(),
                new UniquenessCheck(),
                new FormatCheck(),
                new BoundsCheck(),
            };
        }

        public List<Error> Analyze(DataDictionaryModel model)
        {
            var symbols = new SymbolTable(model);
            var errors = new List<Error>();
            foreach (var check in _checks)
                errors.AddRange(check.Check(model, symbols));
            return errors;
        }
    }
}
