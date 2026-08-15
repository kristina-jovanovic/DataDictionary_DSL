using DataDictionary.UIModel;

namespace DataDictionary.Tests
{
    // Ispravni slucajevi: sva tri studijska primera moraju da produ celu cev bez gresaka.
    public class PositiveExampleTests
    {
        public static IEnumerable<object[]> Examples =>
        [
            [Pipeline.PopisInventara],
            [Pipeline.IspitnaPrijava],
            [Pipeline.RezervacijaAvioKarata],
        ];

        //poziva se za svaki fajl iz Examples
        [Theory]
        [MemberData(nameof(Examples))]
        public void ParsingWithoutErrors(string file)
        {
            var result = Pipeline.Parse(Pipeline.LoadExample(file));
            Assert.True(result.Success,
                "Parsing failed: " + string.Join("; ", result.Errors?.Select(e => $"L{e.Line}: {e.Message}") ?? []));
            Assert.NotNull(result.Model);
        }

        [Theory]
        [MemberData(nameof(Examples))]
        public void NoSemanticErrors(string file)
        {
            var model = Pipeline.ParseOk(Pipeline.LoadExample(file));
            var errors = Pipeline.Analyze(model);
            Assert.True(errors.Count == 0,
                "Semantic errors: " + string.Join("; ", errors.Select(e => e.Message)));
        }

        [Theory]
        [MemberData(nameof(Examples))]
        public void TransformsIntoRootPanel(string file)
        {
            var model = Pipeline.ParseOk(Pipeline.LoadExample(file));
            var root = Pipeline.Build(model);
            Assert.NotNull(root);
            Assert.NotEmpty(root.Controls);
        }

        [Theory]
        [MemberData(nameof(Examples))]
        public void SerializesIntoNotEmptyJson(string file)
        {
            var json = Pipeline.RunToJson(Pipeline.LoadExample(file));
            Assert.False(string.IsNullOrWhiteSpace(json));
            Assert.Contains("\"Panel\"", json);   // koreni tip
        }
    }
}
