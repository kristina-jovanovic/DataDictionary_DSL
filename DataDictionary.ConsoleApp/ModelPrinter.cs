using System.Globalization;
using System.Text;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Domain.Models.Constraints.In;
using DataDictionary.Domain.Models.Constraints.Like;
using DataDictionary.Domain.Models.Constraints.Value;
using DomainEntity = DataDictionary.Domain.Models.Domain;

namespace DataDictionary.ConsoleApp
{
    // Rekurzivni ispis izgradjenog DataDictionaryModel-a, za vizuelnu proveru da je
    // stablo (strukture, konstrukcije, komponente, polja, domeni, ogranicenja) tacno.
    internal static class ModelPrinter
    {
        public static void Print(DataDictionaryModel m)
        {
            Console.WriteLine($"DATA DICTIONARY  id={m.Id}  name=\"{m.Name}\"  " +
                $"author=\"{m.Author}\"  version=\"{m.Version}\"  created={m.DateOfCreation:dd.MM.yyyy.}");

            if (m.LogicalFunctions is { Count: > 0 })
            {
                Console.WriteLine("\nLOGICAL FUNCTIONS:");
                foreach (var lf in m.LogicalFunctions)
                    Console.WriteLine($"  [{lf.Id}] \"{lf.Name}\"  definition: {ConstraintStr(lf.Definition)}  result={lf.Result}");
            }

            if (m.SemanticDomains is { Count: > 0 })
            {
                Console.WriteLine("\nSEMANTIC DOMAINS:");
                foreach (var sd in m.SemanticDomains)
                    PrintSemanticDomain(sd);
            }

            Console.WriteLine("\nSTRUCTURES:");
            foreach (var s in m.Structures)
                PrintComponent(s, 1);
        }

        private static void PrintSemanticDomain(SemanticDomain sd)
        {
            Console.Write($"  [{sd.Id}] \"{sd.Name}\"  base={DomainStr(sd.BaseDomain)}");
            if (sd.DefinitionalConstraint != null)
                Console.Write($"  constraint: {ConstraintStr(sd.DefinitionalConstraint)}");
            if (sd is EnumeratedDomain ed)
                Console.Write($"  values=({string.Join(", ", ed.AllowedValues.Select(ValueStr))})");
            Console.WriteLine();
        }

        private static void PrintComponent(Component c, int depth)
        {
            string indent = new string(' ', depth * 2);
            if (c is Structure s)
            {
                Console.WriteLine($"{indent}STRUCTURE [{s.Id}] \"{s.Name}\"  type={s.StructureType}");
                foreach (var con in s.Constructions)
                {
                    Console.WriteLine($"{indent}  **{con.ConstructionType}**");
                    foreach (var comp in con.Components)
                        PrintComponent(comp, depth + 2);
                }
            }
            else if (c is Field f)
            {
                var parts = new List<string> { $"domain={DomainStr(f.DefinedOverDomain)}" };
                if (f.Nullability != null) parts.Add($"nullability={f.Nullability}");
                if (f.Format != null) parts.Add($"format=\"{f.Format}\"");
                if (f.Constraint != null) parts.Add($"constraint: {ConstraintStr(f.Constraint)}");
                if (f.DefaultValue != null) parts.Add($"default={ValueStr(f.DefaultValue)}");
                if (f.Note != null) parts.Add($"note=\"{f.Note}\"");
                Console.WriteLine($"{indent}FIELD [{f.Id}] \"{f.Name}\"  {string.Join(", ", parts)}");
            }
        }

        private static string DomainStr(DomainEntity d) => d switch
        {
            PredefinedDomain pd => pd.Type.ToString(),
            SemanticDomain sd => $"\"{sd.Name}\"",
            _ => d.Name
        };

        // --- vrednosti domena (enumerated / default) ---
        private static string ValueStr(Value v) => v switch
        {
            NumericValue n => n.Value.ToString(CultureInfo.InvariantCulture),
            StringValue s => $"\"{s.Value}\"",
            DateValue dt => dt.Value.ToString("dd.MM.yyyy."),
            BooleanValue b => b.Value ? "true" : "false",
            _ => v.ToString() ?? ""
        };

        // --- ogranicenja ---
        private static string ConstraintStr(ConstraintExpression c) => c switch
        {
            ValueConstraint vc => ValueConstraintStr(vc),
            InConstraint ic => $"IN({string.Join(", ", ic.Values.Select(ConstraintValueStr))})",
            LikeConstraint lc => $"LIKE \"{lc.Pattern}\"",
            BetweenConstraint bc => $"BETWEEN({ConstraintValueStr(bc.LowerBound)}, {ConstraintValueStr(bc.UpperBound)})",
            ArithmeticConstraint ac => "= " + ArithmeticStr(ac.Expression),
            _ => c.GetType().Name
        };

        private static string ValueConstraintStr(ValueConstraint vc)
        {
            var sb = new StringBuilder();
            for (int i = 0; i < vc.Expressions.Count; i++)
            {
                if (i > 0) sb.Append($" {(vc.Operators![i - 1] == LogicalOperator.And ? "AND" : "OR")} ");
                var e = vc.Expressions[i];
                if (e.IsNegated) sb.Append("NOT ");
                sb.Append($"{ComparisonStr(e.Operator)} {ConstraintValueStr(e.Value)}");
            }
            return sb.ToString();
        }

        private static string ConstraintValueStr(ConstraintValue v) => v switch
        {
            NumericConstraintValue n => n.Value.ToString(CultureInfo.InvariantCulture),
            StringConstraintValue s => $"\"{s.Value}\"",
            DateConstraintValue d => d.Value.ToString("dd.MM.yyyy."),
            DateKeywordConstraintValue k => k.Keyword.ToString().ToLowerInvariant(),
            _ => v.ToString() ?? ""
        };

        private static string ArithmeticStr(ArithmeticExpression e) => e switch
        {
            NumericLiteralExpression n => n.Value.ToString(CultureInfo.InvariantCulture),
            ComponentReferenceExpression c => $"\"{c.ComponentName}\"",
            AggregateFunctionExpression a => $"{a.Function.ToString().ToUpperInvariant()}(\"{a.ComponentName}\")",
            BinaryArithmeticExpression b => $"({ArithmeticStr(b.Left)} {ArithmeticOpStr(b.Operator)} {ArithmeticStr(b.Right)})",
            _ => e.ToString() ?? ""
        };

        private static string ComparisonStr(ComparisonOperator o) => o switch
        {
            ComparisonOperator.Equal => "=",
            ComparisonOperator.NotEqual => "!=",
            ComparisonOperator.LessThan => "<",
            ComparisonOperator.LessOrEqual => "<=",
            ComparisonOperator.GreaterThan => ">",
            ComparisonOperator.GreaterOrEqual => ">=",
            _ => o.ToString()
        };

        private static string ArithmeticOpStr(ArithmeticOperator o) => o switch
        {
            ArithmeticOperator.Plus => "+",
            ArithmeticOperator.Minus => "-",
            ArithmeticOperator.Multiply => "*",
            ArithmeticOperator.Divide => "/",
            _ => o.ToString()
        };
    }
}
