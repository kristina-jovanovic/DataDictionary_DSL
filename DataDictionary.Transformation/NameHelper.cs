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
    //   "Via e-mail"       -> ToIdentifier -> "ViaEMail"   
    public static class NameHelper
    {
        // PascalCase spajanje reci: svaki znak koji nije slovo ili cifra (razmak, crtica,
        // tacka, ...) je granica reci i izostavlja se; svaka rec pocinje velikim slovom.
        // Radi i za cirilicu (char.IsLetterOrDigit / ToUpperInvariant koriste Unicode)
        public static string ToIdentifier(string humanName)
        {
            if (string.IsNullOrWhiteSpace(humanName))
                return humanName ?? string.Empty;

            var sb = new StringBuilder(humanName.Length);
            bool startOfWord = true;   // sledece slovo/cifra pocinje novu rec
            foreach (char ch in humanName)
            {
                if (char.IsLetterOrDigit(ch))
                {
                    sb.Append(startOfWord ? char.ToUpperInvariant(ch) : ch);
                    startOfWord = false;
                }
                else
                {
                    startOfWord = true;   // razmak/crtica/tacka... -> granica reci
                }
            }
            return sb.ToString();
        }
    }
}
