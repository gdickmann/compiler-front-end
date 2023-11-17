package front_end.token;

public class SupportedTokens {
    public static String separators = "[(){}.\"]+|;";  // supported separators on this automata are '()', '{}', '.', '""' and ';'.
    public static String keywords = "\\b(int|String|double|boolean)\\b";  // supported keywords on this automata are 'int', 'string', 'double' and 'boolean'.
    public static String operators = "[+\\-*=\\/ ]";  // supported separators on this automata are '+', '-', '*', '=' and '/'.
    public static String comment = "^//$";  // supported comments on this automata is '//'.
}
