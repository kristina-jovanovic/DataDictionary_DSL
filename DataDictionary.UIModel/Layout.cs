using System.Diagnostics.CodeAnalysis;

namespace DataDictionary.UIModel
{
    public class Layout
    {

    }

    public class GridLayout : Layout
    {
        public required bool ShowGridLines { get; set; }
        [SetsRequiredMembers]
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



