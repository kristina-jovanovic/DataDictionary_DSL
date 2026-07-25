using System.Diagnostics.CodeAnalysis;
using DataDictionary.UIModel.Enums;

namespace DataDictionary.UIModel
{
    public class Layout
    {
        public required LayoutType LayoutType { get; set; }
        [SetsRequiredMembers]
        public Layout(LayoutType type)
        {
            LayoutType = type;
        }
    }

    public class GridLayout : Layout
    {
        public required bool ShowGridLines { get; set; }
        [SetsRequiredMembers]
        public GridLayout(bool showGridLines = false) : base(LayoutType.Grid)
        {
            ShowGridLines = showGridLines;
        }
    }
    public class FlowLayout : Layout
    {
        [SetsRequiredMembers]
        public FlowLayout() : base(LayoutType.Flow)
        {

        }
    }

    public class AnchorLayout : Layout
    {
        [SetsRequiredMembers]
        public AnchorLayout() : base(LayoutType.Anchor)
        {

        }
    }
    public class ExplicitLayout : Layout
    {
        [SetsRequiredMembers]
        public ExplicitLayout() : base(LayoutType.Explicit)
        {

        }
    }
}



