using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Runtime.InteropServices.Marshalling;
using System.Text;

namespace DataDictionary.Domain.Models
{
    public class DataDictionaryModel
    {
        public required int Id { get; set; }
        public required string Name { get; set; }
        public required string Author { get; set; }
        public required string Version { get; set; }
        public required DateTime DateOfCreation { get; set; }
        public List<LogicalFunction>? LogicalFunctions { get; set; }
        public List<SemanticDomain>? SemanticDomains { get; set; }
        public required List<Structure> Structures { get; set; }

    }
    public class ConstraintExpression
    {

    }
}
