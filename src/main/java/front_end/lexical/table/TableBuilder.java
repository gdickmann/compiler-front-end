package front_end.lexical.table;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import front_end.token.SupportedTypes;
import front_end.token.Type;

public class TableBuilder {

    /**
     * Dado uma lista de tokens, constrói a tabela de valores com cada token suportado em {@link SupportedTypes}.
     * @return Uma tabela com cada token suportado.
     */
    public static List<Token> build(List<String> tokens) {
        List<Token> response = new ArrayList<Token>();

        Pattern k = Pattern.compile(SupportedTypes.keywords);
        Pattern o = Pattern.compile(SupportedTypes.operator);
        Pattern c = Pattern.compile(SupportedTypes.comment);
        Pattern s = Pattern.compile(SupportedTypes.separator);

        Pattern op = Pattern.compile(SupportedTypes.openParenthesis);
        Pattern cp = Pattern.compile(SupportedTypes.closedParenthesis);

        Pattern ob = Pattern.compile(SupportedTypes.openBrackets);
        Pattern cb = Pattern.compile(SupportedTypes.closedBrackets);
        
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
            if (s.matcher(token).matches()) {
                response.add(new Token(Type.SEPARATOR, token));
                continue;
            }
            if (op.matcher(token).matches()) {
                response.add(new Token(Type.OPEN_PARENTHESIS, token));
                continue;
            }
            if (cp.matcher(token).matches()) {
                response.add(new Token(Type.CLOSED_PARENTHESIS, token));
                continue;
            }
            if (ob.matcher(token).matches()) {
                response.add(new Token(Type.OPEN_BRACKETS, token));
                continue;
            }
            if (cb.matcher(token).matches()) {
                response.add(new Token(Type.CLOSED_BRACKETS, token));
                continue;
            }
            response.add(new Token(Type.LITERAL, token));
        }
        return response;
    }
}
