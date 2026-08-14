parser grammar ConstraintParser;

options { tokenVocab=DataDictionaryLexer; }

constraint:				valueConstraint
						|	inConstraint
						|	likeConstraint
						|	betweenConstraint
						|	arithmeticConstraint									;

valueConstraint:		expression ((AND|OR) expression)*							;
expression:				(NOT)? operator comparableValue								;
comparableValue:		(dateValue | REAL | INT)									;
dateValue: 				DATE | CURRENT_DATE | TODAY | NOW	 						;		
operator:				GE | LE | NEQ | EQ | GT | LT								;

inConstraint:			IN L_PAREN inValue (COMA inValue)+ R_PAREN					;
inValue:				DATE | STRING | REAL | INT 									; // ili da ide dateValue pa da moze da bude i today npr.

likeConstraint:			LIKE STRING													; // ovo mislim da je bolje kroz semantiku

betweenConstraint:		BETWEEN L_PAREN betweenValue COMA betweenValue R_PAREN		;
betweenValue:			DATE | REAL | INT 											; // ili da ide dateValue pa da moze da bude i today npr.

arithmeticConstraint:	EQ arithmeticExpression 									;
arithmeticExpression:	term (op+=(PLUS|MINUS) term)*								;
term:					atom (op+=(ASTERISK|SLASH) atom)*							;
atom:					STRING 					// ovo je naziv komponente, ali samo ako je polje u pitanju, 												//to bi se proveravalo kroz semantiku
						| INT
						| REAL
						| aggregateFunction
						| L_PAREN arithmeticExpression R_PAREN						;
aggregateFunction:		(SUM | AVG | COUNT | MIN | MAX) L_PAREN STRING R_PAREN		; // ovo je naziv komponente, ali samo ako je polje u pitanju, 												
	// to bi se proveravalo kroz semantiku, za sada ne gledamo slucajeve slozenije od ovog

// 9-ka koja predstavlja cifru u cobol-u moze da pravi konflikt sa int, tako da mozda bolje format da ostane string
// pa da gledamo kroz semantiku
//formatConstraint:	regex | cobol								;
//regex:			STRING									; // ovo cemo kroz semantiku
//cobol:			ccPart+									;
//ccPart:			COBOL_SYMBOL (L_PAREN INT R_PAREN)?
//					| separator								;
//separator:		FULLSTOP | MINUS | SLASH | COLON | UNDERSCORE				;



