grammar Imp;

//Sintaxe == Gramática Livre de Contextos

start : dec* com* EOF ; 

// Declarações
dec : TYPE VAR '=' expr ';' ;

// Comandos
com : VAR '=' expr ';' #Atrib 
 	| VAR '++' ';' #Inc 
 	| 'for' VAR 'in' NUM '..' NUM 'do' '{' com* '}' #For 
	;

// Expressões
expr : expr OP2 expr  #Op
  | expr OP1 expr  #Op
  | expr COMP expr #Op
  | expr LOGICO expr #Op
  | FALSE          #CFalse 
  | TRUE			  #CTrue
  | NUM            #Const 
  | STRING         #CString
  | VAR            #Var
  | APAR expr FPAR #Group 
  | '"Elvis"' ':' VAR '?' #Elvis
	 ;


//Lexica

ATRIB : '=' ;
PV : ';' ;
ESCREVA : 'escreva' ; 
TYPE : 'int' | 'bool' | 'string' ;
TRUE : 'true'; 
FALSE : 'false';
VAR : [a-z]+ ;
NUM : '-'?[0-9]+ ;
STRING : '"' (~["] | '\\"')* '"' ;
OP1 : '+' | '-' ;
OP2 : '*' | '/' ;
COMP : '<' | '>' | '==' | '!=' ; 
LOGICO : '&&' | '||' ; 
APAR : '(' ;
FPAR : ')' ;
SPACES : (' '  | '\n' | '\t' | '\r') -> skip;

