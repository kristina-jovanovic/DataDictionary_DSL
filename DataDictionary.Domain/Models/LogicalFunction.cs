namespace DataDictionary.Domain.Models
{
    public class LogicalFunction
    {
        public required int Id { get; set; }
        public required string Name { get; set; }
        public required ConstraintExpression Definition { get; set; }
        public required bool Result { get; set; }
    }
}
