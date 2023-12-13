package front_end.lexical.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import front_end.token.SupportedTypes;

public class InputScanner {

    /**
     * Escaneia o código e separa as palavras em cada token suportada.
     * As palavras chaves suportadas podem ser encontradas em {@link SupportedTypes}.
     * @param path O caminho para o arquivo a ser escaneado.
     * @return Lista com cada token suportada.
     */
    public static List<String> scan(String path) throws IOException {
        List<String> response = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader(path));

        int character;
        StringBuilder stringBuilder = new StringBuilder();

        while ((character = reader.read()) != -1) {
            char x = (char) character;

            if (isOperatorOrSeparator(x)) {
                saveStringIfAny(stringBuilder, response);
                response.add(String.valueOf(x));

                continue;
            }

            if (Character.isWhitespace(x)) {
                saveStringIfAny(stringBuilder, response);
                continue;
            }
            stringBuilder.append(x);
        }
        saveStringIfAny(stringBuilder, response);
        reader.close();

        return response;
    }

    private static void saveStringIfAny(StringBuilder stringBuilder, List<String> response) {
        if (!stringBuilder.toString().isEmpty()) {
            response.add(stringBuilder.toString());
            // clears the builder since we'll have new words
            stringBuilder.setLength(0);
        }
    }

    /** Determina se o caractere é um operador ou separador.
     * Separadores e operadores suportados podem ser vistos em {@link SupportedTypes}.
     * 
     * @param x Caractere a ser analisado
     * @return Verdadeiro se é um separador; falso caso contrário.
     */
    private static boolean isOperatorOrSeparator(char x) {
        Pattern oPattern = Pattern.compile(SupportedTypes.operator);
        Matcher operatorMatcher = oPattern.matcher(String.valueOf(x));

        Pattern sPattern = Pattern.compile(SupportedTypes.separator);
        Matcher separatorMatcher = sPattern.matcher(String.valueOf(x));

        Pattern op = Pattern.compile(SupportedTypes.openParenthesis);
        Matcher opMatcher = op.matcher(String.valueOf(x));

        Pattern cp = Pattern.compile(SupportedTypes.closedParenthesis);
        Matcher cpMatcher = cp.matcher(String.valueOf(x));

        Pattern ob = Pattern.compile(SupportedTypes.openBrackets);
        Matcher obMatcher = ob.matcher(String.valueOf(x));

        Pattern cb = Pattern.compile(SupportedTypes.closedBrackets);
        Matcher cbMatcher = cb.matcher(String.valueOf(x));

        return operatorMatcher.matches() || separatorMatcher.matches() || opMatcher.matches() || cpMatcher.matches() || obMatcher.matches() || cbMatcher.matches();
    }
}
