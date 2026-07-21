using System.Diagnostics.CodeAnalysis;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models.Constraints
{
    // Zajednička hijerarhija vrednosti korišćena u ComparisonExpression, InConstraint
    // i BetweenConstraint (odgovara comparableValue/inValue/betweenValue/dateValue
    // pravilima u ConstraintParser.g4)
    public abstract class ConstraintValue
    {

    }

    public class NumericConstraintValue : ConstraintValue
    {
        public required decimal Value { get; set; }
        [SetsRequiredMembers]
        public NumericConstraintValue(decimal value)
        {
            Value = value;
        }
    }

    public class StringConstraintValue : ConstraintValue
    {
        public required string Value { get; set; }
        [SetsRequiredMembers]
        public StringConstraintValue(string value)
        {
            Value = value;
        }
    }

    public class DateConstraintValue : ConstraintValue
    {
        public required DateTime Value { get; set; }
        [SetsRequiredMembers]
        public DateConstraintValue(DateTime value)
        {
            Value = value;
        }
    }

    public class DateKeywordConstraintValue : ConstraintValue
    {
        public required DateKeyword Keyword { get; set; }
        [SetsRequiredMembers]
        public DateKeywordConstraintValue(DateKeyword keyword)
        {
            Keyword = keyword;
        }
    }
}
