using System;
using System.Collections.Generic;
using System.Globalization;
using System.Runtime.CompilerServices;
using System.Text;
using DataDictionary.Domain.Models.Constraints;
using DataDictionary.Domain.Models.Constraints.Between;
using DataDictionary.Domain.Models.Constraints.In;
using DataDictionary.Domain.Models.Constraints.Like;
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
