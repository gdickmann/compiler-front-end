package front_end.lexeme;

import front_end.token.Token;

public class Lexeme {

    public Lexeme(Token type, String content) {
        this.type = type;
        this.content = content;
    }

    private Token type;
    private String content;

    public Token getType() {
        return type;
    }

    public void setType(Token type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
