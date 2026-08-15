using DataDictionary.Analysis;
using DataDictionary.Domain.Models;
using DataDictionary.Parser.Parsing;
using DataDictionary.Parser.Parsing.Errors;
using DataDictionary.Transformation;
using DataDictionary.Transformation.Serialization;
using DataDictionary.UIModel;

namespace DataDictionary.Tests
{
    // Helper: pokrece celu cev (parser -> semantika -> transformacija -> JSON)
    // i ucitava tri studijska primera iz TestInputs (linkovani iz ConsoleApp/Examples).
    internal static class Pipeline
    {
        public const string PopisInventara = "PopisInventara.dd";
        public const string IspitnaPrijava = "IspitnaPrijava.dd";
        public const string RezervacijaAvioKarata = "RezervacijaAvioKarata.dd";

        private static readonly string InputsDir =
            Path.Combine(AppContext.BaseDirectory, "TestInputs");

        public static string LoadExample(string name)
            => File.ReadAllText(Path.Combine(InputsDir, name));

        public static ParseResult Parse(string dd)
            => new DataDictionaryParserService().Parse(dd);

        public static List<Error> Analyze(DataDictionaryModel model)
            => new SemanticAnalyzer().Analyze(model);

        public static Panel Build(DataDictionaryModel model)
            => new UiModelBuilder().Build(model);

        public static string ToJson(Panel root)
            => UiModelJsonWriter.ToJson(root);

        // Parsira, tvrdi da je uspesno, vraca model (za pozitivne testove).
        public static DataDictionaryModel ParseOk(string dd)
        {
            var result = Parse(dd);
            Assert.True(result.Success,
                "Parsing failed: " + string.Join("; ", result.Errors?.Select(e => e.Message) ?? []));
            Assert.NotNull(result.Model);
            return result.Model!;
        }

        // Cela cev na ispravnom ulazu: parsira + semantika bez gresaka + transformacija -> JSON.
        public static string RunToJson(string dd)
        {
            var model = ParseOk(dd);
            var semanticErrors = Analyze(model);
            Assert.True(semanticErrors.Count == 0,
                "Semantic errors: " + string.Join("; ", semanticErrors.Select(e => e.Message)));
            return ToJson(Build(model));
        }
    }
}
