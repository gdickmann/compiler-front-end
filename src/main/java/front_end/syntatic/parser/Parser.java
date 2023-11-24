package front_end.syntatic.parser;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import front_end.lexical.table.Token;

public class Parser {

    /**
     * Dado uma tabela de lexemas, lança uma exceção caso haja algum erro sintático.
     * A tabela gramática livre de contexto utilizado é a de Backus–Naur.
     * @param table A tabela de lexemas
     */
    public static void parse(List<Token> table) throws RuntimeException {
        for (int i = 0; i < table.size(); i++) {
            /**
             * É importante notar que, por fins didáticos, foi utilizado uma gramática de Buckus simples
             * o suficiente para a definição da sintaxe ser possível apenas através de uma única definição.
             * 
             * Na prática, a gramática de Buckus é muito maior. Por conta disso, validar a sintaxe do código se torna um processo
             * infinitamente mais complexo. Uma das abordagens principais é fazer a utilização de uma árvore, fazendo assim com que cada nó
             * represente a ordem correta da sintaxe do código.
             * 
             * https://en.wikipedia.org/wiki/Parsing#Overview_of_process:~:text=define%20these%20actions.-,Types%20of%20parsers,-%5Bedit%5D
             */
            if (table.get(i).getType() != GrammaticalTable.declaration[i]) throw new RuntimeException("Sintáxe inválida.");

            StringBuilder expression = new StringBuilder();

            for (Token token : table) {
                expression.append(token.getContent());
            }
            
            if (!areAllParenthesesClosed(expression.toString())) throw new RuntimeException("Os parênteses não foram devidamente fechados.");
        }
    }

    private static boolean areAllParenthesesClosed(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : expression.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.isEmpty();
    }
}
