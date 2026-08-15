using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Transformation;

namespace DataDictionary.Tests
{
    // Jedinicni testovi pomocne infrastrukture transformacije
    public class InfrastructureUnitTests
    {
        // ---------- IdProvider ----------

        [Fact]
        public void IdProvider_AssignesFrom1()
        {
            var ids = new IdProvider();
            Assert.Equal(1, ids.Next());
            Assert.Equal(2, ids.Next());
            Assert.Equal(3, ids.Next());
        }

        [Fact]
        public void IdProvider_RespectsInitialValue()
        {
            var ids = new IdProvider(5);
            Assert.Equal(5, ids.Next());
            Assert.Equal(6, ids.Next());
        }

        // ---------- TransformationContext ----------

        [Fact]
        public void Context_WithoutPrefix_ReturnsSoloName()
        {
            var ctx = new TransformationContext(new IdProvider());
            Assert.Equal("Број", ctx.QualifyTargetName("Број"));
        }

        [Fact]
        public void Context_WithPrefix_ReturnsFullName()
        {
            var ctx = new TransformationContext(new IdProvider())
                .WithTargetNamePrefix("СтавкаЛисте");
            Assert.Equal("СтавкаЛисте.Број", ctx.QualifyTargetName("Број"));
        }

        [Fact]
        public void Context_WithPrefix_SharesTheSameIdCount()
        {
            var ids = new IdProvider();
            var ctx = new TransformationContext(ids);
            var child = ctx.WithTargetNamePrefix("P");

            // isti IdProvider -> numeracija tece neprekidno kroz child kontekst
            Assert.Equal(1, ctx.Ids.Next());
            Assert.Equal(2, child.Ids.Next());
        }

        // ---------- DomainResolver: ugnjezden semanticki domen ----------

        [Fact]
        public void Resolve_NestedSemanticDomain_ResolvesToBaseType()
        {
            var integer = new PredefinedDomain(1, "Integer", PredefinedDomainType.Integer);
            var positive = new SemanticDomain(2, "Позитиван", integer);
            var grade = new SemanticDomain(3, "Оцена", positive);   // bazni je DRUGI semanticki domen

            var r = DomainResolver.Resolve(grade);

            Assert.NotNull(r);
            Assert.Equal(PredefinedDomainType.Integer, r!.BaseType);   // ide lancem do PredefinedDomain
        }
    }
}
