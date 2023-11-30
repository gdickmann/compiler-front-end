package front_end.syntatic.parser;

import front_end.token.Type;

public class GrammaticalTable {
    /*
        declaration ::= keyword literal operator literal ';'
        keyword ::= 'String' | 'int' | 'boolean' | 'double'
        literal ::= [a-zA-Z0-9]* '"' | [0-9]+ | 'true' | 'false'
        operator ::= '='
    */
    // Cada índice corresponde a sequência permitida.
    public static Type[] declaration = new Type[] { Type.KEYWORD, Type.LITERAL, Type.OPERATOR, Type.LITERAL, Type.SEPARATOR };
}
