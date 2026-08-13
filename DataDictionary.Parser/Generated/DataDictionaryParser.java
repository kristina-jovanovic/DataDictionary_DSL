// Generated from DataDictionaryParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class DataDictionaryParser extends Parser {
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
		RULE_program = 0, RULE_dataDictionary = 1, RULE_logicalFunctionDecl = 2, 
		RULE_semanticDomainDecl = 3, RULE_enumeratedDomainDecl = 4, RULE_value = 5, 
		RULE_structureDecl = 6, RULE_constructionDecl = 7, RULE_aggregationDecl = 8, 
		RULE_setDecl = 9, RULE_specializationDecl = 10, RULE_exclusiveSpecializationDecl = 11, 
		RULE_inclusiveSpecializationDecl = 12, RULE_componentDecl = 13, RULE_structureReference = 14, 
		RULE_fieldDecl = 15, RULE_domainReference = 16, RULE_format = 17, RULE_note = 18, 
		RULE_constraint = 19, RULE_valueConstraint = 20, RULE_expression = 21, 
		RULE_comparableValue = 22, RULE_dateValue = 23, RULE_operator = 24, RULE_inConstraint = 25, 
		RULE_inValue = 26, RULE_likeConstraint = 27, RULE_betweenConstraint = 28, 
		RULE_betweenValue = 29, RULE_arithmeticConstraint = 30, RULE_arithmeticExpression = 31, 
		RULE_term = 32, RULE_atom = 33, RULE_aggregateFunction = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dataDictionary", "logicalFunctionDecl", "semanticDomainDecl", 
			"enumeratedDomainDecl", "value", "structureDecl", "constructionDecl", 
			"aggregationDecl", "setDecl", "specializationDecl", "exclusiveSpecializationDecl", 
			"inclusiveSpecializationDecl", "componentDecl", "structureReference", 
			"fieldDecl", "domainReference", "format", "note", "constraint", "valueConstraint", 
			"expression", "comparableValue", "dateValue", "operator", "inConstraint", 
			"inValue", "likeConstraint", "betweenConstraint", "betweenValue", "arithmeticConstraint", 
			"arithmeticExpression", "term", "atom", "aggregateFunction"
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
	public String getGrammarFileName() { return "DataDictionaryParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public DataDictionaryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public DataDictionaryContext dataDictionary() {
			return getRuleContext(DataDictionaryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(DataDictionaryParser.EOF, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			dataDictionary();
			setState(71);
			match(EOF);
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
	public static class DataDictionaryContext extends ParserRuleContext {
		public TerminalNode DD_LABEL() { return getToken(DataDictionaryParser.DD_LABEL, 0); }
		public TerminalNode ID_LABEL() { return getToken(DataDictionaryParser.ID_LABEL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode NAME_LABEL() { return getToken(DataDictionaryParser.NAME_LABEL, 0); }
		public List<TerminalNode> STRING() { return getTokens(DataDictionaryParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(DataDictionaryParser.STRING, i);
		}
		public TerminalNode AUTHOR_LABEL() { return getToken(DataDictionaryParser.AUTHOR_LABEL, 0); }
		public TerminalNode VERSION_LABEL() { return getToken(DataDictionaryParser.VERSION_LABEL, 0); }
		public TerminalNode DATE_OF_CREATION_LABEL() { return getToken(DataDictionaryParser.DATE_OF_CREATION_LABEL, 0); }
		public TerminalNode DATE() { return getToken(DataDictionaryParser.DATE, 0); }
		public TerminalNode L_CURLY() { return getToken(DataDictionaryParser.L_CURLY, 0); }
		public TerminalNode STRUCTURES_LABEL() { return getToken(DataDictionaryParser.STRUCTURES_LABEL, 0); }
		public TerminalNode R_CURLY() { return getToken(DataDictionaryParser.R_CURLY, 0); }
		public List<LogicalFunctionDeclContext> logicalFunctionDecl() {
			return getRuleContexts(LogicalFunctionDeclContext.class);
		}
		public LogicalFunctionDeclContext logicalFunctionDecl(int i) {
			return getRuleContext(LogicalFunctionDeclContext.class,i);
		}
		public List<SemanticDomainDeclContext> semanticDomainDecl() {
			return getRuleContexts(SemanticDomainDeclContext.class);
		}
		public SemanticDomainDeclContext semanticDomainDecl(int i) {
			return getRuleContext(SemanticDomainDeclContext.class,i);
		}
		public List<StructureDeclContext> structureDecl() {
			return getRuleContexts(StructureDeclContext.class);
		}
		public StructureDeclContext structureDecl(int i) {
			return getRuleContext(StructureDeclContext.class,i);
		}
		public DataDictionaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataDictionary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterDataDictionary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitDataDictionary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitDataDictionary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DataDictionaryContext dataDictionary() throws RecognitionException {
		DataDictionaryContext _localctx = new DataDictionaryContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dataDictionary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			match(DD_LABEL);
			setState(74);
			match(ID_LABEL);
			setState(75);
			match(INT);
			setState(76);
			match(NAME_LABEL);
			setState(77);
			match(STRING);
			setState(78);
			match(AUTHOR_LABEL);
			setState(79);
			match(STRING);
			setState(80);
			match(VERSION_LABEL);
			setState(81);
			match(STRING);
			setState(82);
			match(DATE_OF_CREATION_LABEL);
			setState(83);
			match(DATE);
			setState(84);
			match(L_CURLY);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LF_LABEL) {
				{
				{
				setState(85);
				logicalFunctionDecl();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SD_LABEL) {
				{
				{
				setState(91);
				semanticDomainDecl();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			match(STRUCTURES_LABEL);
			setState(99); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(98);
				structureDecl();
				}
				}
				setState(101); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 32780L) != 0) );
			setState(103);
			match(R_CURLY);
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
	public static class LogicalFunctionDeclContext extends ParserRuleContext {
		public TerminalNode LF_LABEL() { return getToken(DataDictionaryParser.LF_LABEL, 0); }
		public TerminalNode ID_LABEL() { return getToken(DataDictionaryParser.ID_LABEL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode NAME_LABEL() { return getToken(DataDictionaryParser.NAME_LABEL, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public TerminalNode DEFINITION_LABEL() { return getToken(DataDictionaryParser.DEFINITION_LABEL, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode RESULT_LABEL() { return getToken(DataDictionaryParser.RESULT_LABEL, 0); }
		public TerminalNode BOOLEAN() { return getToken(DataDictionaryParser.BOOLEAN, 0); }
		public LogicalFunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logicalFunctionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterLogicalFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitLogicalFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitLogicalFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicalFunctionDeclContext logicalFunctionDecl() throws RecognitionException {
		LogicalFunctionDeclContext _localctx = new LogicalFunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_logicalFunctionDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(LF_LABEL);
			setState(106);
			match(ID_LABEL);
			setState(107);
			match(INT);
			setState(108);
			match(NAME_LABEL);
			setState(109);
			match(STRING);
			setState(110);
			match(DEFINITION_LABEL);
			setState(111);
			constraint();
			setState(112);
			match(RESULT_LABEL);
			setState(113);
			match(BOOLEAN);
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
	public static class SemanticDomainDeclContext extends ParserRuleContext {
		public TerminalNode SD_LABEL() { return getToken(DataDictionaryParser.SD_LABEL, 0); }
		public TerminalNode ID_LABEL() { return getToken(DataDictionaryParser.ID_LABEL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode NAME_LABEL() { return getToken(DataDictionaryParser.NAME_LABEL, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public TerminalNode BASE_LABEL() { return getToken(DataDictionaryParser.BASE_LABEL, 0); }
		public DomainReferenceContext domainReference() {
			return getRuleContext(DomainReferenceContext.class,0);
		}
		public TerminalNode CONSTRAINT_LABEL() { return getToken(DataDictionaryParser.CONSTRAINT_LABEL, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public EnumeratedDomainDeclContext enumeratedDomainDecl() {
			return getRuleContext(EnumeratedDomainDeclContext.class,0);
		}
		public SemanticDomainDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semanticDomainDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterSemanticDomainDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitSemanticDomainDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitSemanticDomainDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemanticDomainDeclContext semanticDomainDecl() throws RecognitionException {
		SemanticDomainDeclContext _localctx = new SemanticDomainDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_semanticDomainDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(SD_LABEL);
			setState(116);
			match(ID_LABEL);
			setState(117);
			match(INT);
			setState(118);
			match(NAME_LABEL);
			setState(119);
			match(STRING);
			setState(120);
			match(BASE_LABEL);
			setState(121);
			domainReference();
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINT_LABEL) {
				{
				setState(122);
				match(CONSTRAINT_LABEL);
				setState(123);
				constraint();
				}
			}

			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VALUES_LABEL) {
				{
				setState(126);
				enumeratedDomainDecl();
				}
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
	public static class EnumeratedDomainDeclContext extends ParserRuleContext {
		public TerminalNode VALUES_LABEL() { return getToken(DataDictionaryParser.VALUES_LABEL, 0); }
		public TerminalNode L_PAREN() { return getToken(DataDictionaryParser.L_PAREN, 0); }
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(DataDictionaryParser.R_PAREN, 0); }
		public EnumeratedDomainDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumeratedDomainDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterEnumeratedDomainDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitEnumeratedDomainDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitEnumeratedDomainDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumeratedDomainDeclContext enumeratedDomainDecl() throws RecognitionException {
		EnumeratedDomainDeclContext _localctx = new EnumeratedDomainDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_enumeratedDomainDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(VALUES_LABEL);
			setState(130);
			match(L_PAREN);
			setState(131);
			value();
			setState(133); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(132);
				value();
				}
				}
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8646911284559740928L) != 0) );
			setState(137);
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
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public TerminalNode REAL() { return getToken(DataDictionaryParser.REAL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode DATE() { return getToken(DataDictionaryParser.DATE, 0); }
		public TerminalNode BOOLEAN() { return getToken(DataDictionaryParser.BOOLEAN, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8646911284559740928L) != 0)) ) {
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
	public static class StructureDeclContext extends ParserRuleContext {
		public TerminalNode TYPE_LABEL() { return getToken(DataDictionaryParser.TYPE_LABEL, 0); }
		public TerminalNode STRUCTURE_TYPE() { return getToken(DataDictionaryParser.STRUCTURE_TYPE, 0); }
		public TerminalNode ID_LABEL() { return getToken(DataDictionaryParser.ID_LABEL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode NAME_LABEL() { return getToken(DataDictionaryParser.NAME_LABEL, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public List<ConstructionDeclContext> constructionDecl() {
			return getRuleContexts(ConstructionDeclContext.class);
		}
		public ConstructionDeclContext constructionDecl(int i) {
			return getRuleContext(ConstructionDeclContext.class,i);
		}
		public StructureDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structureDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterStructureDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitStructureDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitStructureDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureDeclContext structureDecl() throws RecognitionException {
		StructureDeclContext _localctx = new StructureDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structureDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID_LABEL) {
				{
				setState(141);
				match(ID_LABEL);
				setState(142);
				match(INT);
				}
			}

			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAME_LABEL) {
				{
				setState(145);
				match(NAME_LABEL);
				setState(146);
				match(STRING);
				}
			}

			setState(149);
			match(TYPE_LABEL);
			setState(150);
			match(STRUCTURE_TYPE);
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				constructionDecl();
				}
				}
				setState(154); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 306244775332282368L) != 0) );
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
	public static class ConstructionDeclContext extends ParserRuleContext {
		public AggregationDeclContext aggregationDecl() {
			return getRuleContext(AggregationDeclContext.class,0);
		}
		public SetDeclContext setDecl() {
			return getRuleContext(SetDeclContext.class,0);
		}
		public SpecializationDeclContext specializationDecl() {
			return getRuleContext(SpecializationDeclContext.class,0);
		}
		public ConstructionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterConstructionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitConstructionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitConstructionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructionDeclContext constructionDecl() throws RecognitionException {
		ConstructionDeclContext _localctx = new ConstructionDeclContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constructionDecl);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				aggregationDecl();
				}
				break;
			case L_CURLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				setDecl();
				}
				break;
			case L_SQUARE:
			case SLASH:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				specializationDecl();
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
	public static class AggregationDeclContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(DataDictionaryParser.LT, 0); }
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public TerminalNode GT() { return getToken(DataDictionaryParser.GT, 0); }
		public AggregationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterAggregationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitAggregationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitAggregationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregationDeclContext aggregationDecl() throws RecognitionException {
		AggregationDeclContext _localctx = new AggregationDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_aggregationDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(LT);
			setState(162);
			componentDecl();
			setState(164); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(163);
				componentDecl();
				}
				}
				setState(166); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_LABEL );
			setState(168);
			match(GT);
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
	public static class SetDeclContext extends ParserRuleContext {
		public TerminalNode L_CURLY() { return getToken(DataDictionaryParser.L_CURLY, 0); }
		public TerminalNode R_CURLY() { return getToken(DataDictionaryParser.R_CURLY, 0); }
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public SetDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterSetDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitSetDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitSetDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetDeclContext setDecl() throws RecognitionException {
		SetDeclContext _localctx = new SetDeclContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_setDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(L_CURLY);
			setState(172); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(171);
				componentDecl();
				}
				}
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_LABEL );
			setState(176);
			match(R_CURLY);
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
	public static class SpecializationDeclContext extends ParserRuleContext {
		public ExclusiveSpecializationDeclContext exclusiveSpecializationDecl() {
			return getRuleContext(ExclusiveSpecializationDeclContext.class,0);
		}
		public InclusiveSpecializationDeclContext inclusiveSpecializationDecl() {
			return getRuleContext(InclusiveSpecializationDeclContext.class,0);
		}
		public SpecializationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specializationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterSpecializationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitSpecializationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitSpecializationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecializationDeclContext specializationDecl() throws RecognitionException {
		SpecializationDeclContext _localctx = new SpecializationDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_specializationDecl);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_SQUARE:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				exclusiveSpecializationDecl();
				}
				break;
			case SLASH:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				inclusiveSpecializationDecl();
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
	public static class ExclusiveSpecializationDeclContext extends ParserRuleContext {
		public TerminalNode L_SQUARE() { return getToken(DataDictionaryParser.L_SQUARE, 0); }
		public TerminalNode R_SQUARE() { return getToken(DataDictionaryParser.R_SQUARE, 0); }
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public ExclusiveSpecializationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusiveSpecializationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterExclusiveSpecializationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitExclusiveSpecializationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitExclusiveSpecializationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclusiveSpecializationDeclContext exclusiveSpecializationDecl() throws RecognitionException {
		ExclusiveSpecializationDeclContext _localctx = new ExclusiveSpecializationDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_exclusiveSpecializationDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(L_SQUARE);
			setState(184); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(183);
				componentDecl();
				}
				}
				setState(186); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_LABEL );
			setState(188);
			match(R_SQUARE);
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
	public static class InclusiveSpecializationDeclContext extends ParserRuleContext {
		public List<TerminalNode> SLASH() { return getTokens(DataDictionaryParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(DataDictionaryParser.SLASH, i);
		}
		public List<ComponentDeclContext> componentDecl() {
			return getRuleContexts(ComponentDeclContext.class);
		}
		public ComponentDeclContext componentDecl(int i) {
			return getRuleContext(ComponentDeclContext.class,i);
		}
		public InclusiveSpecializationDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusiveSpecializationDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterInclusiveSpecializationDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitInclusiveSpecializationDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitInclusiveSpecializationDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InclusiveSpecializationDeclContext inclusiveSpecializationDecl() throws RecognitionException {
		InclusiveSpecializationDeclContext _localctx = new InclusiveSpecializationDeclContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_inclusiveSpecializationDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			match(SLASH);
			setState(191);
			componentDecl();
			setState(193); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(192);
				componentDecl();
				}
				}
				setState(195); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_LABEL );
			setState(197);
			match(SLASH);
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
	public static class ComponentDeclContext extends ParserRuleContext {
		public TerminalNode ID_LABEL() { return getToken(DataDictionaryParser.ID_LABEL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode NAME_LABEL() { return getToken(DataDictionaryParser.NAME_LABEL, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public List<TerminalNode> HASH() { return getTokens(DataDictionaryParser.HASH); }
		public TerminalNode HASH(int i) {
			return getToken(DataDictionaryParser.HASH, i);
		}
		public List<TerminalNode> AMPERSAND() { return getTokens(DataDictionaryParser.AMPERSAND); }
		public TerminalNode AMPERSAND(int i) {
			return getToken(DataDictionaryParser.AMPERSAND, i);
		}
		public FieldDeclContext fieldDecl() {
			return getRuleContext(FieldDeclContext.class,0);
		}
		public StructureDeclContext structureDecl() {
			return getRuleContext(StructureDeclContext.class,0);
		}
		public StructureReferenceContext structureReference() {
			return getRuleContext(StructureReferenceContext.class,0);
		}
		public ComponentDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_componentDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterComponentDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitComponentDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitComponentDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentDeclContext componentDecl() throws RecognitionException {
		ComponentDeclContext _localctx = new ComponentDeclContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_componentDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(ID_LABEL);
			setState(200);
			match(INT);
			setState(201);
			match(NAME_LABEL);
			setState(202);
			match(STRING);
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HASH:
				{
				{
				setState(203);
				match(HASH);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(204);
					structureDecl();
					}
					break;
				case 2:
					{
					setState(205);
					structureReference();
					}
					break;
				}
				setState(208);
				match(HASH);
				}
				}
				break;
			case AMPERSAND:
				{
				{
				setState(210);
				match(AMPERSAND);
				setState(211);
				fieldDecl();
				setState(212);
				match(AMPERSAND);
				}
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
	public static class StructureReferenceContext extends ParserRuleContext {
		public TerminalNode NAME_LABEL() { return getToken(DataDictionaryParser.NAME_LABEL, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public StructureReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structureReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterStructureReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitStructureReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitStructureReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StructureReferenceContext structureReference() throws RecognitionException {
		StructureReferenceContext _localctx = new StructureReferenceContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_structureReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
			match(NAME_LABEL);
			setState(217);
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
	public static class FieldDeclContext extends ParserRuleContext {
		public TerminalNode DOMAIN_LABEL() { return getToken(DataDictionaryParser.DOMAIN_LABEL, 0); }
		public DomainReferenceContext domainReference() {
			return getRuleContext(DomainReferenceContext.class,0);
		}
		public TerminalNode FORMAT_LABEL() { return getToken(DataDictionaryParser.FORMAT_LABEL, 0); }
		public FormatContext format() {
			return getRuleContext(FormatContext.class,0);
		}
		public TerminalNode NULLABILITY_LABEL() { return getToken(DataDictionaryParser.NULLABILITY_LABEL, 0); }
		public TerminalNode NULL_CONSTRAINT() { return getToken(DataDictionaryParser.NULL_CONSTRAINT, 0); }
		public TerminalNode CONSTRAINT_LABEL() { return getToken(DataDictionaryParser.CONSTRAINT_LABEL, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public TerminalNode DEFAULT_LABEL() { return getToken(DataDictionaryParser.DEFAULT_LABEL, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode NOTE_LABEL() { return getToken(DataDictionaryParser.NOTE_LABEL, 0); }
		public NoteContext note() {
			return getRuleContext(NoteContext.class,0);
		}
		public FieldDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterFieldDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitFieldDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitFieldDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDeclContext fieldDecl() throws RecognitionException {
		FieldDeclContext _localctx = new FieldDeclContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_fieldDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(DOMAIN_LABEL);
			setState(220);
			domainReference();
			setState(223);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FORMAT_LABEL) {
				{
				setState(221);
				match(FORMAT_LABEL);
				setState(222);
				format();
				}
			}

			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLABILITY_LABEL) {
				{
				setState(225);
				match(NULLABILITY_LABEL);
				setState(226);
				match(NULL_CONSTRAINT);
				}
			}

			setState(231);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRAINT_LABEL) {
				{
				setState(229);
				match(CONSTRAINT_LABEL);
				setState(230);
				constraint();
				}
			}

			setState(235);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT_LABEL) {
				{
				setState(233);
				match(DEFAULT_LABEL);
				setState(234);
				value();
				}
			}

			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOTE_LABEL) {
				{
				setState(237);
				match(NOTE_LABEL);
				setState(238);
				note();
				}
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
	public static class DomainReferenceContext extends ParserRuleContext {
		public TerminalNode BASE_DOMAIN() { return getToken(DataDictionaryParser.BASE_DOMAIN, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public DomainReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_domainReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterDomainReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitDomainReference(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitDomainReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DomainReferenceContext domainReference() throws RecognitionException {
		DomainReferenceContext _localctx = new DomainReferenceContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_domainReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==BASE_DOMAIN || _la==STRING) ) {
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
	public static class FormatContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public FormatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_format; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterFormat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitFormat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitFormat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormatContext format() throws RecognitionException {
		FormatContext _localctx = new FormatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_format);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
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
	public static class NoteContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public NoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_note; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterNote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitNote(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitNote(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NoteContext note() throws RecognitionException {
		NoteContext _localctx = new NoteContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_note);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
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
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_constraint);
		try {
			setState(252);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				valueConstraint();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(248);
				inConstraint();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(249);
				likeConstraint();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(250);
				betweenConstraint();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(251);
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
		public List<TerminalNode> AND() { return getTokens(DataDictionaryParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(DataDictionaryParser.AND, i);
		}
		public List<TerminalNode> OR() { return getTokens(DataDictionaryParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(DataDictionaryParser.OR, i);
		}
		public ValueConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterValueConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitValueConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitValueConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueConstraintContext valueConstraint() throws RecognitionException {
		ValueConstraintContext _localctx = new ValueConstraintContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_valueConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			expression();
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==OR) {
				{
				{
				setState(255);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==OR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(256);
				expression();
				}
				}
				setState(261);
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
		public TerminalNode NOT() { return getToken(DataDictionaryParser.NOT, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(262);
				match(NOT);
				}
			}

			setState(265);
			operator();
			setState(266);
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
		public TerminalNode REAL() { return getToken(DataDictionaryParser.REAL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public ComparableValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparableValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterComparableValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitComparableValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitComparableValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparableValueContext comparableValue() throws RecognitionException {
		ComparableValueContext _localctx = new ComparableValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_comparableValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CURRENT_DATE:
			case TODAY:
			case NOW:
			case DATE:
				{
				setState(268);
				dateValue();
				}
				break;
			case REAL:
				{
				setState(269);
				match(REAL);
				}
				break;
			case INT:
				{
				setState(270);
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
		public TerminalNode DATE() { return getToken(DataDictionaryParser.DATE, 0); }
		public TerminalNode CURRENT_DATE() { return getToken(DataDictionaryParser.CURRENT_DATE, 0); }
		public TerminalNode TODAY() { return getToken(DataDictionaryParser.TODAY, 0); }
		public TerminalNode NOW() { return getToken(DataDictionaryParser.NOW, 0); }
		public DateValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterDateValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitDateValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitDateValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DateValueContext dateValue() throws RecognitionException {
		DateValueContext _localctx = new DateValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dateValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
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
		public TerminalNode GE() { return getToken(DataDictionaryParser.GE, 0); }
		public TerminalNode LE() { return getToken(DataDictionaryParser.LE, 0); }
		public TerminalNode NEQ() { return getToken(DataDictionaryParser.NEQ, 0); }
		public TerminalNode EQ() { return getToken(DataDictionaryParser.EQ, 0); }
		public TerminalNode GT() { return getToken(DataDictionaryParser.GT, 0); }
		public TerminalNode LT() { return getToken(DataDictionaryParser.LT, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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
		public TerminalNode IN() { return getToken(DataDictionaryParser.IN, 0); }
		public TerminalNode L_PAREN() { return getToken(DataDictionaryParser.L_PAREN, 0); }
		public List<InValueContext> inValue() {
			return getRuleContexts(InValueContext.class);
		}
		public InValueContext inValue(int i) {
			return getRuleContext(InValueContext.class,i);
		}
		public TerminalNode R_PAREN() { return getToken(DataDictionaryParser.R_PAREN, 0); }
		public List<TerminalNode> COMA() { return getTokens(DataDictionaryParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(DataDictionaryParser.COMA, i);
		}
		public InConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterInConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitInConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitInConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InConstraintContext inConstraint() throws RecognitionException {
		InConstraintContext _localctx = new InConstraintContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_inConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			match(IN);
			setState(278);
			match(L_PAREN);
			setState(279);
			inValue();
			setState(282); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(280);
				match(COMA);
				setState(281);
				inValue();
				}
				}
				setState(284); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==COMA );
			setState(286);
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
		public TerminalNode DATE() { return getToken(DataDictionaryParser.DATE, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public TerminalNode REAL() { return getToken(DataDictionaryParser.REAL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public InValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterInValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitInValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitInValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InValueContext inValue() throws RecognitionException {
		InValueContext _localctx = new InValueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_inValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
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
		public TerminalNode LIKE() { return getToken(DataDictionaryParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public LikeConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterLikeConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitLikeConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitLikeConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LikeConstraintContext likeConstraint() throws RecognitionException {
		LikeConstraintContext _localctx = new LikeConstraintContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_likeConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(LIKE);
			setState(291);
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
		public TerminalNode BETWEEN() { return getToken(DataDictionaryParser.BETWEEN, 0); }
		public TerminalNode L_PAREN() { return getToken(DataDictionaryParser.L_PAREN, 0); }
		public List<BetweenValueContext> betweenValue() {
			return getRuleContexts(BetweenValueContext.class);
		}
		public BetweenValueContext betweenValue(int i) {
			return getRuleContext(BetweenValueContext.class,i);
		}
		public TerminalNode COMA() { return getToken(DataDictionaryParser.COMA, 0); }
		public TerminalNode R_PAREN() { return getToken(DataDictionaryParser.R_PAREN, 0); }
		public BetweenConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterBetweenConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitBetweenConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitBetweenConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenConstraintContext betweenConstraint() throws RecognitionException {
		BetweenConstraintContext _localctx = new BetweenConstraintContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_betweenConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(BETWEEN);
			setState(294);
			match(L_PAREN);
			setState(295);
			betweenValue();
			setState(296);
			match(COMA);
			setState(297);
			betweenValue();
			setState(298);
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
		public TerminalNode DATE() { return getToken(DataDictionaryParser.DATE, 0); }
		public TerminalNode REAL() { return getToken(DataDictionaryParser.REAL, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public BetweenValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_betweenValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterBetweenValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitBetweenValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitBetweenValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BetweenValueContext betweenValue() throws RecognitionException {
		BetweenValueContext _localctx = new BetweenValueContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_betweenValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
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
		public TerminalNode EQ() { return getToken(DataDictionaryParser.EQ, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public ArithmeticConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterArithmeticConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitArithmeticConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitArithmeticConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticConstraintContext arithmeticConstraint() throws RecognitionException {
		ArithmeticConstraintContext _localctx = new ArithmeticConstraintContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_arithmeticConstraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(EQ);
			setState(303);
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
		public List<TerminalNode> PLUS() { return getTokens(DataDictionaryParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(DataDictionaryParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(DataDictionaryParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(DataDictionaryParser.MINUS, i);
		}
		public ArithmeticExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithmeticExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitArithmeticExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitArithmeticExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArithmeticExpressionContext arithmeticExpression() throws RecognitionException {
		ArithmeticExpressionContext _localctx = new ArithmeticExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_arithmeticExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			term();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				{
				setState(306);
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
				setState(307);
				term();
				}
				}
				setState(312);
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
		public List<TerminalNode> ASTERISK() { return getTokens(DataDictionaryParser.ASTERISK); }
		public TerminalNode ASTERISK(int i) {
			return getToken(DataDictionaryParser.ASTERISK, i);
		}
		public List<TerminalNode> SLASH() { return getTokens(DataDictionaryParser.SLASH); }
		public TerminalNode SLASH(int i) {
			return getToken(DataDictionaryParser.SLASH, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			atom();
			setState(318);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ASTERISK || _la==SLASH) {
				{
				{
				setState(314);
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
				setState(315);
				atom();
				}
				}
				setState(320);
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
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public TerminalNode INT() { return getToken(DataDictionaryParser.INT, 0); }
		public TerminalNode REAL() { return getToken(DataDictionaryParser.REAL, 0); }
		public AggregateFunctionContext aggregateFunction() {
			return getRuleContext(AggregateFunctionContext.class,0);
		}
		public TerminalNode L_PAREN() { return getToken(DataDictionaryParser.L_PAREN, 0); }
		public ArithmeticExpressionContext arithmeticExpression() {
			return getRuleContext(ArithmeticExpressionContext.class,0);
		}
		public TerminalNode R_PAREN() { return getToken(DataDictionaryParser.R_PAREN, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_atom);
		try {
			setState(329);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(321);
				match(STRING);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				match(INT);
				}
				break;
			case REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(323);
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
				setState(324);
				aggregateFunction();
				}
				break;
			case L_PAREN:
				enterOuterAlt(_localctx, 5);
				{
				setState(325);
				match(L_PAREN);
				setState(326);
				arithmeticExpression();
				setState(327);
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
		public TerminalNode L_PAREN() { return getToken(DataDictionaryParser.L_PAREN, 0); }
		public TerminalNode STRING() { return getToken(DataDictionaryParser.STRING, 0); }
		public TerminalNode R_PAREN() { return getToken(DataDictionaryParser.R_PAREN, 0); }
		public TerminalNode SUM() { return getToken(DataDictionaryParser.SUM, 0); }
		public TerminalNode AVG() { return getToken(DataDictionaryParser.AVG, 0); }
		public TerminalNode COUNT() { return getToken(DataDictionaryParser.COUNT, 0); }
		public TerminalNode MIN() { return getToken(DataDictionaryParser.MIN, 0); }
		public TerminalNode MAX() { return getToken(DataDictionaryParser.MAX, 0); }
		public AggregateFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aggregateFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).enterAggregateFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DataDictionaryParserListener ) ((DataDictionaryParserListener)listener).exitAggregateFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DataDictionaryParserVisitor ) return ((DataDictionaryParserVisitor<? extends T>)visitor).visitAggregateFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AggregateFunctionContext aggregateFunction() throws RecognitionException {
		AggregateFunctionContext _localctx = new AggregateFunctionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_aggregateFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 545357767376896L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(332);
			match(L_PAREN);
			setState(333);
			match(STRING);
			setState(334);
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
		"\u0004\u0001?\u0151\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001W\b\u0001\n\u0001"+
		"\f\u0001Z\t\u0001\u0001\u0001\u0005\u0001]\b\u0001\n\u0001\f\u0001`\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0004\u0001d\b\u0001\u000b\u0001\f\u0001"+
		"e\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003}\b\u0003\u0001\u0003"+
		"\u0003\u0003\u0080\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0004\u0004\u0086\b\u0004\u000b\u0004\f\u0004\u0087\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u0090"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0094\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0004\u0006\u0099\b\u0006\u000b\u0006\f\u0006"+
		"\u009a\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u00a0\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0004\b\u00a5\b\b\u000b\b\f\b\u00a6\u0001\b\u0001\b"+
		"\u0001\t\u0001\t\u0004\t\u00ad\b\t\u000b\t\f\t\u00ae\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0003\n\u00b5\b\n\u0001\u000b\u0001\u000b\u0004\u000b\u00b9"+
		"\b\u000b\u000b\u000b\f\u000b\u00ba\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0004\f\u00c2\b\f\u000b\f\f\f\u00c3\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00cf\b\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d7\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0003\u000f\u00e0\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e4\b"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00e8\b\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00ec\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00f0"+
		"\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003"+
		"\u0013\u00fd\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u0102"+
		"\b\u0014\n\u0014\f\u0014\u0105\t\u0014\u0001\u0015\u0003\u0015\u0108\b"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0110\b\u0016\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0004"+
		"\u0019\u011b\b\u0019\u000b\u0019\f\u0019\u011c\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f"+
		"\u0001\u001f\u0001\u001f\u0005\u001f\u0135\b\u001f\n\u001f\f\u001f\u0138"+
		"\t\u001f\u0001 \u0001 \u0001 \u0005 \u013d\b \n \f \u0140\t \u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u014a\b!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001\"\u0001\"\u0000\u0000#\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BD\u0000\n\u0002\u0000\u0017\u0017;>\u0002\u0000\u0018\u0018"+
		"<<\u0001\u0000#$\u0002\u0000&(;;\u0001\u000016\u0001\u0000;>\u0002\u0000"+
		";;=>\u0001\u000078\u0001\u00009:\u0001\u0000,0\u0153\u0000F\u0001\u0000"+
		"\u0000\u0000\u0002I\u0001\u0000\u0000\u0000\u0004i\u0001\u0000\u0000\u0000"+
		"\u0006s\u0001\u0000\u0000\u0000\b\u0081\u0001\u0000\u0000\u0000\n\u008b"+
		"\u0001\u0000\u0000\u0000\f\u008f\u0001\u0000\u0000\u0000\u000e\u009f\u0001"+
		"\u0000\u0000\u0000\u0010\u00a1\u0001\u0000\u0000\u0000\u0012\u00aa\u0001"+
		"\u0000\u0000\u0000\u0014\u00b4\u0001\u0000\u0000\u0000\u0016\u00b6\u0001"+
		"\u0000\u0000\u0000\u0018\u00be\u0001\u0000\u0000\u0000\u001a\u00c7\u0001"+
		"\u0000\u0000\u0000\u001c\u00d8\u0001\u0000\u0000\u0000\u001e\u00db\u0001"+
		"\u0000\u0000\u0000 \u00f1\u0001\u0000\u0000\u0000\"\u00f3\u0001\u0000"+
		"\u0000\u0000$\u00f5\u0001\u0000\u0000\u0000&\u00fc\u0001\u0000\u0000\u0000"+
		"(\u00fe\u0001\u0000\u0000\u0000*\u0107\u0001\u0000\u0000\u0000,\u010f"+
		"\u0001\u0000\u0000\u0000.\u0111\u0001\u0000\u0000\u00000\u0113\u0001\u0000"+
		"\u0000\u00002\u0115\u0001\u0000\u0000\u00004\u0120\u0001\u0000\u0000\u0000"+
		"6\u0122\u0001\u0000\u0000\u00008\u0125\u0001\u0000\u0000\u0000:\u012c"+
		"\u0001\u0000\u0000\u0000<\u012e\u0001\u0000\u0000\u0000>\u0131\u0001\u0000"+
		"\u0000\u0000@\u0139\u0001\u0000\u0000\u0000B\u0149\u0001\u0000\u0000\u0000"+
		"D\u014b\u0001\u0000\u0000\u0000FG\u0003\u0002\u0001\u0000GH\u0005\u0000"+
		"\u0000\u0001H\u0001\u0001\u0000\u0000\u0000IJ\u0005\u0001\u0000\u0000"+
		"JK\u0005\u0002\u0000\u0000KL\u0005>\u0000\u0000LM\u0005\u0003\u0000\u0000"+
		"MN\u0005<\u0000\u0000NO\u0005\u0004\u0000\u0000OP\u0005<\u0000\u0000P"+
		"Q\u0005\u0005\u0000\u0000QR\u0005<\u0000\u0000RS\u0005\u0006\u0000\u0000"+
		"ST\u0005;\u0000\u0000TX\u0005\u001b\u0000\u0000UW\u0003\u0004\u0002\u0000"+
		"VU\u0001\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000"+
		"\u0000XY\u0001\u0000\u0000\u0000Y^\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000[]\u0003\u0006\u0003\u0000\\[\u0001\u0000\u0000\u0000]`\u0001"+
		"\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000"+
		"_a\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ac\u0005\u0007\u0000"+
		"\u0000bd\u0003\f\u0006\u0000cb\u0001\u0000\u0000\u0000de\u0001\u0000\u0000"+
		"\u0000ec\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000fg\u0001\u0000"+
		"\u0000\u0000gh\u0005\u001c\u0000\u0000h\u0003\u0001\u0000\u0000\u0000"+
		"ij\u0005\b\u0000\u0000jk\u0005\u0002\u0000\u0000kl\u0005>\u0000\u0000"+
		"lm\u0005\u0003\u0000\u0000mn\u0005<\u0000\u0000no\u0005\n\u0000\u0000"+
		"op\u0003&\u0013\u0000pq\u0005\u000b\u0000\u0000qr\u0005\u0017\u0000\u0000"+
		"r\u0005\u0001\u0000\u0000\u0000st\u0005\t\u0000\u0000tu\u0005\u0002\u0000"+
		"\u0000uv\u0005>\u0000\u0000vw\u0005\u0003\u0000\u0000wx\u0005<\u0000\u0000"+
		"xy\u0005\f\u0000\u0000y|\u0003 \u0010\u0000z{\u0005\r\u0000\u0000{}\u0003"+
		"&\u0013\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f"+
		"\u0001\u0000\u0000\u0000~\u0080\u0003\b\u0004\u0000\u007f~\u0001\u0000"+
		"\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0007\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005\u000e\u0000\u0000\u0082\u0083\u0005\u0019"+
		"\u0000\u0000\u0083\u0085\u0003\n\u0005\u0000\u0084\u0086\u0003\n\u0005"+
		"\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001\u0000\u0000"+
		"\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089\u008a\u0005\u001a\u0000"+
		"\u0000\u008a\t\u0001\u0000\u0000\u0000\u008b\u008c\u0007\u0000\u0000\u0000"+
		"\u008c\u000b\u0001\u0000\u0000\u0000\u008d\u008e\u0005\u0002\u0000\u0000"+
		"\u008e\u0090\u0005>\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u008f"+
		"\u0090\u0001\u0000\u0000\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091"+
		"\u0092\u0005\u0003\u0000\u0000\u0092\u0094\u0005<\u0000\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0005\u000f\u0000\u0000\u0096\u0098"+
		"\u0005\u0015\u0000\u0000\u0097\u0099\u0003\u000e\u0007\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a\u0098"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\r\u0001"+
		"\u0000\u0000\u0000\u009c\u00a0\u0003\u0010\b\u0000\u009d\u00a0\u0003\u0012"+
		"\t\u0000\u009e\u00a0\u0003\u0014\n\u0000\u009f\u009c\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u009e\u0001\u0000\u0000"+
		"\u0000\u00a0\u000f\u0001\u0000\u0000\u0000\u00a1\u00a2\u00056\u0000\u0000"+
		"\u00a2\u00a4\u0003\u001a\r\u0000\u00a3\u00a5\u0003\u001a\r\u0000\u00a4"+
		"\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000\u00a6"+
		"\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u00055\u0000\u0000\u00a9\u0011"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ac\u0005\u001b\u0000\u0000\u00ab\u00ad"+
		"\u0003\u001a\r\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad\u00ae\u0001"+
		"\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000\u0000\u00ae\u00af\u0001"+
		"\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005"+
		"\u001c\u0000\u0000\u00b1\u0013\u0001\u0000\u0000\u0000\u00b2\u00b5\u0003"+
		"\u0016\u000b\u0000\u00b3\u00b5\u0003\u0018\f\u0000\u00b4\u00b2\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u0015\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b8\u0005\u001d\u0000\u0000\u00b7\u00b9\u0003\u001a"+
		"\r\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000"+
		"\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000"+
		"\u0000\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\u001e\u0000"+
		"\u0000\u00bd\u0017\u0001\u0000\u0000\u0000\u00be\u00bf\u0005:\u0000\u0000"+
		"\u00bf\u00c1\u0003\u001a\r\u0000\u00c0\u00c2\u0003\u001a\r\u0000\u00c1"+
		"\u00c0\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c4\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c5\u00c6\u0005:\u0000\u0000\u00c6\u0019"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c8\u0005\u0002\u0000\u0000\u00c8\u00c9"+
		"\u0005>\u0000\u0000\u00c9\u00ca\u0005\u0003\u0000\u0000\u00ca\u00d6\u0005"+
		"<\u0000\u0000\u00cb\u00ce\u0005!\u0000\u0000\u00cc\u00cf\u0003\f\u0006"+
		"\u0000\u00cd\u00cf\u0003\u001c\u000e\u0000\u00ce\u00cc\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0005!\u0000\u0000\u00d1\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d2\u00d3\u0005\"\u0000\u0000\u00d3\u00d4\u0003\u001e\u000f\u0000\u00d4"+
		"\u00d5\u0005\"\u0000\u0000\u00d5\u00d7\u0001\u0000\u0000\u0000\u00d6\u00cb"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d2\u0001\u0000\u0000\u0000\u00d7\u001b"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0005\u0003\u0000\u0000\u00d9\u00da"+
		"\u0005<\u0000\u0000\u00da\u001d\u0001\u0000\u0000\u0000\u00db\u00dc\u0005"+
		"\u0010\u0000\u0000\u00dc\u00df\u0003 \u0010\u0000\u00dd\u00de\u0005\u0011"+
		"\u0000\u0000\u00de\u00e0\u0003\"\u0011\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0005\u0012\u0000\u0000\u00e2\u00e4\u0005\u0016\u0000"+
		"\u0000\u00e3\u00e1\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000"+
		"\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005\r\u0000\u0000"+
		"\u00e6\u00e8\u0003&\u0013\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e8\u00eb\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ea\u0005\u0013\u0000\u0000\u00ea\u00ec\u0003\n\u0005\u0000\u00eb\u00e9"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ef"+
		"\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005\u0014\u0000\u0000\u00ee\u00f0"+
		"\u0003$\u0012\u0000\u00ef\u00ed\u0001\u0000\u0000\u0000\u00ef\u00f0\u0001"+
		"\u0000\u0000\u0000\u00f0\u001f\u0001\u0000\u0000\u0000\u00f1\u00f2\u0007"+
		"\u0001\u0000\u0000\u00f2!\u0001\u0000\u0000\u0000\u00f3\u00f4\u0005<\u0000"+
		"\u0000\u00f4#\u0001\u0000\u0000\u0000\u00f5\u00f6\u0005<\u0000\u0000\u00f6"+
		"%\u0001\u0000\u0000\u0000\u00f7\u00fd\u0003(\u0014\u0000\u00f8\u00fd\u0003"+
		"2\u0019\u0000\u00f9\u00fd\u00036\u001b\u0000\u00fa\u00fd\u00038\u001c"+
		"\u0000\u00fb\u00fd\u0003<\u001e\u0000\u00fc\u00f7\u0001\u0000\u0000\u0000"+
		"\u00fc\u00f8\u0001\u0000\u0000\u0000\u00fc\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000"+
		"\u00fd\'\u0001\u0000\u0000\u0000\u00fe\u0103\u0003*\u0015\u0000\u00ff"+
		"\u0100\u0007\u0002\u0000\u0000\u0100\u0102\u0003*\u0015\u0000\u0101\u00ff"+
		"\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000\u0000\u0000\u0103\u0101"+
		"\u0001\u0000\u0000\u0000\u0103\u0104\u0001\u0000\u0000\u0000\u0104)\u0001"+
		"\u0000\u0000\u0000\u0105\u0103\u0001\u0000\u0000\u0000\u0106\u0108\u0005"+
		"%\u0000\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0107\u0108\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010a\u00030\u0018"+
		"\u0000\u010a\u010b\u0003,\u0016\u0000\u010b+\u0001\u0000\u0000\u0000\u010c"+
		"\u0110\u0003.\u0017\u0000\u010d\u0110\u0005=\u0000\u0000\u010e\u0110\u0005"+
		">\u0000\u0000\u010f\u010c\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000"+
		"\u0000\u0000\u010f\u010e\u0001\u0000\u0000\u0000\u0110-\u0001\u0000\u0000"+
		"\u0000\u0111\u0112\u0007\u0003\u0000\u0000\u0112/\u0001\u0000\u0000\u0000"+
		"\u0113\u0114\u0007\u0004\u0000\u0000\u01141\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0005)\u0000\u0000\u0116\u0117\u0005\u0019\u0000\u0000\u0117\u011a"+
		"\u00034\u001a\u0000\u0118\u0119\u0005\u001f\u0000\u0000\u0119\u011b\u0003"+
		"4\u001a\u0000\u011a\u0118\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000"+
		"\u0000\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u001a"+
		"\u0000\u0000\u011f3\u0001\u0000\u0000\u0000\u0120\u0121\u0007\u0005\u0000"+
		"\u0000\u01215\u0001\u0000\u0000\u0000\u0122\u0123\u0005*\u0000\u0000\u0123"+
		"\u0124\u0005<\u0000\u0000\u01247\u0001\u0000\u0000\u0000\u0125\u0126\u0005"+
		"+\u0000\u0000\u0126\u0127\u0005\u0019\u0000\u0000\u0127\u0128\u0003:\u001d"+
		"\u0000\u0128\u0129\u0005\u001f\u0000\u0000\u0129\u012a\u0003:\u001d\u0000"+
		"\u012a\u012b\u0005\u001a\u0000\u0000\u012b9\u0001\u0000\u0000\u0000\u012c"+
		"\u012d\u0007\u0006\u0000\u0000\u012d;\u0001\u0000\u0000\u0000\u012e\u012f"+
		"\u00054\u0000\u0000\u012f\u0130\u0003>\u001f\u0000\u0130=\u0001\u0000"+
		"\u0000\u0000\u0131\u0136\u0003@ \u0000\u0132\u0133\u0007\u0007\u0000\u0000"+
		"\u0133\u0135\u0003@ \u0000\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u0138"+
		"\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0001\u0000\u0000\u0000\u0137?\u0001\u0000\u0000\u0000\u0138\u0136\u0001"+
		"\u0000\u0000\u0000\u0139\u013e\u0003B!\u0000\u013a\u013b\u0007\b\u0000"+
		"\u0000\u013b\u013d\u0003B!\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d"+
		"\u0140\u0001\u0000\u0000\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013e"+
		"\u013f\u0001\u0000\u0000\u0000\u013fA\u0001\u0000\u0000\u0000\u0140\u013e"+
		"\u0001\u0000\u0000\u0000\u0141\u014a\u0005<\u0000\u0000\u0142\u014a\u0005"+
		">\u0000\u0000\u0143\u014a\u0005=\u0000\u0000\u0144\u014a\u0003D\"\u0000"+
		"\u0145\u0146\u0005\u0019\u0000\u0000\u0146\u0147\u0003>\u001f\u0000\u0147"+
		"\u0148\u0005\u001a\u0000\u0000\u0148\u014a\u0001\u0000\u0000\u0000\u0149"+
		"\u0141\u0001\u0000\u0000\u0000\u0149\u0142\u0001\u0000\u0000\u0000\u0149"+
		"\u0143\u0001\u0000\u0000\u0000\u0149\u0144\u0001\u0000\u0000\u0000\u0149"+
		"\u0145\u0001\u0000\u0000\u0000\u014aC\u0001\u0000\u0000\u0000\u014b\u014c"+
		"\u0007\t\u0000\u0000\u014c\u014d\u0005\u0019\u0000\u0000\u014d\u014e\u0005"+
		"<\u0000\u0000\u014e\u014f\u0005\u001a\u0000\u0000\u014fE\u0001\u0000\u0000"+
		"\u0000\u001eX^e|\u007f\u0087\u008f\u0093\u009a\u009f\u00a6\u00ae\u00b4"+
		"\u00ba\u00c3\u00ce\u00d6\u00df\u00e3\u00e7\u00eb\u00ef\u00fc\u0103\u0107"+
		"\u010f\u011c\u0136\u013e\u0149";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}