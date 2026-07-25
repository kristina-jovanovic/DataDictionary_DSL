using System.Text.Json.Serialization;

namespace DataDictionary.UIModel
{
    // vrsta layout-a se dobija iz stvarnog tipa (GridLayout/FlowLayout/...) preko
    // "type" diskriminatora
    // ne treba poseban LayoutType enum
    [JsonPolymorphic(TypeDiscriminatorPropertyName = "type")]
    [JsonDerivedType(typeof(GridLayout), "Grid")]
    [JsonDerivedType(typeof(FlowLayout), "Flow")]
    [JsonDerivedType(typeof(AnchorLayout), "Anchor")]
    [JsonDerivedType(typeof(ExplicitLayout), "Explicit")]
    public abstract class Layout
    {
    }

    public class GridLayout : Layout
    {
        public bool ShowGridLines { get; set; }
        public GridLayout(bool showGridLines = false)
        {
            ShowGridLines = showGridLines;
        }
    }

    public class FlowLayout : Layout
    {
    }

    public class AnchorLayout : Layout
    {
    }

    public class ExplicitLayout : Layout
    {
    }
}
