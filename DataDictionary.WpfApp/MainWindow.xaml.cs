using System.IO;
using System.Windows;
using Microsoft.Win32;
using DataDictionary.Analysis;
using DataDictionary.Parser.Parsing;
using DataDictionary.Parser.Parsing.Errors;
using DataDictionary.Transformation;
using DataDictionary.Transformation.Serialization;

namespace DataDictionary.WpfApp
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        // Ucitaj .dd fajl u editor
        private void LoadButton_Click(object sender, RoutedEventArgs e)
        {
            var dlg = new OpenFileDialog
            {
                Filter = "Data Dictionary (*.dd)|*.dd|Svi fajlovi (*.*)|*.*"
            };
            if (dlg.ShowDialog() == true)
                InputEditor.Text = File.ReadAllText(dlg.FileName);
        }

        // Pokreni celu cev: parsiranje -> semantika -> transformacija -> JSON
        private void GenerateButton_Click(object sender, RoutedEventArgs e)
        {
            ErrorsList.Items.Clear();
            JsonOutput.Clear();

            // 1. parsiranje (sintaksne greske; model se gradi permisivno)
            var result = new DataDictionaryParserService().Parse(InputEditor.Text);
            if (!result.Success)
            {
                foreach (var err in result.Errors!)
                    ErrorsList.Items.Add($"[{ErrorTag(err.ErrorType)}] L{err.Line}:{err.Column}  {err.Message}");
                return;   // uslov za dalje korake je sintaksno ispravan model
            }

            // 2. semantika (skuplja SVE greske)
            var semanticErrors = new SemanticAnalyzer().Analyze(result.Model!);
            foreach (var err in semanticErrors)
                ErrorsList.Items.Add($"[Семантика] {err.Message}");

            // ako model ima semanticke greske, nije validan -> ne generisemo UI
            if (semanticErrors.Count > 0)
            {
                ErrorsList.Items.Add("Исправите семантичке грешке па поновите генерисање.");
                return;
            }

            // 3. transformacija + 4. serijalizacija u JSON
            try
            {
                var uiRoot = new UiModelBuilder().Build(result.Model!);
                JsonOutput.Text = UiModelJsonWriter.ToJson(uiRoot);
                ErrorsList.Items.Add("✓ Нема грешака — JSON успешно генерисан.");
            }
            catch (Exception ex)
            {
                ErrorsList.Items.Add($"[Трансформација] {ex.Message}");
            }
        }

        // Oznaka greske po tipu
        private static string ErrorTag(ErrorType type) => type switch
        {
            ErrorType.Semantic => "Семантика",
            ErrorType.Lexical => "Лексика",
            _ => "Синтакса"
        };

        // Sacuvaj generisani JSON u fajl
        private void SaveButton_Click(object sender, RoutedEventArgs e)
        {
            if (string.IsNullOrWhiteSpace(JsonOutput.Text))
                return;

            var dlg = new SaveFileDialog
            {
                Filter = "JSON (*.json)|*.json",
                FileName = "izlaz.json"
            };
            if (dlg.ShowDialog() == true)
                File.WriteAllText(dlg.FileName, JsonOutput.Text);
        }
    }
}
