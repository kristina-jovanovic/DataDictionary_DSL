// Generated from DataDictionaryParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DataDictionaryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DataDictionaryParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(DataDictionaryParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#dataDictionary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDataDictionary(DataDictionaryParser.DataDictionaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#logicalFunctionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalFunctionDecl(DataDictionaryParser.LogicalFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#semanticDomainDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemanticDomainDecl(DataDictionaryParser.SemanticDomainDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#enumeratedDomainDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumeratedDomainDecl(DataDictionaryParser.EnumeratedDomainDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(DataDictionaryParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#structureDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureDecl(DataDictionaryParser.StructureDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#constructionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructionDecl(DataDictionaryParser.ConstructionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#aggregationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregationDecl(DataDictionaryParser.AggregationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#setDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetDecl(DataDictionaryParser.SetDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#specializationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecializationDecl(DataDictionaryParser.SpecializationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#exclusiveSpecializationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusiveSpecializationDecl(DataDictionaryParser.ExclusiveSpecializationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#inclusiveSpecializationDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusiveSpecializationDecl(DataDictionaryParser.InclusiveSpecializationDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#componentDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComponentDecl(DataDictionaryParser.ComponentDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#structureReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructureReference(DataDictionaryParser.StructureReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#fieldDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldDecl(DataDictionaryParser.FieldDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#domainReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDomainReference(DataDictionaryParser.DomainReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(DataDictionaryParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#note}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNote(DataDictionaryParser.NoteContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(DataDictionaryParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#valueConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueConstraint(DataDictionaryParser.ValueConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(DataDictionaryParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#comparableValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparableValue(DataDictionaryParser.ComparableValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#dateValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDateValue(DataDictionaryParser.DateValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(DataDictionaryParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#inConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInConstraint(DataDictionaryParser.InConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#inValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInValue(DataDictionaryParser.InValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#likeConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLikeConstraint(DataDictionaryParser.LikeConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#betweenConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenConstraint(DataDictionaryParser.BetweenConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#betweenValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBetweenValue(DataDictionaryParser.BetweenValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#arithmeticConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticConstraint(DataDictionaryParser.ArithmeticConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpression(DataDictionaryParser.ArithmeticExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(DataDictionaryParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(DataDictionaryParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link DataDictionaryParser#aggregateFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAggregateFunction(DataDictionaryParser.AggregateFunctionContext ctx);
}