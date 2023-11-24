import java.io.IOException;
import java.util.List;

import front_end.lexical.table.TableBuilder;
import front_end.lexical.table.Token;
import front_end.lexical.utils.InputScanner;
import front_end.syntatic.parser.Parser;

public class Main {

    public static void main(String[] args) {
        try {
            // Lexical analysis
            List<String> tokens = InputScanner.scan("C:\\Users\\Biscoitinho\\Documents\\lkd.txt");
            List<Token> table = TableBuilder.build(tokens);

            // Both of them executes at the same time. Try to call them in a thread.
            // Syntatic analysis
            try {
                Parser.parse(table);
                System.out.println("Código-fonte com sintaxe correta.");
            } catch (Exception e) {
                System.out.println(e);
            }

            // Semantic analysis
            // TODO
        } catch (IOException e) {
            System.out.println("An error occurred while reading the .txt file.");
            e.printStackTrace();
        }
    }
}