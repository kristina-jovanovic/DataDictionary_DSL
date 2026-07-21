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

        public DataDictionaryModel(int id, string name, string author, string version,
            DateTime dateOfCreation, List<Structure> structures,
            List<LogicalFunction> logicalFunctions = null, List<SemanticDomain> semanticDomains = null)
        {
            Id = id;
            Name = name;
            Author = author;
            Version = version;
            DateOfCreation = dateOfCreation;
            Structures = structures;
            LogicalFunctions = logicalFunctions ?? new List<LogicalFunction>();
            SemanticDomains = semanticDomains ?? new List<SemanticDomain>();
        }
    }
}
