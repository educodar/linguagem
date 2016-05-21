grammar Grammar;

program
    : PROGRAM_KW CURLY_BRACKET_L route CURLY_BRACKET_R;

route
    : FOR_KW STRING DO_KW CURLY_BRACKET_L CURLY_BRACKET_R;

CURLY_BRACKET_L : '{';
CURLY_BRACKET_R : '}';

PROGRAM_KW : 'programa';
FOR_KW : 'para';
DO_KW : 'faça';

STRING : '\'Batata\'';
