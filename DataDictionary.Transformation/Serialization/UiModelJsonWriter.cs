using System.Text.Encodings.Web;
using System.Text.Json;
using System.Text.Json.Serialization;
using DataDictionary.UIModel;
using DataDictionary.UIModel.Serialization;

namespace DataDictionary.Transformation.Serialization
{
    // Serijalizacija izlaznog UI modela u JSON, uskladjena sa ciljnim formatom
    //  - camelCase imena svojstava (Id -> "id", DataType -> "dataType", ...)
    //  - enum-ovi kao stringovi ("String", "Integer", "Grid", "Flow", ...)
    //  - null svojstva se izostavljaju
    //  - relaksovan encoder da cirilica i znakovi poput %@%.% ostanu citljivi
    //  - "type" diskriminator dolazi iz [JsonPolymorphic] na Control/Layout
    //  - ValueJsonConverter ispisuje Value kao goli skalar
    //
    // Napomena: koren se serijalizuje kao Control (bazni tip) da bi se ispisao
    // "type": "Panel" diskriminator i na najvisem nivou.
    public static class UiModelJsonWriter
    {
        private static readonly JsonSerializerOptions Options = new()
        {
            WriteIndented = true,
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase,
            DefaultIgnoreCondition = JsonIgnoreCondition.WhenWritingNull,
            Encoder = JavaScriptEncoder.UnsafeRelaxedJsonEscaping,
            Converters =
            {
                new JsonStringEnumConverter(),
                new ValueJsonConverter()
            }
        };

        public static string ToJson(Control root)
            => JsonSerializer.Serialize(root, Options);

        public static void WriteToFile(Control root, string path)
            => File.WriteAllText(path, ToJson(root));
    }
}
