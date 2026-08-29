namespace DataDictionary.Tests
{
    // Ciljane provere transformacije nad izlaznim JSON-om svakog primera:
    // mapiranja konstrukcija/domena, kvalifikacija targetName-a, ogranicenja.
    public class TransformationTests
    {
        // ---------- PopisInventara ----------

        [Fact]
        public void SetBecomesCollectionAndSpecializationCheckBox()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.PopisInventara));
            Assert.Contains("\"Collection\"", json);   // Set "Ставка листе" -> Collection
            Assert.Contains("\"CheckBox\"", json);      // inkluzivna spec. "Испорука" -> CheckBox-ovi
        }

        [Fact]
        public void ArithmeticInCollectionIsQualified()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.PopisInventara));
            // "Укупна цена" = "Количина" * "Цена по комаду" (sve u Set-u) -> operandi sa prefiksom Set-a
            Assert.Contains("СтавкаЛисте.Количина", json);
            Assert.Contains("СтавкаЛисте.ЦенаПоКомаду", json);
        }

        [Fact]
        public void SumCrossScopeQualifiedInSet()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.PopisInventara));
            // "Укупна вредност" = SUM("Укупна цена"): polje je u Set-u -> kvalifikovano
            Assert.Contains("СтавкаЛисте.УкупнаЦена", json);
            Assert.Contains("\"SUM\"", json);
            Assert.Contains("isReadOnly", json);        // racunato polje -> read-only
        }

        [Fact]
        public void LikeConstraint()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.PopisInventara));
            Assert.Contains("\"LIKE\"", json);          // "Е пошта" LIKE "%@%.%"
        }

        // ---------- IspitnaPrijava ----------

        [Fact]
        public void ForwardReferenceResolved()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.IspitnaPrijava));
            // strukture referencirane UNAPRED (definisane posle korena) se pojave kao paneli
            Assert.Contains("ПодациОСтуденту", json);
            Assert.Contains("ПодациОИспиту", json);
            Assert.Contains("ПодациООцени", json);
        }

        [Fact]
        public void ExclusiveAndInclusiveSpecializationResolved()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.IspitnaPrijava));
            Assert.Contains("\"RadioButton\"", json);   // "Статус студента" [ ] -> ekskluzivna
            Assert.Contains("\"CheckBox\"", json);      // "Посебан статус студента" / / -> inkluzivna
        }

        [Fact]
        public void BetweenDomainGivesTwoBounds()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.IspitnaPrijava));
            // "Оцена" nad domenom "ДОцена" (BETWEEN (5,10)) -> >=5 i <=10
            Assert.Contains("\"value\": 5", json);
            Assert.Contains("\"value\": 10", json);
        }

        [Fact]
        public void NameInTheSameStructure()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.IspitnaPrijava));
            // "Укупни поени" = "Предиспитни поени" + "Поени на испиту" (sve u "Подаци о оцени")
            // -> operandi su GOLI nazivi (ista struktura), NE kvalifikovani pod punim imenom
            Assert.Contains("\"+\"", json);
            Assert.DoesNotContain("ПодациООцени.ПредиспитниПоени", json);
        }

        // ---------- RezervacijaAvioKarata ----------

        [Fact]
        public void SumCrossScopeQualified()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.RezervacijaAvioKarata));
            // SUM iz "Обрачун" u drugu strukturu -> roditelj.ime
            Assert.Contains("СтавкаРезервације.ЦенаКарте", json);
            Assert.Contains("ДодатнеУслуге.ЦенаУслуге", json);
        }

        [Fact]
        public void NamesNotationAndEnumeratedDomainComboBox()
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(Pipeline.RezervacijaAvioKarata));
            // "Укупан износ" = Цена карата + Аеродромске таксе + Цена додатних услуга (isti "Обрачун") -> golo
            Assert.Contains("\"targetName\": \"ЦенаКарата\"", json);
            Assert.DoesNotContain("Обрачун.ЦенаКарата", json);
            // "Ставка резервације" je Set -> Collection; domen "ДСтатус" je enumerisan -> ComboBox sa stavkama
            Assert.Contains("\"Collection\"", json);
            Assert.Contains("\"ComboBox\"", json);
            Assert.Contains("потврђена", json);
        }
    }
}
