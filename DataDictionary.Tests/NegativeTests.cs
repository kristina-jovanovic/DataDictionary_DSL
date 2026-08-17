using DataDictionary.Parser.Exceptions;      // SemanticRule
using DataDictionary.Parser.Parsing.Errors;  // Error, SemanticError, ErrorType

namespace DataDictionary.Tests
{
    // Neispravni slucajevi: uzimamo ispravan primer i uvodimo TACNO jednu gresku
    // (mutacija stringa), pa tvrdimo da se ta greska ispravno prijavljuje.
    public class NegativeTests
    {
        // --- sintaksa: 'name' bez dvotacke (NAME_LABEL je 'name:') ---
        [Fact]
        public void SyntaxErrorSemicolonMissing()
        {
            var dd = Pipeline.LoadExample(Pipeline.PopisInventara)
                .Replace("name: \"Организација\"", "name \"Организација\"");

            var result = Pipeline.Parse(dd);

            Assert.False(result.Success);
            Assert.NotNull(result.Errors);
            Assert.NotEmpty(result.Errors!);
        }

        // --- jedinstvenost: dva ista id-ja u prostoru komponenti ---
        [Fact]
        public void SemanticsDuplicatedId()
        {
            var dd = Pipeline.LoadExample(Pipeline.PopisInventara)
                .Replace("id: 7", "id: 6");   // "Назив" dobija id 6 (isti kao "Број")

            var errors = AnalyzeExpectingParseOk(dd);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.DuplicateId);
        }

        // --- referenca na nepostojece polje u aritmetici ---
        [Fact]
        public void SemanticsUndefinedReference()
        {
            var dd = Pipeline.LoadExample(Pipeline.PopisInventara)
                .Replace("\"Количина\" * \"Цена по комаду\"", "\"Не постоји\" * \"Цена по комаду\"");

            var errors = AnalyzeExpectingParseOk(dd);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.UndefinedReference);
        }

        // --- dvosmislena referenca: dva polja istog imena, jedno se referencira ---
        [Fact]
        public void SemanticsAmbiguousReference()
        {
            var dd = Pipeline.LoadExample(Pipeline.PopisInventara)
                .Replace("name: \"Број\"", "name: \"Цена по комаду\"");   // sad postoje dva "Цена по комаду"

            var errors = AnalyzeExpectingParseOk(dd);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.AmbiguousReference);
        }

        // --- agregatna funkcija (SUM) nad ne-numerickim poljem ---
        [Fact]
        public void SemanticsAggregateOnNonNumericField()
        {
            var dd = Pipeline.LoadExample(Pipeline.PopisInventara)
                .Replace("SUM(\"Укупна цена\")", "SUM(\"Назив\")");   // "Назив" je String

            var errors = AnalyzeExpectingParseOk(dd);

            Assert.Contains(errors, e => e.ErrorType == ErrorType.Semantic);
        }

        // --- BETWEEN sa donjom granicom vecom od gornje (domen "ДОцена") ---
        [Fact]
        public void SemanticsWrongBoundsBetween()
        {
            var dd = Pipeline.LoadExample(Pipeline.IspitnaPrijava)
                .Replace("BETWEEN (5,10)", "BETWEEN (10,5)");

            var errors = AnalyzeExpectingParseOk(dd);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.WrongBounds);
        }

        // --- referenca na nepostojeci domen: vizitor gradi permisivno (ne puca), greska iz semantike ---
        [Fact]
        public void SemanticsUnknownDomain()
        {
            var dd = Pipeline.LoadExample(Pipeline.PopisInventara)
                .Replace("domain: \"ДКоличина\"", "domain: \"Непостоји\"");

            // ParseOk tvrdi da gradnja modela NE PUCA (permisivno), a greska dolazi iz semantike
            var errors = AnalyzeExpectingParseOk(dd);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.UndefinedReference);
        }

        // helper: parsira (mora da bude uspesno), pa vraca semanticke greske
        private static List<Error> AnalyzeExpectingParseOk(string dd)
        {
            var model = Pipeline.ParseOk(dd);
            return Pipeline.Analyze(model);
        }
    }
}
