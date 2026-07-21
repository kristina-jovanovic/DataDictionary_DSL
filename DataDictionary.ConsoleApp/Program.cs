using DataDictionary.Parser.Parsing;

namespace DataDictionary.ConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Ucitavanje input fajla
            string input = File.ReadAllText("Examples/InventoryForm.dd");

            // Kreiranje parser servisa
            DataDictionaryParserService parserService = new DataDictionaryParserService();

            // Parsiranje
            var result = parserService.Parse(input);

            // Prikaz rezultata
            if (!result.Success)
            {
                Console.WriteLine("Parsing failed.");
                Console.WriteLine();

                foreach (var error in result.Errors)
                {
                    Console.WriteLine(
                        $"Line {error.Line}, Column {error.Column}: {error.Message}");
                }

                return;
            }

            // Ako je uspesno
            Console.WriteLine("Parsing successful!");
            Console.WriteLine();

            // Prikaz modela
            Console.WriteLine($"Name: {result.Model!.Name}");
            Console.WriteLine($"Version: {result.Model.Version}");
            Console.WriteLine($"Author: {result.Model.Author}");
        }
    }
}
