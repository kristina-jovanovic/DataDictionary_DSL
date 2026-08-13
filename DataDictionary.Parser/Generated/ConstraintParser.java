// Generated from ConstraintParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ConstraintParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DD_LABEL=1, ID_LABEL=2, NAME_LABEL=3, AUTHOR_LABEL=4, VERSION_LABEL=5, 
		DATE_OF_CREATION_LABEL=6, STRUCTURES_LABEL=7, LF_LABEL=8, SD_LABEL=9, 
		DEFINITION_LABEL=10, RESULT_LABEL=11, BASE_LABEL=12, CONSTRAINT_LABEL=13, 
		VALUES_LABEL=14, TYPE_LABEL=15, DOMAIN_LABEL=16, FORMAT_LABEL=17, NULLABILITY_LABEL=18, 
		DEFAULT_LABEL=19, NOTE_LABEL=20, STRUCTURE_TYPE=21, NULL_CONSTRAINT=22, 
		BOOLEAN=23, BASE_DOMAIN=24, L_PAREN=25, R_PAREN=26, L_CURLY=27, R_CURLY=28, 
		L_SQUARE=29, R_SQUARE=30, COMA=31, FULLSTOP=32, HASH=33, AMPERSAND=34, 
		AND=35, OR=36, NOT=37, CURRENT_DATE=38, TODAY=39, NOW=40, IN=41, LIKE=42, 
		BETWEEN=43, SUM=44, AVG=45, COUNT=46, MIN=47, MAX=48, GE=49, LE=50, NEQ=51, 
		EQ=52, GT=53, LT=54, PLUS=55, MINUS=56, ASTERISK=57, SLASH=58, DATE=59, 
		STRING=60, REAL=61, INT=62, WHITESPACE=63;
	public static final int
		RULE_constraint = 0, RULE_valueConstraint = 1, RULE_expression = 2, RULE_comparableValue = 3, 
		RULE_dateValue = 4, RULE_operator = 5, RULE_inConstraint = 6, RULE_inValue = 7, 
		RULE_likeConstraint = 8, RULE_betweenConstraint = 9, RULE_betweenValue = 10, 
		RULE_arithmeticConstraint = 11, RULE_arithmeticExpression = 12, RULE_term = 13, 
		RULE_atom = 14, RULE_aggregateFunction = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"constraint", "valueConstraint", "expression", "comparableValue", "dateValue", 
			"operator", "inConstraint", "inValue", "likeConstraint", "betweenConstraint", 
			"betweenValue", "arithmeticConstraint", "arithmeticExpression", "term", 
			"atom", "aggregateFunction"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'DATA DICTIONARY'", "'id:'", "'name:'", "'author:'", "'version:'", 
			"'date of creation:'", "'STRUCTURES'", "'LOGICAL FUNCTION'", "'SEMANTIC DOMAIN'", 
			"'definition:'", "'result:'", "'base:'", "'constraint:'", "'values:'", 
			"'type:'", "'domain:'", "'format:'", "'nullability:'", "'default:'", 
			"'note:'", null, null, null, null, "'('", "')'", "'{'", "'}'", "'['", 
			"']'", "','", "'.'", "'#'", "'&'", "'AND'", "'OR'", "'NOT'", "'current_date'", 
			"'today'", "'now'", "'IN'", "'LIKE'", "'BETWEEN'", "'SUM'", "'AVG'", 
			"'COUNT'", "'MIN'", "'MAX'", "'>='", "'<='", "'!='", "'='", "'>'", "'<'", 
			"'+'", "'-'", "'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DD_LABEL", "ID_LABEL", "NAME_LABEL", "AUTHOR_LABEL", "VERSION_LABEL", 
			"DATE_OF_CREATION_LABEL", "STRUCTURES_LABEL", "LF_LABEL", "SD_LABEL", 
			"DEFINITION_LABEL", "RESULT_LABEL", "BASE_LABEL", "CONSTRAINT_LABEL", 
			"VALUES_LABEL", "TYPE_LABEL", "DOMAIN_LABEL", "FORMAT_LABEL", "NULLABILITY_LABEL", 
			"DEFAULT_LABEL", "NOTE_LABEL", "STRUCTURE_TYPE", "NULL_CONSTRAINT", "BOOLEAN", 
			"BASE_DOMAIN", "L_PAREN", "R_PAREN", "L_CURLY", "R_CURLY", "L_SQUARE", 
			"R_SQUARE", "COMA", "FULLSTOP", "HASH", "AMPERSAND", "AND", "OR", "NOT", 
			"CURRENT_DATE", "TODAY", "NOW", "IN", "LIKE", "BETWEEN", "SUM", "AVG", 
			"COUNT", "MIN", "MAX", "GE", "LE", "NEQ", "EQ", "GT", "LT", "PLUS", "MINUS", 
			"ASTERISK", "SLASH", "DATE", "STRING", "REAL", "INT", "WHITESPACE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ConstraintParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ConstraintParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstraintContext extends ParserRuleContext {
		public ValueConstraintContext valueConstraint() {
			return getRuleContext(ValueConstraintContext.class,0);
		}
		public InConstraintContext inConstraint() {
			return getRuleContext(InConstraintContext.class,0);
		}
		public LikeConstraintContext likeConstraint() {
			return getRuleContext(LikeConstraintContext.class,0);
		}
		public BetweenConstraintContext betweenConstraint() {
			return getRuleContext(BetweenConstraintContext.class,0);
		}
		public ArithmeticConstraintContext arithmeticConstraint() {
			return getRuleContext(ArithmeticConstraintContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_constraint);
		try {
			setState(37);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				valueConstraint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				inConstraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				likeConstraint();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				betweenConstraint();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				arithmeticConstraint();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueConstraintContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(ConstraintParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(ConstraintParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(ConstraintParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(ConstraintParser.OR, i);
		}
		public ValueConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterValueConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitValueConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitValueConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueConstraintContext valueConstraint() throws RecognitionException {
		ValueConstraintContext _localctx = new ValueConstraintContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_valueConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			expression();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(40);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(41);
				expression();
				}
				}
				setState(46);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public ComparableValueContext comparableValue() {
			return getRuleContext(ComparableValueContext.class,0);
		}
		public TerminalNode NOT() { return getToken(ConstraintParser.NOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(47);
				match(NOT);
				}
			}

			setState(50);
			operator();
			setState(51);
			comparableValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparableValueContext extends ParserRuleContext {
		public DateValueContext dateValue() {
			return getRuleContext(DateValueContext.class,0);
		}
		public TerminalNode REAL() { return getToken(ConstraintParser.REAL, 0); }
		public TerminalNode INT() { return getToken(ConstraintParser.INT, 0); }
		public ComparableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparableValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterComparableValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitComparableValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitComparableValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparableValueContext comparableValue() throws RecognitionException {
		ComparableValueContext _localctx = new ComparableValueContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_comparableValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_DATE:
			case TODAY:
			case NOW:
			case DATE:
				{
				setState(53);
				dateValue();
				}
				break;
			case REAL:
				{
				setState(54);
				match(REAL);
				}
				break;
			case INT:
				{
				setState(55);
				match(INT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DateValueContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(ConstraintParser.DATE, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(ConstraintParser.CURRENT_DATE, 0); }
		public TerminalNode TODAY() { return getToken(ConstraintParser.TODAY, 0); }
		public TerminalNode NOW() { return getToken(ConstraintParser.NOW, 0); }
		public DateValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterDateValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitDateValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitDateValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateValueContext dateValue() throws RecognitionException {
		DateValueContext _localctx = new DateValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_dateValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 576462676448772096L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode GE() { return getToken(ConstraintParser.GE, 0); }
		public TerminalNode LE() { return getToken(ConstraintParser.LE, 0); }
		public TerminalNode NEQ() { return getToken(ConstraintParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(ConstraintParser.EQ, 0); }
		public TerminalNode GT() { return getToken(ConstraintParser.GT, 0); }
		public TerminalNode LT() { return getToken(ConstraintParser.LT, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35465847065542656L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InConstraintContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(ConstraintParser.IN, 0); }
		public TerminalNode L_PAREN() { return getToken(ConstraintParser.L_PAREN, 0); }
		public List<InValueContext> inValue() {
			return getRuleContexts(InValueContext.class);
		}
		public InValueContext inValue(int i) {
			return getRuleContext(InValueContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(ConstraintParser.R_PAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(ConstraintParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(ConstraintParser.COMA, i);
		}
		public InConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterInConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitInConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitInConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InConstraintContext inConstraint() throws RecognitionException {
		InConstraintContext _localctx = new InConstraintContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_inConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(IN);
			setState(63);
			match(L_PAREN);
			setState(64);
			inValue();
			setState(67); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(65);
				match(COMA);
				setState(66);
				inValue();
				}
				}
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMA );
			setState(71);
			match(R_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InValueContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(ConstraintParser.DATE, 0); }
		public TerminalNode STRING() { return getToken(ConstraintParser.STRING, 0); }
		public TerminalNode REAL() { return getToken(ConstraintParser.REAL, 0); }
		public TerminalNode INT() { return getToken(ConstraintParser.INT, 0); }
		public InValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterInValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitInValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitInValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InValueContext inValue() throws RecognitionException {
		InValueContext _localctx = new InValueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8646911284551352320L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LikeConstraintContext extends ParserRuleContext {
		public TerminalNode LIKE() { return getToken(ConstraintParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(ConstraintParser.STRING, 0); }
		public LikeConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterLikeConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitLikeConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitLikeConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeConstraintContext likeConstraint() throws RecognitionException {
		LikeConstraintContext _localctx = new LikeConstraintContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_likeConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(LIKE);
			setState(76);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BetweenConstraintContext extends ParserRuleContext {
		public TerminalNode BETWEEN() { return getToken(ConstraintParser.BETWEEN, 0); }
		public TerminalNode L_PAREN() { return getToken(ConstraintParser.L_PAREN, 0); }
		public List<BetweenValueContext> betweenValue() {
			return getRuleContexts(BetweenValueContext.class);
		}
		public BetweenValueContext betweenValue(int i) {
			return getRuleContext(BetweenValueContext.class,i);
		}
		public TerminalNode COMA() { return getToken(ConstraintParser.COMA, 0); }
		public TerminalNode R_PAREN() { return getToken(ConstraintParser.R_PAREN, 0); }
		public BetweenConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterBetweenConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitBetweenConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitBetweenConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenConstraintContext betweenConstraint() throws RecognitionException {
		BetweenConstraintContext _localctx = new BetweenConstraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_betweenConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(BETWEEN);
			setState(79);
			match(L_PAREN);
			setState(80);
			betweenValue();
			setState(81);
			match(COMA);
			setState(82);
			betweenValue();
			setState(83);
			match(R_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BetweenValueContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(ConstraintParser.DATE, 0); }
		public TerminalNode REAL() { return getToken(ConstraintParser.REAL, 0); }
		public TerminalNode INT() { return getToken(ConstraintParser.INT, 0); }
		public BetweenValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterBetweenValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitBetweenValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitBetweenValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenValueContext betweenValue() throws RecognitionException {
		BetweenValueContext _localctx = new BetweenValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_betweenValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7493989779944505344L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticConstraintContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(ConstraintParser.EQ, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ArithmeticConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterArithmeticConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitArithmeticConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitArithmeticConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticConstraintContext arithmeticConstraint() throws RecognitionException {
		ArithmeticConstraintContext _localctx = new ArithmeticConstraintContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arithmeticConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			match(EQ);
			setState(88);
			arithmeticExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticExpressionContext extends ParserRuleContext {
		public Token PLUS;
		public List<Token> op = new ArrayList<Token>();
		public Token MINUS;
		public Token _tset237;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(ConstraintParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(ConstraintParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(ConstraintParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(ConstraintParser.MINUS, i);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arithmeticExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			term();
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(91);
				((ArithmeticExpressionContext)_localctx)._tset237 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==PLUS || _la==MINUS) ) {
					((ArithmeticExpressionContext)_localctx)._tset237 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((ArithmeticExpressionContext)_localctx).op.add(((ArithmeticExpressionContext)_localctx)._tset237);
				setState(92);
				term();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public Token ASTERISK;
		public List<Token> op = new ArrayList<Token>();
		public Token SLASH;
		public Token _tset257;
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public List<TerminalNode> ASTERISK() { return getTokens(ConstraintParser.ASTERISK); }
		public TerminalNode ASTERISK(int i) {
			return getToken(ConstraintParser.ASTERISK, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(ConstraintParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(ConstraintParser.SLASH, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			atom();
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASTERISK || _la==SLASH) {
				{
				{
				setState(99);
				((TermContext)_localctx)._tset257 = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ASTERISK || _la==SLASH) ) {
					((TermContext)_localctx)._tset257 = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				((TermContext)_localctx).op.add(((TermContext)_localctx)._tset257);
				setState(100);
				atom();
				}
				}
				setState(105);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(ConstraintParser.STRING, 0); }
		public TerminalNode INT() { return getToken(ConstraintParser.INT, 0); }
		public TerminalNode REAL() { return getToken(ConstraintParser.REAL, 0); }
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(ConstraintParser.L_PAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(ConstraintParser.R_PAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(INT);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				match(REAL);
				}
				break;
			case SUM:
			case AVG:
			case COUNT:
			case MIN:
			case MAX:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				aggregateFunction();
				}
				break;
			case L_PAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				match(L_PAREN);
				setState(111);
				arithmeticExpression();
				setState(112);
				match(R_PAREN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AggregateFunctionContext extends ParserRuleContext {
		public TerminalNode L_PAREN() { return getToken(ConstraintParser.L_PAREN, 0); }
		public TerminalNode STRING() { return getToken(ConstraintParser.STRING, 0); }
		public TerminalNode R_PAREN() { return getToken(ConstraintParser.R_PAREN, 0); }
		public TerminalNode SUM() { return getToken(ConstraintParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(ConstraintParser.AVG, 0); }
		public TerminalNode COUNT() { return getToken(ConstraintParser.COUNT, 0); }
		public TerminalNode MIN() { return getToken(ConstraintParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(ConstraintParser.MAX, 0); }
		public AggregateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).enterAggregateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ConstraintParserListener ) ((ConstraintParserListener)listener).exitAggregateFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ConstraintParserVisitor ) return ((ConstraintParserVisitor<? extends T>)visitor).visitAggregateFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateFunctionContext aggregateFunction() throws RecognitionException {
		AggregateFunctionContext _localctx = new AggregateFunctionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_aggregateFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 545357767376896L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(117);
			match(L_PAREN);
			setState(118);
			match(STRING);
			setState(119);
			match(R_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001?z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002\f\u0007"+
		"\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000&\b"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001+\b\u0001\n\u0001"+
		"\f\u0001.\t\u0001\u0001\u0002\u0003\u00021\b\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u00039\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0004\u0006D\b\u0006\u000b\u0006"+
		"\f\u0006E\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f"+
		"\u0005\f^\b\f\n\f\f\fa\t\f\u0001\r\u0001\r\u0001\r\u0005\rf\b\r\n\r\f"+
		"\ri\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0003\u000es\b\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0000\u0000\u0010"+
		"\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e\u0000\b\u0001\u0000#$\u0002\u0000&(;;\u0001\u000016\u0001"+
		"\u0000;>\u0002\u0000;;=>\u0001\u000078\u0001\u00009:\u0001\u0000,0x\u0000"+
		"%\u0001\u0000\u0000\u0000\u0002\'\u0001\u0000\u0000\u0000\u00040\u0001"+
		"\u0000\u0000\u0000\u00068\u0001\u0000\u0000\u0000\b:\u0001\u0000\u0000"+
		"\u0000\n<\u0001\u0000\u0000\u0000\f>\u0001\u0000\u0000\u0000\u000eI\u0001"+
		"\u0000\u0000\u0000\u0010K\u0001\u0000\u0000\u0000\u0012N\u0001\u0000\u0000"+
		"\u0000\u0014U\u0001\u0000\u0000\u0000\u0016W\u0001\u0000\u0000\u0000\u0018"+
		"Z\u0001\u0000\u0000\u0000\u001ab\u0001\u0000\u0000\u0000\u001cr\u0001"+
		"\u0000\u0000\u0000\u001et\u0001\u0000\u0000\u0000 &\u0003\u0002\u0001"+
		"\u0000!&\u0003\f\u0006\u0000\"&\u0003\u0010\b\u0000#&\u0003\u0012\t\u0000"+
		"$&\u0003\u0016\u000b\u0000% \u0001\u0000\u0000\u0000%!\u0001\u0000\u0000"+
		"\u0000%\"\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000%$\u0001\u0000"+
		"\u0000\u0000&\u0001\u0001\u0000\u0000\u0000\',\u0003\u0004\u0002\u0000"+
		"()\u0007\u0000\u0000\u0000)+\u0003\u0004\u0002\u0000*(\u0001\u0000\u0000"+
		"\u0000+.\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000,-\u0001\u0000"+
		"\u0000\u0000-\u0003\u0001\u0000\u0000\u0000.,\u0001\u0000\u0000\u0000"+
		"/1\u0005%\u0000\u00000/\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"12\u0001\u0000\u0000\u000023\u0003\n\u0005\u000034\u0003\u0006\u0003\u0000"+
		"4\u0005\u0001\u0000\u0000\u000059\u0003\b\u0004\u000069\u0005=\u0000\u0000"+
		"79\u0005>\u0000\u000085\u0001\u0000\u0000\u000086\u0001\u0000\u0000\u0000"+
		"87\u0001\u0000\u0000\u00009\u0007\u0001\u0000\u0000\u0000:;\u0007\u0001"+
		"\u0000\u0000;\t\u0001\u0000\u0000\u0000<=\u0007\u0002\u0000\u0000=\u000b"+
		"\u0001\u0000\u0000\u0000>?\u0005)\u0000\u0000?@\u0005\u0019\u0000\u0000"+
		"@C\u0003\u000e\u0007\u0000AB\u0005\u001f\u0000\u0000BD\u0003\u000e\u0007"+
		"\u0000CA\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000\u0000EC\u0001\u0000"+
		"\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000GH\u0005"+
		"\u001a\u0000\u0000H\r\u0001\u0000\u0000\u0000IJ\u0007\u0003\u0000\u0000"+
		"J\u000f\u0001\u0000\u0000\u0000KL\u0005*\u0000\u0000LM\u0005<\u0000\u0000"+
		"M\u0011\u0001\u0000\u0000\u0000NO\u0005+\u0000\u0000OP\u0005\u0019\u0000"+
		"\u0000PQ\u0003\u0014\n\u0000QR\u0005\u001f\u0000\u0000RS\u0003\u0014\n"+
		"\u0000ST\u0005\u001a\u0000\u0000T\u0013\u0001\u0000\u0000\u0000UV\u0007"+
		"\u0004\u0000\u0000V\u0015\u0001\u0000\u0000\u0000WX\u00054\u0000\u0000"+
		"XY\u0003\u0018\f\u0000Y\u0017\u0001\u0000\u0000\u0000Z_\u0003\u001a\r"+
		"\u0000[\\\u0007\u0005\u0000\u0000\\^\u0003\u001a\r\u0000][\u0001\u0000"+
		"\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001"+
		"\u0000\u0000\u0000`\u0019\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000"+
		"\u0000bg\u0003\u001c\u000e\u0000cd\u0007\u0006\u0000\u0000df\u0003\u001c"+
		"\u000e\u0000ec\u0001\u0000\u0000\u0000fi\u0001\u0000\u0000\u0000ge\u0001"+
		"\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000h\u001b\u0001\u0000\u0000"+
		"\u0000ig\u0001\u0000\u0000\u0000js\u0005<\u0000\u0000ks\u0005>\u0000\u0000"+
		"ls\u0005=\u0000\u0000ms\u0003\u001e\u000f\u0000no\u0005\u0019\u0000\u0000"+
		"op\u0003\u0018\f\u0000pq\u0005\u001a\u0000\u0000qs\u0001\u0000\u0000\u0000"+
		"rj\u0001\u0000\u0000\u0000rk\u0001\u0000\u0000\u0000rl\u0001\u0000\u0000"+
		"\u0000rm\u0001\u0000\u0000\u0000rn\u0001\u0000\u0000\u0000s\u001d\u0001"+
		"\u0000\u0000\u0000tu\u0007\u0007\u0000\u0000uv\u0005\u0019\u0000\u0000"+
		"vw\u0005<\u0000\u0000wx\u0005\u001a\u0000\u0000x\u001f\u0001\u0000\u0000"+
		"\u0000\b%,08E_gr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}