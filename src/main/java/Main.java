import java.io.IOException;
import java.util.List;

import front_end.lexeme.TableBuilder;
import front_end.lexeme.Lexeme;
import front_end.utils.InputScanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Lexical analysis
            List<String> tokens = InputScanner.scan("C:\\Users\\Biscoitinho\\Documents\\lkd.txt");
            List<Lexeme> table = TableBuilder.build(tokens);

            // Semantic analysis
            // TODO
        } catch (IOException e) {
            System.out.println("An error occurred while reading the .txt file.");
            e.printStackTrace();
        }
    }
}