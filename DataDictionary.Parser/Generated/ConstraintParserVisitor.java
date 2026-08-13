// Generated from ConstraintParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ConstraintParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ConstraintParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(ConstraintParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#valueConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueConstraint(ConstraintParser.ValueConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(ConstraintParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#comparableValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparableValue(ConstraintParser.ComparableValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#dateValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateValue(ConstraintParser.DateValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(ConstraintParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#inConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInConstraint(ConstraintParser.InConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#inValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInValue(ConstraintParser.InValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#likeConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeConstraint(ConstraintParser.LikeConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#betweenConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenConstraint(ConstraintParser.BetweenConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#betweenValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenValue(ConstraintParser.BetweenValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#arithmeticConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticConstraint(ConstraintParser.ArithmeticConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(ConstraintParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(ConstraintParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(ConstraintParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link ConstraintParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(ConstraintParser.AggregateFunctionContext ctx);
}