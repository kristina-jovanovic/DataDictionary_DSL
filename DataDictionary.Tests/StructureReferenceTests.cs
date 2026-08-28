using DataDictionary.Parser.Exceptions;      // SemanticRule
using DataDictionary.Parser.Parsing.Errors;  // SemanticError

namespace DataDictionary.Tests
{
    // Permisivnost za strukturne reference (paralelno domenu): vizitor ne baca na nerazresenu
    // referencu, nego gradi UnresolvedStructure placeholder, a StructureReferenceCheck prijavi gresku.
    public class StructureReferenceTests
    {
        // Referenca "# name: "НеПостоји" #" na strukturu koja nije deklarisana.
        private const string UnknownRefDd = """
            DATA DICTIONARY
            id: 1
            name: "Тест"
            author: "A"
            version: "1"
            date of creation: 13.05.2026.
            {
                STRUCTURES
                id: 1
                name: "Корен"
                type: dataStore
                <
                    id: 2
                    name: "Поље"
                    &
                        domain: String
                    &

                    id: 3
                    name: "Реф"
                    # name: "НеПостоји" #
                >
            }
            """;

        // Dve top-level strukture koje se uzajamno referenciraju (A -> B -> A).
        private const string CyclicRefDd = """
            DATA DICTIONARY
            id: 1
            name: "Тест"
            author: "A"
            version: "1"
            date of creation: 13.05.2026.
            {
                STRUCTURES
                id: 1
                name: "А"
                type: dataStore
                <
                    id: 2
                    name: "Поље"
                    &
                        domain: String
                    &

                    id: 3
                    name: "РефБ"
                    # name: "Б" #
                >

                id: 4
                name: "Б"
                type: dataStore
                <
                    id: 5
                    name: "Поље2"
                    &
                        domain: String
                    &

                    id: 6
                    name: "РефА"
                    # name: "А" #
                >
            }
            """;

        // --- NEGATIVAN: nepoznata struktura -> parsira permisivno, greska iz semantike (ne puca) ---
        [Fact]
        public void UnknownStructureReferenceIsPermissiveAndReported()
        {
            var model = Pipeline.ParseOk(UnknownRefDd);   // gradnja NE puca (permisivno)
            var errors = Pipeline.Analyze(model);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.UndefinedReference);
        }

        // --- NEGATIVAN: ciklicna referenca -> placeholder prekida ciklus, greska iz semantike (ne puca) ---
        [Fact]
        public void CyclicStructureReferenceIsPermissiveAndReported()
        {
            var model = Pipeline.ParseOk(CyclicRefDd);    // gradnja NE puca (placeholder prekida ciklus)
            var errors = Pipeline.Analyze(model);

            Assert.Contains(errors.OfType<SemanticError>(), e => e.Rule == SemanticRule.UndefinedReference);
        }
    }
}
