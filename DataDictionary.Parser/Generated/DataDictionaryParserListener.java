// Generated from DataDictionaryParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DataDictionaryParser}.
 */
public interface DataDictionaryParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(DataDictionaryParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(DataDictionaryParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#dataDictionary}.
	 * @param ctx the parse tree
	 */
	void enterDataDictionary(DataDictionaryParser.DataDictionaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#dataDictionary}.
	 * @param ctx the parse tree
	 */
	void exitDataDictionary(DataDictionaryParser.DataDictionaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#logicalFunctionDecl}.
	 * @param ctx the parse tree
	 */
	void enterLogicalFunctionDecl(DataDictionaryParser.LogicalFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#logicalFunctionDecl}.
	 * @param ctx the parse tree
	 */
	void exitLogicalFunctionDecl(DataDictionaryParser.LogicalFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#semanticDomainDecl}.
	 * @param ctx the parse tree
	 */
	void enterSemanticDomainDecl(DataDictionaryParser.SemanticDomainDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#semanticDomainDecl}.
	 * @param ctx the parse tree
	 */
	void exitSemanticDomainDecl(DataDictionaryParser.SemanticDomainDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#enumeratedDomainDecl}.
	 * @param ctx the parse tree
	 */
	void enterEnumeratedDomainDecl(DataDictionaryParser.EnumeratedDomainDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#enumeratedDomainDecl}.
	 * @param ctx the parse tree
	 */
	void exitEnumeratedDomainDecl(DataDictionaryParser.EnumeratedDomainDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(DataDictionaryParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(DataDictionaryParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#structureDecl}.
	 * @param ctx the parse tree
	 */
	void enterStructureDecl(DataDictionaryParser.StructureDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#structureDecl}.
	 * @param ctx the parse tree
	 */
	void exitStructureDecl(DataDictionaryParser.StructureDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#constructionDecl}.
	 * @param ctx the parse tree
	 */
	void enterConstructionDecl(DataDictionaryParser.ConstructionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#constructionDecl}.
	 * @param ctx the parse tree
	 */
	void exitConstructionDecl(DataDictionaryParser.ConstructionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#aggregationDecl}.
	 * @param ctx the parse tree
	 */
	void enterAggregationDecl(DataDictionaryParser.AggregationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#aggregationDecl}.
	 * @param ctx the parse tree
	 */
	void exitAggregationDecl(DataDictionaryParser.AggregationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#setDecl}.
	 * @param ctx the parse tree
	 */
	void enterSetDecl(DataDictionaryParser.SetDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#setDecl}.
	 * @param ctx the parse tree
	 */
	void exitSetDecl(DataDictionaryParser.SetDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#specializationDecl}.
	 * @param ctx the parse tree
	 */
	void enterSpecializationDecl(DataDictionaryParser.SpecializationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#specializationDecl}.
	 * @param ctx the parse tree
	 */
	void exitSpecializationDecl(DataDictionaryParser.SpecializationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#exclusiveSpecializationDecl}.
	 * @param ctx the parse tree
	 */
	void enterExclusiveSpecializationDecl(DataDictionaryParser.ExclusiveSpecializationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#exclusiveSpecializationDecl}.
	 * @param ctx the parse tree
	 */
	void exitExclusiveSpecializationDecl(DataDictionaryParser.ExclusiveSpecializationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#inclusiveSpecializationDecl}.
	 * @param ctx the parse tree
	 */
	void enterInclusiveSpecializationDecl(DataDictionaryParser.InclusiveSpecializationDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#inclusiveSpecializationDecl}.
	 * @param ctx the parse tree
	 */
	void exitInclusiveSpecializationDecl(DataDictionaryParser.InclusiveSpecializationDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#componentDecl}.
	 * @param ctx the parse tree
	 */
	void enterComponentDecl(DataDictionaryParser.ComponentDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#componentDecl}.
	 * @param ctx the parse tree
	 */
	void exitComponentDecl(DataDictionaryParser.ComponentDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#structureReference}.
	 * @param ctx the parse tree
	 */
	void enterStructureReference(DataDictionaryParser.StructureReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#structureReference}.
	 * @param ctx the parse tree
	 */
	void exitStructureReference(DataDictionaryParser.StructureReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void enterFieldDecl(DataDictionaryParser.FieldDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#fieldDecl}.
	 * @param ctx the parse tree
	 */
	void exitFieldDecl(DataDictionaryParser.FieldDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#domainReference}.
	 * @param ctx the parse tree
	 */
	void enterDomainReference(DataDictionaryParser.DomainReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#domainReference}.
	 * @param ctx the parse tree
	 */
	void exitDomainReference(DataDictionaryParser.DomainReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(DataDictionaryParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(DataDictionaryParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#note}.
	 * @param ctx the parse tree
	 */
	void enterNote(DataDictionaryParser.NoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#note}.
	 * @param ctx the parse tree
	 */
	void exitNote(DataDictionaryParser.NoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(DataDictionaryParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(DataDictionaryParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#valueConstraint}.
	 * @param ctx the parse tree
	 */
	void enterValueConstraint(DataDictionaryParser.ValueConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#valueConstraint}.
	 * @param ctx the parse tree
	 */
	void exitValueConstraint(DataDictionaryParser.ValueConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(DataDictionaryParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(DataDictionaryParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#comparableValue}.
	 * @param ctx the parse tree
	 */
	void enterComparableValue(DataDictionaryParser.ComparableValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#comparableValue}.
	 * @param ctx the parse tree
	 */
	void exitComparableValue(DataDictionaryParser.ComparableValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#dateValue}.
	 * @param ctx the parse tree
	 */
	void enterDateValue(DataDictionaryParser.DateValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#dateValue}.
	 * @param ctx the parse tree
	 */
	void exitDateValue(DataDictionaryParser.DateValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(DataDictionaryParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(DataDictionaryParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#inConstraint}.
	 * @param ctx the parse tree
	 */
	void enterInConstraint(DataDictionaryParser.InConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#inConstraint}.
	 * @param ctx the parse tree
	 */
	void exitInConstraint(DataDictionaryParser.InConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#inValue}.
	 * @param ctx the parse tree
	 */
	void enterInValue(DataDictionaryParser.InValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#inValue}.
	 * @param ctx the parse tree
	 */
	void exitInValue(DataDictionaryParser.InValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#likeConstraint}.
	 * @param ctx the parse tree
	 */
	void enterLikeConstraint(DataDictionaryParser.LikeConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#likeConstraint}.
	 * @param ctx the parse tree
	 */
	void exitLikeConstraint(DataDictionaryParser.LikeConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#betweenConstraint}.
	 * @param ctx the parse tree
	 */
	void enterBetweenConstraint(DataDictionaryParser.BetweenConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#betweenConstraint}.
	 * @param ctx the parse tree
	 */
	void exitBetweenConstraint(DataDictionaryParser.BetweenConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#betweenValue}.
	 * @param ctx the parse tree
	 */
	void enterBetweenValue(DataDictionaryParser.BetweenValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#betweenValue}.
	 * @param ctx the parse tree
	 */
	void exitBetweenValue(DataDictionaryParser.BetweenValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#arithmeticConstraint}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticConstraint(DataDictionaryParser.ArithmeticConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#arithmeticConstraint}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticConstraint(DataDictionaryParser.ArithmeticConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpression(DataDictionaryParser.ArithmeticExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#arithmeticExpression}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpression(DataDictionaryParser.ArithmeticExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(DataDictionaryParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(DataDictionaryParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(DataDictionaryParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(DataDictionaryParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link DataDictionaryParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void enterAggregateFunction(DataDictionaryParser.AggregateFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DataDictionaryParser#aggregateFunction}.
	 * @param ctx the parse tree
	 */
	void exitAggregateFunction(DataDictionaryParser.AggregateFunctionContext ctx);
}