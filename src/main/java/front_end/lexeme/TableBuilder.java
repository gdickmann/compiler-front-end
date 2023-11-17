package front_end.lexeme;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import front_end.token.SupportedTokens;
import front_end.token.Token;

public class TableBuilder {

    /**
     * Dado uma lista de tokens, constroi a tabela de valores com cada token suportado em {@link SupportedTokens}.
     * @return Uma tabela com cada token suportado.
     */
    public static List<Lexeme> build(List<String> tokens) {
        List<Lexeme> response = new ArrayList<Lexeme>();

        Pattern s = Pattern.compile(SupportedTokens.separators);
        Pattern k = Pattern.compile(SupportedTokens.keywords);
        Pattern o = Pattern.compile(SupportedTokens.operators);
        Pattern c = Pattern.compile(SupportedTokens.comment);
        
        for (String token : tokens) {
            if (s.matcher(token).matches()) {
                response.add(new Lexeme(Token.SEPARATOR, token));
                continue;
            }
            if (k.matcher(token).matches()) {
                response.add(new Lexeme(Token.KEYWORD, token));
                continue;
            }
            if (o.matcher(token).matches()) {
                response.add(new Lexeme(Token.OPERATOR, token));
                continue;
            }
            if (c.matcher(token).matches()) {
                response.add(new Lexeme(Token.COMMENT, token));
                continue;
            }
            response.add(new Lexeme(Token.LITERAL, token));
        }
        return response;
    }
}
