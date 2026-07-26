using System.Text.Json;
using System.Text.Json.Serialization;

namespace DataDictionary.UIModel.Serialization
{
    // ConstraintRule ispisuje "value" kao JEDAN kljuc:
    //   - skalar   ako je postavljen Value    (prosto pravilo: poredjenje / LIKE)
    //   - niz      ako su postavljeni Operands (racunato / IN)
    // Tako u JSON-u nemamo istovremeno "value" i "values"
    // Redosled kljuceva je fiksiran (targetName, operator, value) da odgovara ciljnom JSON-u
    public class ConstraintRuleJsonConverter : JsonConverter<ConstraintRule>
    {
        public override void Write(Utf8JsonWriter writer, ConstraintRule rule, JsonSerializerOptions options)
        {
            writer.WriteStartObject();

            if (rule.TargetName != null)
                writer.WriteString("targetName", rule.TargetName);

            writer.WriteString("operator", rule.Operator);

            if (rule.Value != null)
            {
                // prosto pravilo -> skalar (ValueJsonConverter ispisuje goli skalar)
                writer.WritePropertyName("value");
                JsonSerializer.Serialize(writer, rule.Value, options);
            }
            else if (rule.Operands != null)
            {
                // racunato / IN -> niz operanada
                writer.WritePropertyName("value");
                JsonSerializer.Serialize(writer, rule.Operands, options);
            }

            writer.WriteEndObject();
        }

        // Izlaz je jednosmeran (recnik -> JSON), citanje nije potrebno.
        public override ConstraintRule Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
            => throw new NotSupportedException("Deserializing ConstraintRule from JSON is not supported.");
    }
}
