package front_end.lexical.table;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import front_end.lexical.token.SupportedTypes;
import front_end.lexical.token.Type;

public class TableBuilder {

    /**
     * Dado uma lista de tokens, constrói a tabela de valores com cada token suportado em {@link SupportedTypes}.
     * @return Uma tabela com cada token suportado.
     */
    public static List<Token> build(List<String> tokens) {
        List<Token> response = new ArrayList<Token>();

        Pattern k = Pattern.compile(SupportedTypes.keywords);
        Pattern o = Pattern.compile(SupportedTypes.operators);
        Pattern c = Pattern.compile(SupportedTypes.comment);
        
        for (String token : tokens) {
            if (k.matcher(token).matches()) {
                response.add(new Token(Type.KEYWORD, token));
                continue;
            }
            if (o.matcher(token).matches()) {
                response.add(new Token(Type.OPERATOR, token));
                continue;
            }
            if (c.matcher(token).matches()) {
                response.add(new Token(Type.COMMENT, token));
                continue;
            }
            response.add(new Token(Type.LITERAL, token));
        }
        return response;
    }
}
