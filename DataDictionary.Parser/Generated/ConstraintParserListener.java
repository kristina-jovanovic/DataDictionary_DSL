// Generated from ConstraintParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ConstraintParser}.
 */
public interface ConstraintParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(ConstraintParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(ConstraintParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#valueConstraint}.
	 * @param ctx the parse tree
	 */
	void enterValueConstraint(ConstraintParser.ValueConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#valueConstraint}.
	 * @param ctx the parse tree
	 */
	void exitValueConstraint(ConstraintParser.ValueConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(ConstraintParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(ConstraintParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#comparableValue}.
	 * @param ctx the parse tree
	 */
	void enterComparableValue(ConstraintParser.ComparableValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#comparableValue}.
	 * @param ctx the parse tree
	 */
	void exitComparableValue(ConstraintParser.ComparableValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#dateValue}.
	 * @param ctx the parse tree
	 */
	void enterDateValue(ConstraintParser.DateValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#dateValue}.
	 * @param ctx the parse tree
	 */
	void exitDateValue(ConstraintParser.DateValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(ConstraintParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(ConstraintParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#inConstraint}.
	 * @param ctx the parse tree
	 */
	void enterInConstraint(ConstraintParser.InConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#inConstraint}.
	 * @param ctx the parse tree
	 */
	void exitInConstraint(ConstraintParser.InConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#inValue}.
	 * @param ctx the parse tree
	 */
	void enterInValue(ConstraintParser.InValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#inValue}.
	 * @param ctx the parse tree
	 */
	void exitInValue(ConstraintParser.InValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#likeConstraint}.
	 * @param ctx the parse tree
	 */
	void enterLikeConstraint(ConstraintParser.LikeConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#likeConstraint}.
	 * @param ctx the parse tree
	 */
	void exitLikeConstraint(ConstraintParser.LikeConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#betweenConstraint}.
	 * @param ctx the parse tree
	 */
	void enterBetweenConstraint(ConstraintParser.BetweenConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#betweenConstraint}.
	 * @param ctx the parse tree
	 */
	void exitBetweenConstraint(ConstraintParser.BetweenConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#betweenValue}.
	 * @param ctx the parse tree
	 */
	void enterBetweenValue(ConstraintParser.BetweenValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#betweenValue}.
	 * @param ctx the parse tree
	 */
	void exitBetweenValue(ConstraintParser.BetweenValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#arithmeticConstraint}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticConstraint(ConstraintParser.ArithmeticConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#arithmeticConstraint}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticConstraint(ConstraintParser.ArithmeticConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(ConstraintParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(ConstraintParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(ConstraintParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(ConstraintParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(ConstraintParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(ConstraintParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link ConstraintParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(ConstraintParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ConstraintParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(ConstraintParser.AggregateFunctionContext ctx);
}