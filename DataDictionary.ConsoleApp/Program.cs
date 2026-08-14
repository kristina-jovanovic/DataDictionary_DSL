using DataDictionary.Analysis;
using DataDictionary.Parser.Parsing;
using DataDictionary.Transformation;
using DataDictionary.Transformation.Serialization;

namespace DataDictionary.ConsoleApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            // Konzola mora da koristi UTF-8 da bi se cirilica ispravno prikazivala
            Console.OutputEncoding = System.Text.Encoding.UTF8;

            // Ucitavanje input fajla iz Examples foldera
            // AppContext.BaseDirectory je izlazni folder (bin/Debug/net10.0), pa se
            // penjemo tri nivoa nazad (net10.0 -> Debug -> bin -> projekat) do Examples
            string path = Path.Combine(AppContext.BaseDirectory,
                "..", "..", "..", "Examples", "PopisInventara.dd");
            string input = File.ReadAllText(path);

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

            // Semanticka analiza nad izgradjenim modelom
            var semanticErrors = new SemanticAnalyzer().Analyze(result.Model!);
            if (semanticErrors.Count > 0)
            {
                Console.WriteLine("Semantic errors:");
                foreach (var error in semanticErrors)
                    Console.WriteLine($"  {error.Message}");
                Console.WriteLine();
            }
            else
            {
                Console.WriteLine("No semantic errors!\n");
            }

            // Prikaz celog modela
            ModelPrinter.Print(result.Model!);

            // Transformacija u UI model + JSON
            try
            {
                var uiRoot = new UiModelBuilder().Build(result.Model!);
                string outPath = Path.ChangeExtension(path, ".json");
                UiModelJsonWriter.WriteToFile(uiRoot, outPath);
                Console.WriteLine($"\nUI model serijalizovan u: {outPath}");
            }
            catch (NotImplementedException ex)
            {
                Console.WriteLine($"\n[Transformacija jos nije implementirana: {ex.Message}]");
            }
        }
    }
}
