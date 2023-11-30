package front_end.semantic.parser;

import java.util.List;

import front_end.lexical.table.Token;
import front_end.token.Type;

public class Semantic {

    public static void parse(List<Token> table) {
        throwExceptionIfTypeMismatched(table);
    }

    private static void throwExceptionIfTypeMismatched(List<Token> table) {
        Object content = table.get(table.size() - 2).getContent();

        for (Token token : table) {
            if (token.getType().equals(Type.KEYWORD)) {
                switch (token.getContent()) {
                    case "int":
                        try {
                            Integer.parseInt(content.toString());
                        } catch (Exception e) {
                            System.out.println("Não é possível converter o tipo " + token.getContent() + " em " + content);
                            throw e;
                        }
                    break;
                    case "String":
                        try {
                            String.valueOf(content);
                        } catch (Exception e) {
                            System.out.println("Não é possível converter o tipo " + token.getContent() + " em " + content);
                            throw e;
                        }
                    break;
                }
            }
        }
    }
}
