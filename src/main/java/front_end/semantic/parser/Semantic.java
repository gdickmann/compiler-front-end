package front_end.semantic.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import front_end.lexical.table.Token;
import front_end.token.Type;

public class Semantic {

    public static void parse(List<Token> table) throws Exception {
        throwExceptionIfTypeMismatched(table);
    }

    private static void throwExceptionIfTypeMismatched(List<Token> table) throws Exception {
        String content = table.get(table.size() - 2).getContent();

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
                            String isString = "^\".*\"$";

                            Pattern pattern = Pattern.compile(isString);
                            Matcher matcher = pattern.matcher(content);

                            if (!matcher.matches()) throw new Exception();
                        } catch (Exception e) {
                            System.out.println("Não é possível converter o tipo " + token.getContent() + " em " + content);
                            throw e;
                        }
                    break;
                    case "boolean":
                        try {
                            String isBoolean = "true|false";

                            Pattern pattern = Pattern.compile(isBoolean);
                            Matcher matcher = pattern.matcher(content);

                            if (!matcher.matches()) throw new Exception();
                        } catch (Exception e) {
                            System.out.println("Não é possível converter o tipo " + token.getContent() + " em " + content);
                            throw e;
                        }
                    break;
                    case "double":
                        try {
                            String isDouble = "^[-+]?\\d+(\\.\\d+)?$";

                            Pattern pattern = Pattern.compile(isDouble);
                            Matcher matcher = pattern.matcher(content);

                            if (!matcher.matches()) throw new Exception();
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
