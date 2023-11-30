package front_end.token;

public class SupportedTypes {
    public static String keywords = "\\b(int|String|double|boolean)\\b";  // supported keywords on this automata are 'int', 'String', 'double' and 'boolean'.
    public static String operator = "=";  // supported operator on this automata is '='.
    public static String separator = ";";  // supported separator on this automata is ';'.
    public static String comment = "^//$";  // supported comments on this automata is '//'.
}
