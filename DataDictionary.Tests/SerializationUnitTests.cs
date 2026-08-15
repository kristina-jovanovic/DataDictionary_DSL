using System.Text.Encodings.Web;
using System.Text.Json;
using System.Text.Json.Serialization;
using DataDictionary.Domain.Models;
using DataDictionary.UIModel;
using DataDictionary.UIModel.Serialization;

namespace DataDictionary.Tests
{
    // Jedinicni testovi custom konvertora: kljuc "value" (skalar ili niz) i
    // inline ugnjezden izraz (bez "expression" / "operands").
    public class SerializationUnitTests
    {
        // opcije uskladjene sa UiModelJsonWriter-om
        private static readonly JsonSerializerOptions Options = new()
        {
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,
            Encoder = JavaScriptEncoder.UnsafeRelaxedJsonEscaping,
            Converters = { new ValueJsonConverter() }
        };

        [Fact]
        public void SimpleRule_ValueIsScalar()
        {
            var rule = new ConstraintRule { TargetName = "X", Operator = ">", Value = new NumericValue(0) };

            var json = JsonSerializer.Serialize(rule, Options);

            Assert.Contains("\"targetName\":\"X\"", json);
            Assert.Contains("\"operator\":\">\"", json);
            Assert.Contains("\"value\":0", json);        // goli skalar
            Assert.DoesNotContain("operands", json);     // C# ime se ne pojavljuje u JSON-u
        }

        [Fact]
        public void ComputedRule_ValueIsArray_WithoutOperandsKeyword()
        {
            var rule = new ConstraintRule
            {
                Operator = "*",
                Operands = new()
                {
                    new ConstraintOperand { TargetName = "a" },
                    new ConstraintOperand { TargetName = "b" }
                }
            };

            var json = JsonSerializer.Serialize(rule, Options);

            Assert.Contains("\"value\":[", json);        // isti kljuc "value", ali niz
            Assert.Contains("\"targetName\":\"a\"", json);
            Assert.Contains("\"targetName\":\"b\"", json);
            Assert.DoesNotContain("operands", json);
            Assert.DoesNotContain("\"targetName\":null", json);   // null se izostavlja
        }

        [Fact]
        public void NestedExpression_IsInline_WithoutExpressionKeyword()
        {
            var inside = new ConstraintRule
            {
                Operator = "+",
                Operands = new()
                {
                    new ConstraintOperand { TargetName = "a" },
                    new ConstraintOperand { TargetName = "b" }
                }
            };
            var outside = new ConstraintRule
            {
                Operator = "*",
                Operands = new()
                {
                    new ConstraintOperand { Expression = inside },   // (a+b)
                    new ConstraintOperand { TargetName = "c" }
                }
            };

            var json = JsonSerializer.Serialize(outside, Options);

            // ugnjezden izraz je inline pravilo (operator + value)
            Assert.DoesNotContain("expression", json);
            Assert.Contains("\"operator\":\"+\"", json);
            Assert.Contains("\"targetName\":\"c\"", json);
        }
    }
}
