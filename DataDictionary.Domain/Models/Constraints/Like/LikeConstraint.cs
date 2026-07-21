namespace DataDictionary.Domain.Models.Constraints.Like
{
    public class LikeConstraint : ConstraintExpression
    {
        public required string Pattern { get; set; }
        public LikeConstraint(string pattern)
        {
            Pattern = pattern;
        }
    }
}
