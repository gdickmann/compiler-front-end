import java.io.IOException;
import java.util.List;

import front_end.lexical.table.TableBuilder;
import front_end.lexical.table.Token;
import front_end.lexical.utils.InputScanner;
import front_end.syntatic.parser.Syntatic;
import front_end.semantic.parser.Semantic;


public class Main {

    public static void main(String[] args) throws Exception {
        try {
            // Lexical analysis
            List<String> tokens = InputScanner.scan("/home/dickmann/Documents/code.txt");
            List<Token> table = TableBuilder.build(tokens);

            // Both of them executes at the same time. Try to call them in a thread.
            // Syntatic analysis
            try {
                Syntatic.parse(table);
                System.out.println("Código-fonte com sintaxe correta.");
            } catch (Exception e) {
                System.out.println(e);
                throw e;
            }

            try {
                Semantic.parse(table);
                System.out.println("Código-fonte com semântica correta.");
            } catch (Exception e) {
                throw e;
            }

            // Semantic analysis
            // TODO
        } catch (IOException e) {
            System.out.println("Um erro ocorreu ao ler o arquivo de texto fornecido.");
            e.printStackTrace();
        }
    }
}