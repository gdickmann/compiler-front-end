package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Analyzer {

    /**
     * Given an absolute path to a .txt file, reads its Java code
     * and returns the token stream.
     */
    protected static List<String> scan(String path) throws IOException {
        File file = new File(path);
        Scanner input = new Scanner(file);

        List<String> response = new ArrayList<String>();

        while (input.hasNext()) {
            String word = input.next();
            response.add(word);
        }

        input.close();
        return response;
    }
}
