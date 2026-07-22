using System;
using System.Collections.Generic;
using System.Globalization;
using System.Text;
using Antlr4.Runtime.Tree;
using DataDictionary.Domain.Enums;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Arithmetic;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Domain.Models.Constraints.In;
using DataDictionary.Domain.Models.Constraints.Like;
using DataDictionary.Domain.Models.Constraints.Value;
using DataDictionary.Parser.Helpers;

namespace DataDictionary.Parser.Visitors
{
    public class ConstraintModelBuilderVisitor
    {
        public ConstraintExpression Build(ConstraintParser.ConstraintContext context)
        {
            if (context.likeConstraint() != null)
            {
                return BuildLikeConstraint(context.likeConstraint());
            }
            if (context.betweenConstraint() != null)
            {
                return BuildBetweenConstraint(context.betweenConstraint());
            }
            if (context.inConstraint() != null)
            {
                return BuildInConstraint(context.inConstraint());
            }
            if (context.valueConstraint() != null)
            {
                return BuildValueConstraint(context.valueConstraint());
            }
            if (context.arithmeticConstraint() != null)
            {
                return BuildArithmeticConstraint(context.arithmeticConstraint());
            }
            throw new ArgumentException("Unsupported constraint type.", nameof(context));
        }
        private LikeConstraint BuildLikeConstraint(ConstraintParser.LikeConstraintContext context)
        {
            string raw = context.STRING().GetText();
            string pattern = Helper.ProcessString(raw); // trim " from beginning and end, and process escape characters
            return new LikeConstraint(pattern);
        }
        private BetweenConstraint BuildBetweenConstraint(ConstraintParser.BetweenConstraintContext context)
        {
            var lower = BuildBetweenValue(context.betweenValue(0));
            var upper = BuildBetweenValue(context.betweenValue(1));
            if (lower.GetType() != upper.GetType())
                throw new ArgumentException("Between bounds must be of the same type.", nameof(context));
            return new BetweenConstraint(lower, upper);
        }
        private InConstraint BuildInConstraint(ConstraintParser.InConstraintContext context)
        {
            var built = context.inValue().Select(BuildInValue).ToList(); //list of inValues

            var firstType = built[0].GetType();
            if (built.Any(v => v.GetType() != firstType))
            {
                throw new ArgumentException("All IN values must be of the same type.", nameof(context));
            }
            return new InConstraint(built);
        }
        private ValueConstraint BuildValueConstraint(ConstraintParser.ValueConstraintContext context)
        {
            List<ComparisonExpression> expressions = context.expression().Select(BuildExpression).ToList();
            List<LogicalOperator> operators = new List<LogicalOperator>();
            foreach (var child in context.children)
            {
                if (child is ITerminalNode t)
                {
                    if (t.Symbol.Type == ConstraintParser.AND)
                        operators.Add(LogicalOperator.And);
                    else if (t.Symbol.Type == ConstraintParser.OR)
                        operators.Add(LogicalOperator.Or);
                }
            }
            return new ValueConstraint(expressions, operators);
        }
        private ArithmeticConstraint BuildArithmeticConstraint(ConstraintParser.ArithmeticConstraintContext context)
        {
            return new ArithmeticConstraint(BuildArithmeticExpression(context.arithmeticExpression()));
        }

        // helper methods
        private ArithmeticExpression BuildArithmeticExpression(ConstraintParser.ArithmeticExpressionContext ctx)
        {
            ArithmeticExpression current = BuildArithmeticTerm(ctx.term(0));
            for (int i = 1; i < ctx.term().Length; i++)
            {
                ArithmeticOperator oper = ctx._op[i - 1].Text switch
                {
                    "+" => ArithmeticOperator.Plus,
                    "-" => ArithmeticOperator.Minus,
                    _ => throw new ArgumentException($"Unsupported operator: {ctx._op[i - 1].Text}", nameof(ctx))
                };
                ArithmeticExpression right = BuildArithmeticTerm(ctx.term(i));
                current = new BinaryArithmeticExpression(current, oper, right);
            }
            return current;
        }

        private ArithmeticExpression BuildArithmeticTerm(ConstraintParser.TermContext ctx)
        {
            ArithmeticExpression current = BuildArithmeticAtom(ctx.atom(0));
            for (int i = 1; i < ctx.atom().Length; i++)
            {
                ArithmeticOperator oper = ctx._op[i - 1].Text switch
                {
                    "*" => ArithmeticOperator.Multiply,
                    "/" => ArithmeticOperator.Divide,
                    _ => throw new ArgumentException($"Unsupported operator: {ctx._op[i - 1].Text}", nameof(ctx))
                };
                ArithmeticExpression right = BuildArithmeticAtom(ctx.atom(i));
                current = new BinaryArithmeticExpression(current, oper, right);
            }
            return current;
        }

