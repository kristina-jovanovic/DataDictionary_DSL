using System.IO;
using System.Windows;
using Microsoft.Win32;
using DataDictionary.Analysis;
using DataDictionary.Parser.Parsing;
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

            // 1. sintaksna analiza
            var result = new DataDictionaryParserService().Parse(InputEditor.Text);
            if (!result.Success)
            {
                foreach (var err in result.Errors!)
                    ErrorsList.Items.Add($"[Синтакса] L{err.Line}:{err.Column}  {err.Message}");
                return;   // uslov za dalje korake je sintaksno ispravan model
            }

            // 2. semantika (skuplja greske - ne prekida generisanje)
            var semanticErrors = new SemanticAnalyzer().Analyze(result.Model!);
            foreach (var err in semanticErrors)
                ErrorsList.Items.Add($"[Семантика] {err.Message}");


            // 3. transformacija + 4. serijalizacija u JSON
            try
            {
                var uiRoot = new UiModelBuilder().Build(result.Model!);
                JsonOutput.Text = UiModelJsonWriter.ToJson(uiRoot);
                if (semanticErrors.Count == 0)
                    ErrorsList.Items.Add("✓ Нема грешака — JSON успешно генерисан.");
            }
            catch (Exception ex)
            {
                ErrorsList.Items.Add($"[Трансформација] {ex.Message}");
            }
        }

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
