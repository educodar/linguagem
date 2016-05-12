grammar Grammar;

program
    : PROGRAM_KW CURLY_BRACKET_L CURLY_BRACKET_R;

CURLY_BRACKET_L : '{';
CURLY_BRACKET_R : '}';

PROGRAM_KW : 'programa';

