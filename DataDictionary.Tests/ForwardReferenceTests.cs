namespace DataDictionary.Tests
{
    // Integracioni test forward-reference: korena struktura referencira strukturu
    // definisanu KASNIJE u fajlu (two-pass razresavanje u vizitoru).
    public class ForwardReferenceTests
    {
        private const string ForwardRefDd = @"DATA DICTIONARY
id: 1
name: ""Test""
author: ""A""
version: ""1""
date of creation: 13.05.2026.
{
    STRUCTURES
    id: 1
    name: ""Root""
    type: dataStore
    <
        id: 2
        name: ""Naslov""
        &
            domain: String
            nullability: not null
        &

        id: 3
        name: ""Referenca""
        # name: ""Globalna"" #
    >

    id: 4
    name: ""Globalna""
    type: dataStore
    <
        id: 5
        name: ""Ulica""
        &
            domain: String
        &

        id: 6
        name: ""Grad""
        &
            domain: String
        &
    >
}";

        [Fact]
        public void ForwardReference_Se_Razresava_I_Transformise()
        {
            // parsira + semantika bez gresaka + transformacija (RunToJson to sve tvrdi)
            var json = Pipeline.RunToJson(ForwardRefDd);

            // referencirana struktura "Globalna" (definisana POSLE korena) je razresena
            // i njena polja se pojavljuju u izlazu
            Assert.Contains("Globalna", json);
            Assert.Contains("\"Ulica\"", json);
            Assert.Contains("\"Grad\"", json);
        }

        [Fact]
        public void ForwardReference_Nema_Laznih_Semantickih_Gresaka()
        {
            // referencirana struktura je isti objekat i na mestu definicije i reference;
            // dedup u SymbolTable sprecava lazan "duplicate id" / "ambiguous".
            var model = Pipeline.ParseOk(ForwardRefDd);
            var errors = Pipeline.Analyze(model);
            Assert.True(errors.Count == 0,
                "Neocekivane greske: " + string.Join("; ", errors.Select(e => e.Message)));
        }
    }
}
