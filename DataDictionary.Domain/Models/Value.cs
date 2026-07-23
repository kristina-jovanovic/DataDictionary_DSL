using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Text;
using DataDictionary.Domain.Enums;

namespace DataDictionary.Domain.Models
{
    public abstract class Value
    {
    }

    public class NumericValue : Value
    {
        public required decimal Value { get; set; }
        [SetsRequiredMembers]
        public NumericValue(decimal value)
        {
            Value = value;
        }
    }

    public class StringValue : Value
    {
        public required string Value { get; set; }
        [SetsRequiredMembers]
        public StringValue(string value)
        {
            Value = value;
        }
    }

    public class DateValue : Value
    {
        public required DateTime Value { get; set; }
        [SetsRequiredMembers]
        public DateValue(DateTime value)
        {
            Value = value;
        }
    }
    public class BooleanValue : Value
    {
        public required bool Value { get; set; }
        [SetsRequiredMembers]
        public BooleanValue(bool value)
        {
            Value = value;
        }
    }

}