        private ArithmeticExpression BuildArithmeticAtom(ConstraintParser.AtomContext ctx)
        {
            if (ctx.arithmeticExpression() != null)
            {
                return BuildArithmeticExpression(ctx.arithmeticExpression());
            }
            if (ctx.aggregateFunction() != null)
            {
                return BuildAggregateFunction(ctx.aggregateFunction());
            }
            if (ctx.STRING() != null)
            {
                return new ComponentReferenceExpression(Helper.ProcessString(ctx.STRING().GetText()));
            }
            if (ctx.INT() != null || ctx.REAL() != null)
            {
                if (!decimal.TryParse(ctx.GetText(), NumberStyles.Any, CultureInfo.InvariantCulture, out decimal numericValue))
                    throw new ArgumentException("Invalid numeric format.", nameof(ctx));
                return new NumericLiteralExpression(numericValue);
            }
            throw new ArgumentException("Invalid arithmetic atom.", nameof(ctx));
        }

        private ArithmeticExpression BuildAggregateFunction(ConstraintParser.AggregateFunctionContext ctx)
        {
            AggregateFunction fun = ctx.GetChild(0).GetText() switch
            {
                "SUM" => AggregateFunction.Sum,
                "AVG" => AggregateFunction.Avg,
                "COUNT" => AggregateFunction.Count,
                "MIN" => AggregateFunction.Min,
                "MAX" => AggregateFunction.Max,
                _ => throw new ArgumentException($"Unsupported aggregate function: {ctx.GetChild(0).GetText()}", nameof(ctx))
            };

            return new AggregateFunctionExpression(fun, Helper.ProcessString(ctx.STRING().GetText()));
        }

        private ComparisonExpression BuildExpression(ConstraintParser.ExpressionContext ctx)
        {
            bool isNegated = ctx.NOT() != null;
            ComparisonOperator op = ctx.@operator().GetText() switch
            {
                "=" => ComparisonOperator.Equal,
                "!=" => ComparisonOperator.NotEqual,
                "<" => ComparisonOperator.LessThan,
                "<=" => ComparisonOperator.LessOrEqual,
                ">" => ComparisonOperator.GreaterThan,
                ">=" => ComparisonOperator.GreaterOrEqual,
                _ => throw new ArgumentException($"Unsupported operator: {ctx.@operator().GetText()}", nameof(ctx))
            };
            ConstraintValue value = BuildComparableValue(ctx.comparableValue());
            return new ComparisonExpression(isNegated, op, value);
        }
        private ConstraintValue BuildComparableValue(ConstraintParser.ComparableValueContext ctx)
        {
            if (ctx.dateValue() != null)
            {
                if (ctx.dateValue().CURRENT_DATE() != null)
                {
                    return new DateKeywordConstraintValue(DateKeyword.CurrentDate);
                }
                if (ctx.dateValue().NOW() != null)
                {
                    return new DateKeywordConstraintValue(DateKeyword.Now);
                }
                if (ctx.dateValue().TODAY() != null)
                {
                    return new DateKeywordConstraintValue(DateKeyword.Today);
                }
                if (!DateTime.TryParseExact(ctx.dateValue().GetText(), "dd.MM.yyyy.", CultureInfo.InvariantCulture, DateTimeStyles.None, out DateTime dateValue))
                    throw new ArgumentException("Invalid date format.", nameof(ctx));
                return new DateConstraintValue(dateValue);
            }
            // INT or REAL left — both are numeric
            if (!decimal.TryParse(ctx.GetText(), NumberStyles.Any, CultureInfo.InvariantCulture, out decimal numericValue))
                throw new ArgumentException("Invalid numeric format.", nameof(ctx));
            return new NumericConstraintValue(numericValue);
        }
        private ConstraintValue BuildInValue(ConstraintParser.InValueContext ctx)
        {
            //TODO: move to semantic analysis phase, but for now we can do it here
            if (ctx.STRING() != null)
                return new StringConstraintValue(Helper.ProcessString(ctx.STRING().GetText()));
            if (ctx.DATE() != null)
            {
                if (!DateTime.TryParseExact(ctx.DATE().GetText(), "dd.MM.yyyy.", CultureInfo.InvariantCulture, DateTimeStyles.None, out DateTime dateValue))
                    throw new ArgumentException("Invalid date format.", nameof(ctx));
                return new DateConstraintValue(dateValue);
            }
            // INT or REAL left — both are numeric
            if (!decimal.TryParse(ctx.GetText(), NumberStyles.Any, CultureInfo.InvariantCulture, out decimal numericValue))
                throw new ArgumentException("Invalid numeric format.", nameof(ctx));
            return new NumericConstraintValue(numericValue);
        }
        private ConstraintValue BuildBetweenValue(ConstraintParser.BetweenValueContext ctx)
        {
            if (ctx.DATE() != null)
            {
                if (!DateTime.TryParseExact(ctx.DATE().GetText(), "dd.MM.yyyy.",
                        CultureInfo.InvariantCulture, DateTimeStyles.None, out DateTime d))
                    throw new ArgumentException("Invalid date format.", nameof(ctx));
                return new DateConstraintValue(d);
            }
            // INT or REAL left — both are numeric
            if (!decimal.TryParse(ctx.GetText(), NumberStyles.Any, CultureInfo.InvariantCulture, out decimal n))
                throw new ArgumentException("Invalid numeric format.", nameof(ctx));
            return new NumericConstraintValue(n);
        }
    }
}
