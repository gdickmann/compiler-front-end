package front_end.token;

public class SupportedTypes {
    public static String keywords = "\\b(int|String|double|boolean|if)\\b";  // supported keywords on this automata are 'int', 'String', 'double', 'boolean' and 'if'.
    public static String operator = "[=><]";  // supported operator on this automata is '='.
    public static String separator = ";";  // supported separator on this automata is ';'.
    public static String comment = "^//$";  // supported comments on this automata is '//'.
    public static String openParenthesis = "\\(";
    public static String closedParenthesis = "\\)";
    public static String openBrackets = "\\{";
    public static String closedBrackets = "\\}";
}
