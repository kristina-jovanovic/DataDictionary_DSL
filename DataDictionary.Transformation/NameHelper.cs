using System.Text;

namespace DataDictionary.Transformation
{
    // Ime kontrole (Control.Name) je IDENTIFIKATOR bez razmaka, dok su
    // Panel.Title / DataControl.Label / OptionValue ljudski citljiva imena
    // (ostaju sa razmacima, tj. koristi se original iz recnika).
    //
    //   "Price per piece" -> ToIdentifier -> "PricePerPiece"
    //   "Организација"     -> ToIdentifier -> "Организација"
    //   "Цена по комаду"   -> ToIdentifier -> "ЦенаПоКомаду"
    public static class NameHelper
    {
        // PascalCase spajanje reci: ukloni razmake, svaku rec pocni velikim slovom.
        // Radi i za cirilicu (ToUpperInvariant koristi Unicode mapiranje).
        public static string ToIdentifier(string humanName)
        {
            if (string.IsNullOrWhiteSpace(humanName))
                return humanName ?? string.Empty;

            var parts = humanName.Split((char[]?)null, StringSplitOptions.RemoveEmptyEntries);
            var sb = new StringBuilder(humanName.Length);
            foreach (var part in parts)
            {
                sb.Append(char.ToUpperInvariant(part[0]));
                if (part.Length > 1)
                    sb.Append(part, 1, part.Length - 1);
            }
            return sb.ToString();
        }
    }
}
