using System;
using System.Collections.Generic;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;

namespace DataDictionary.UIModel.Serialization
{
    internal class ConstraintOperandJsonConverter : JsonConverter<ConstraintOperand>
    {
        public override void Write(Utf8JsonWriter writer, ConstraintOperand value, JsonSerializerOptions options)
        {
            if (value.Expression != null)
            {
                // ugnjezden izraz -> operand JE pravilo (inline "operator"+"value"), bez "expression"
                JsonSerializer.Serialize(writer, value.Expression, options);   // koristi ConstraintRuleJsonConverter
                return;
            }
            writer.WriteStartObject();
            if (value.TargetName != null)
                writer.WriteString("targetName", value.TargetName);
            else if (value.Value != null)
            {
                writer.WritePropertyName("value");
                JsonSerializer.Serialize(writer, value.Value, options);   // skalar preko ValueJsonConverter
            }
            writer.WriteEndObject();
        }

        public override ConstraintOperand? Read(ref Utf8JsonReader reader, Type typeToConvert, JsonSerializerOptions options)
        => throw new NotSupportedException("Deserializing ConstraintOperand is not supported."); // ne koristim ga
    }
}
