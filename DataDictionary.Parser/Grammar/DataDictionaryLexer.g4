lexer grammar DataDictionaryLexer;
	
DD_LABEL:					'DATA DICTIONARY'									;
ID_LABEL:					'id:'												;
NAME_LABEL:					'name:'												;
AUTHOR_LABEL:				'author:'											; 
VERSION_LABEL:				'version:'											;
DATE_OF_CREATION_LABEL:		'date of creation:'									;
STRUCTURES_LABEL:			'STRUCTURES'										;
LF_LABEL:					'LOGICAL FUNCTION'									;
SD_LABEL:					'SEMANTIC DOMAIN'									;
DEFINITION_LABEL:			'definition:'										;
RESULT_LABEL:				'result:'											;
BASE_LABEL:					'base:'												;
CONSTRAINT_LABEL:			'constraint:'										;
VALUES_LABEL:				'values:'											;
TYPE_LABEL:					'type:'												;
DOMAIN_LABEL:				'domain:'											;
FORMAT_LABEL:				'format:'											;
NULLABILITY_LABEL:			'nullability:'										;
DEFAULT_LABEL:				'default:'											;
NOTE_LABEL:					'note:'												;


STRUCTURE_TYPE:				'dataFlow' | 'dataStore'							;
NULL_CONSTRAINT:			'not null' | 'null'									;
BOOLEAN:					'true' | 'false'									;
BASE_DOMAIN:				'String' | 'Integer' | 'Real' | 'Boolean' | 'Date'	;

L_PAREN:					'('													;
R_PAREN:					')'													;
L_CURLY:					'{'													;
R_CURLY:					'}'													;
L_SQUARE:					'['													;
R_SQUARE:					']'													;
COMA:						','													;
FULLSTOP:					'.'													;
HASH:						'#'													;
AMPERSAND:					'&'													;

AND:						'AND'												;
OR:							'OR'												;
NOT:						'NOT'												;
CURRENT_DATE:				'current_date'										;
TODAY:						'today'												;
NOW:						'now'												;

IN:							'IN'												;
LIKE:						'LIKE'												;
BETWEEN:					'BETWEEN'											;
SUM:						'SUM'												;
AVG:						'AVG'												;
COUNT:						'COUNT'												;
MIN:						'MIN'												;
MAX:						'MAX'												;
GE:							'>='												;
LE:							'<='												;
NEQ:						'!='												;
EQ:							'='													;
GT:							'>'													;
LT:							'<'													;
PLUS:						'+'													;
MINUS:						'-'													;
ASTERISK:					'*'													;
SLASH:						'/'													;

//COBOL_SYMBOL:				'9' | 'A' | 'X'			; //ova 9-ka moze da pravi konflikt sa int tokenom...mozda bolje da 
														// ogr. za format bude string
//COLON:					':'							;
//UNDERSCORE:				'_'							;

DATE:						DAY '.' MONTH '.' YEAR '.'							;
fragment DAY:				'0'[1-9] | [12][0-9] | '3'[01]						;
fragment MONTH:				'0'[1-9] | '1'[012]									;
fragment YEAR:				'19'[0-9][0-9] | '20'[0-9][0-9]						;

STRING:						'"' ( ~["\\\r\n] | ESC )* '"'						; //dozvoljeno pod navodnicima sve osim ", \ i novog reda
fragment ESC:				'\\' ["\\/bfnrt]									; //dozvoljava \", \\, \/, \b, \f, \n, \r, \t //b je backspace, f je form feed
REAL:						[0-9]+ '.' [0-9]+ 									;
INT:						[0-9]+												;

WHITESPACE:					[ \t\n\r] -> skip									;	

