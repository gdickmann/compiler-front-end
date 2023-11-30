package front_end.lexical.table;

import front_end.token.Type;

public class Token {

    public Token(Type type, String content) {
        this.type = type;
        this.content = content;
    }

    private Type type;
    private String content;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
