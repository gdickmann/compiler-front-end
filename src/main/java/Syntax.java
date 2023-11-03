package main.java;

import java.io.IOException;
import java.util.List;

public class Syntax {
    public static void main(String[] args) {
        try {
            List<String> tokens = Analyzer.scan("C:\\Users\\gustavo.dickmann\\Documents\\first_query.txt");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the .txt file.");
            e.printStackTrace();
        }
    }
}