using DataDictionary.Analysis;
using DataDictionary.Analysis.Checks;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Domain.Models.Constraints.Value;
using DataDictionary.Parser.Exceptions;
using DataDictionary.Transformation;

namespace DataDictionary.Tests
{
    // Jedinicni testovi (bez parsera / fajlova)
    public class UnitTests
    {
        // ---------- NameHelper.ToIdentifier ----------

        [Theory]
        [InlineData("Price per piece", "PricePerPiece")]
        [InlineData("Via e-mail", "ViaEMail")]     // crtica je granica reci
        [InlineData("Организација", "Организација")] // jedna rec ostaje ista
        [InlineData("Цена по комаду", "ЦенаПоКомаду")]
        public void ToIdentifier_MergesWords(string input, string expected)
        {
            Assert.Equal(expected, NameHelper.ToIdentifier(input));
        }

        // ---------- DomainResolver.Resolve ----------

        [Fact]
        public void Resolve_PredefinedDomain_ReturnsBaseType()
        {
            var domain = new PredefinedDomain(1, "Integer", PredefinedDomainType.Integer);

            var r = DomainResolver.Resolve(domain);

            Assert.NotNull(r);
            Assert.Equal(PredefinedDomainType.Integer, r!.BaseType);
            Assert.False(r.IsEnumerated);
            Assert.Null(r.SemanticConstraint);
        }

        [Fact]
        public void Resolve_SemanticDomain_KeepsConstraint()
        {
            var baza = new PredefinedDomain(1, "Integer", PredefinedDomainType.Integer);
            ConstraintExpression ogranicenje = new ValueConstraint(
                new List<ComparisonExpression> { new(false, ComparisonOperator.GreaterThan, new NumericConstraintValue(0)) },
                null);
            var domain = new SemanticDomain(2, "Количина", baza, ogranicenje);

            var r = DomainResolver.Resolve(domain);

            Assert.NotNull(r);
            Assert.Equal(PredefinedDomainType.Integer, r!.BaseType);   // razresava do baznog tipa
            Assert.False(r.IsEnumerated);
            Assert.Same(ogranicenje, r.SemanticConstraint);            // zapamceno za restrictedValue
        }

        [Fact]
        public void Resolve_EnumeratedDomain_IsEnumerated()
        {
            var baza = new PredefinedDomain(1, "String", PredefinedDomainType.String);
            var enumDomain = new EnumeratedDomain(2, "Статус", baza,
                new List<Value> { new StringValue("а"), new StringValue("б") });

            var r = DomainResolver.Resolve(enumDomain);

            Assert.NotNull(r);
            Assert.True(r!.IsEnumerated);
            Assert.Same(enumDomain, r.Enumerated);
            Assert.Equal(PredefinedDomainType.String, r.BaseType);
        }

        // ---------- BoundsCheck ----------

        [Fact]
        public void BoundsCheck_WrongBounds()
        {
            var model = ModelWithFieldAndConstraint(
                new BetweenConstraint(new NumericConstraintValue(10), new NumericConstraintValue(5)));

            var errors = new BoundsCheck().Check(model, new SymbolTable(model)).ToList();

            Assert.Contains(errors, e => e.Rule == SemanticRule.WrongBounds);
        }

        [Fact]
        public void BoundsCheck_RightBounds()
        {
            var model = ModelWithFieldAndConstraint(
                new BetweenConstraint(new NumericConstraintValue(5), new NumericConstraintValue(10)));

            var errors = new BoundsCheck().Check(model, new SymbolTable(model)).ToList();

            Assert.DoesNotContain(errors, e => e.Rule == SemanticRule.WrongBounds);
        }

        // pomocnik: minimalan model sa jednim poljem koje nosi dato ogranicenje
        private static DataDictionaryModel ModelWithFieldAndConstraint(ConstraintExpression constraint)
        {
            var domain = new PredefinedDomain(1, "Integer", PredefinedDomainType.Integer);
            var field = new Field(1, "Оцена", domain, constraint: constraint);
            var structure = new Structure(1, "Root", StructureType.DataStore,
                new List<Construction> { new(ConstructionType.Aggregation, new List<Component> { field }) });
            return new DataDictionaryModel(1, "Test", "A", "1", DateTime.Today, new List<Structure> { structure });
        }
    }
}
