namespace DataDictionary.Tests
{
    // Enumerisani domen -> ComboBox. Studijski primeri ne koriste enumerisani domen,
    // pa ovu granu transformacije proveravamo nad inline .dd ulazom.
    public class ComboBoxTests
    {
        // Ispravan .dd: domen "ДПол" je enumerisan (values: ...), polje "Пол" je nad njim.
        private const string EnumDd = """
            DATA DICTIONARY
            id: 99
            name: "Тест ComboBox"
            author: "КЈ"
            version: "1"
            date of creation: 28.08.2026.
            {
                SEMANTIC DOMAIN
                id: 1
                name: "ДПол"
                base: String
                values: ( "Мушки" "Женски" )

                STRUCTURES
                id: 1
                name: "Особа"
                type: dataStore
                <
                    id: 2
                    name: "Пол"
                    &
                        domain: "ДПол"
                        nullability: not null
                    &

                    id: 3
                    name: "Активан"
                    &
                        domain: Logical
                    &
                >
            }
            """;

        // --- POZITIVAN: enumerisani domen daje ComboBox sa stavkama (ne TextBox) ---
        [Fact]
        public void EnumeratedDomainBecomesComboBoxWithItems()
        {
            var json = Pipeline.RunToJson(EnumDd);

            Assert.Contains("\"ComboBox\"", json);   // polje "Пол" -> ComboBox
            Assert.Contains("\"items\"", json);       // dozvoljene vrednosti -> stavke
            Assert.Contains("Мушки", json);
            Assert.Contains("Женски", json);
            // Regresiona brana: enumerisani String NE sme da postane TextBox
            Assert.DoesNotContain("\"TextBox\"", json);
        }

        // --- NEGATIVAN: enumerisani domen sa samo 1 vrednoscu -> parser prijavi gresku, ne puca ---
        [Fact]
        public void EnumeratedDomainWithSingleValueFailsToParse()
        {
            var dd = EnumDd.Replace("( \"Мушки\" \"Женски\" )", "( \"Мушки\" )");

            var result = Pipeline.Parse(dd);

            Assert.False(result.Success);
            Assert.NotNull(result.Errors);
            Assert.NotEmpty(result.Errors!);
        }
    }
}
