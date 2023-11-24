package front_end.lexical.token;

public class SupportedTypes {
    public static String keywords = "\\b(int|String|double|boolean)\\b";  // supported keywords on this automata are 'int', 'String', 'double' and 'boolean'.
    public static String operators = "=";  // supported separator on this automata is '='.
    public static String comment = "^//$";  // supported comments on this automata is '//'.
}
