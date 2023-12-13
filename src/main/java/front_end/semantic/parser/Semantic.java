package front_end.semantic.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import front_end.lexical.table.Token;
import front_end.token.Type;

public class Semantic {

    public static void parse(List<Token> tokens) throws Exception {
        throwExceptionIfIfStatementIsMismatched(tokens);
        throwExceptionIfTypeMismatched(tokens);

    }

    private static void throwExceptionIfTypeMismatched(List<Token> table) throws Exception {
        String content = table.get(3).getContent();

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

    public static void throwExceptionIfIfStatementIsMismatched(List<Token> tokens) throws Exception {
        Integer ifStartAtIndex = null;
        Integer ifEndsAtIndex = null;

        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).getContent().equals("if")) {
                ifStartAtIndex = i;
            }
            if (tokens.get(i).getType() == Type.CLOSED_BRACKETS) {
                ifEndsAtIndex = i;
            }
        }

        if (ifStartAtIndex == null && ifEndsAtIndex == null) return;

        try {
            if (!checkToken(tokens.get(ifStartAtIndex), Type.KEYWORD, "if")) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;

            if (!checkToken(tokens.get(ifStartAtIndex), Type.OPEN_PARENTHESIS, "(")) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;

            if (!checkToken(tokens.get(ifStartAtIndex), Type.LITERAL, null)) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;

            if (!checkToken(tokens.get(ifStartAtIndex), Type.OPERATOR, null)) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;

            if (!checkToken(tokens.get(ifStartAtIndex), Type.LITERAL, null)) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;

            if (!checkToken(tokens.get(ifStartAtIndex), Type.CLOSED_PARENTHESIS, ")")) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;

            if (!checkToken(tokens.get(ifStartAtIndex), Type.OPEN_BRACKETS, "{")) {
                throw new Exception("Sintaxe do if inválida.");
            }
            ifStartAtIndex++;


            // Verifica se o próximo token é '}'
            if (!checkToken(tokens.get(ifStartAtIndex), Type.CLOSED_BRACKETS, "}")) {
                throw new Exception("Sintaxe do if inválida.");
            }
        } catch (Exception e) {
            System.out.println("A sintáxe do if está incorreta.");
            throw e;
        }

        

        // Se chegamos até aqui, a expressão 'if' é válida
    }

    // Função auxiliar para verificar um token específico
    private static boolean checkToken(Token token, Type expectedType, String expectedValue) {
        return (token.getType() == expectedType) && (expectedValue == null || token.getContent().equals(expectedValue));
    }
}
