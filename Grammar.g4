grammar Grammar;

prog: expr EOF;

expr: expr op=('/'|'*') expr #operacionBinaria
    | expr op=('+'|'-') expr #operacionBinaria
    | Num          #numero
    ;

Num: [0-9]+;