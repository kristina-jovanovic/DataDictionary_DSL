using DataDictionary.Parser.Exceptions;      // SemanticRule
using DataDictionary.Parser.Parsing.Errors;  // SemanticError

namespace DataDictionary.Tests
{
    // Numericki (Integer/Real) format: "{n}" je placeholder za broj, ostatak je fiksni tekst
    // (npr. "{n} %", "{n} RSD"). Format ide u Pattern TextBox-a (nije regex; Darkov program to razlikuje).
    public class NumericFormatTests
    {
        // Ispravan .dd: polje "Popust" (Integer) ima numericki format "{n} %".
        private const string NumericDd = """
            DATA DICTIONARY
            id: 98
            name: "Тест нумерички формат"
            author: "КЈ"
            version: "1"
            date of creation: 28.08.2026.
            {
                STRUCTURES
                id: 1
                name: "Артикал"
                type: dataStore
                <
                    id: 2
                    name: "Попуст"
                    &
                        domain: Integer
                        format: "{n} %"
                        nullability: not null
                    &

                    id: 3
                    name: "Цена"
                    &
                        domain: Real
                        format: "{n} RSD"
                    &
                >
            }
            """;

        // --- POZITIVAN: numericki format prolazi semantiku i zavrsi u Pattern-u ---
        [Fact]
        public void NumericFormatFlowsIntoPattern()
        {
            var json = Pipeline.RunToJson(NumericDd);

            Assert.Contains("\"pattern\": \"{n} %\"", json);
            Assert.Contains("\"pattern\": \"{n} RSD\"", json);
        }

        // --- NEGATIVAN: numericki format bez {n} placeholder-a -> semanticka greska (ne puca) ---
        [Fact]
        public void NumericFormatWithoutPlaceholderIsSemanticError()
        {
            var dd = NumericDd.Replace("\"{n} %\"", "\"10 %\"");   // nema {n}

            var model = Pipeline.ParseOk(dd);       // parsira se OK (format je STRING)
            var errors = Pipeline.Analyze(model);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.InvalidType);
        }
    }
}
