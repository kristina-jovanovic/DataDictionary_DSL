using System.Globalization;
using System.Text.Json;
using System.Text.Json.Serialization;
using DataDictionary.Domain.Models;

namespace DataDictionary.UIModel.Serialization
{
    // Serijalizuje Value hijerarhiju (NumericValue/StringValue/BooleanValue/DateValue)
    // kao GOLI skalar u JSON-u (npr. 0, "abc", true, "13.05.2026"), umesto kao objekat.
    // Bez ovoga bi STJ, posto je svojstvo deklarisano kao apstraktni Value, ispisao
    // prazan "{}" i izgubio vrednost.
    public class ValueJsonConverter : JsonConverter<Value>
    {
        public override void Write(Utf8JsonWriter writer, Value value, JsonSerializerOptions options)
        {
            switch (value)
            {
                case NumericValue n:
                    writer.WriteNumberValue(n.Value);
                    break;
                case StringValue s:
                    writer.WriteStringValue(s.Value);
                    break;
                case BooleanValue b:
                    writer.WriteBooleanValue(b.Value);
                    break;
                case DateValue d:
                    // format usklađen sa DSL-om; po potrebi promeni (npr. ISO "yyyy-MM-dd")
                    writer.WriteStringValue(d.Value.ToString("dd.MM.yyyy", CultureInfo.InvariantCulture));
                    break;
                default:
                    throw new NotSupportedException($"Unsupported Value type: {value.GetType().Name}");
            }
        }

        // Izlaz je jednosmeran (recnik -> JSON), pa citanje nije potrebno.
        public override Value Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
            => throw new NotSupportedException("Deserializing Value from JSON is not supported.");
    }
}
