namespace DataDictionary.Tests
{
    // Polje sa IN ogranicenjem -> ComboBox (IN je nabrajanje dozvoljenih vrednosti) restrictedValue se izostavlja jer stavke ComboBox-a vec nose ogranicenje.
    public class InComboBoxTests
    {
        private const string InDd = """
            DATA DICTIONARY
            id: 97
            name: "Тест IN"
            author: "КЈ"
            version: "1"
            date of creation: 28.08.2026.
            {
                STRUCTURES
                id: 1
                name: "Плаћање"
                type: dataStore
                <
                    id: 2
                    name: "Валута"
                    &
                        domain: String
                        nullability: not null
                        constraint: IN("EUR","USD","RSD")
                    &

                    id: 3
                    name: "Активан"
                    &
                        domain: Logical
                    &
                >
            }
            """;

        // --- POZITIVAN: IN polje daje ComboBox sa stavkama, bez restrictedValue ---
        [Fact]
        public void FieldWithInConstraintBecomesComboBox()
        {
            var json = Pipeline.RunToJson(InDd);

            Assert.Contains("\"ComboBox\"", json);
            Assert.Contains("EUR", json);
            Assert.Contains("USD", json);
            Assert.Contains("RSD", json);
            // IN se ne duplira kao restrictedValue (stavke nose ogranicenje)
            Assert.DoesNotContain("\"IN\"", json);
            Assert.DoesNotContain("restrictedValue", json);
        }

        // --- NEGATIVAN: IN sa samo 1 vrednoscu -> parser prijavi gresku, ne puca (gramatika trazi >=2) ---
        [Fact]
        public void InConstraintWithSingleValueFailsToParse()
        {
            var dd = InDd.Replace("IN(\"EUR\",\"USD\",\"RSD\")", "IN(\"EUR\")");

            var result = Pipeline.Parse(dd);

            Assert.False(result.Success);
            Assert.NotNull(result.Errors);
            Assert.NotEmpty(result.Errors!);
        }
    }
}
