parser grammar DataDictionaryParser;

options { tokenVocab=DataDictionaryLexer; }

import ConstraintParser;

program: 						dataDictionary EOF											;

dataDictionary: 				DD_LABEL
								ID_LABEL INT
								NAME_LABEL STRING
								AUTHOR_LABEL STRING 
    							VERSION_LABEL STRING 
   								DATE_OF_CREATION_LABEL DATE
    							L_CURLY
     							   	logicalFunctionDecl*
     		 					  	semanticDomainDecl*
									STRUCTURES_LABEL
     							   	structureDecl+
   								R_CURLY 													;

logicalFunctionDecl:			LF_LABEL
								ID_LABEL INT
								NAME_LABEL STRING
								DEFINITION_LABEL constraint
								RESULT_LABEL BOOLEAN										;
									
semanticDomainDecl: 			SD_LABEL
								ID_LABEL INT
								NAME_LABEL STRING
								BASE_LABEL domainReference
								(CONSTRAINT_LABEL constraint)?
								(enumeratedDomainDecl)?										;

enumeratedDomainDecl:			VALUES_LABEL
								L_PAREN
									value value+
								R_PAREN														;

value:							STRING | REAL | INT | DATE | BOOLEAN						;

structureDecl:					ID_LABEL INT
								NAME_LABEL STRING
								TYPE_LABEL STRUCTURE_TYPE
								constructionDecl+											;

constructionDecl:				aggregationDecl | setDecl | specializationDecl				;

aggregationDecl:				LT 
									componentDecl componentDecl+
								GT	 														;

setDecl:						L_CURLY 
									componentDecl+
								R_CURLY														;

specializationDecl:				exclusiveSpecializationDecl | inclusiveSpecializationDecl	;

exclusiveSpecializationDecl:	L_SQUARE 
									componentDecl+
								R_SQUARE													;

inclusiveSpecializationDecl:	SLASH 	
									componentDecl componentDecl+					
								SLASH														;

componentDecl:					ID_LABEL INT
								NAME_LABEL STRING
								(HASH structureDecl HASH | AMPERSAND fieldDecl AMPERSAND)	;

fieldDecl:						DOMAIN_LABEL domainReference				
								(FORMAT_LABEL STRING)?		//formatConstraint - ovo je regex ili cobol, ali to cemo kroz semantiku, tako da ostaje string
								(NULLABILITY_LABEL NULL_CONSTRAINT)?
								(CONSTRAINT_LABEL constraint)?
								(DEFAULT_LABEL value)?
								(NOTE_LABEL STRING)?										;

domainReference:				BASE_DOMAIN | STRING										;
