package comp;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comp {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: ./comp [filename]");
            System.err.println(Arrays.deepToString(args));
            System.exit(1);
        }

        try {
            String file = new String(Files.readAllBytes(Paths.get(args[0])));

            Tokenizer tokenizer = new Tokenizer(file);
            List<Token> tokens = new ArrayList<Token>();

            Token token = tokenizer.nextToken();
            while (token.type != TokenType.eof) {
                tokens.add(token);
                token = tokenizer.nextToken();
            }

            for (Token t : tokens) {
                System.out.println(t.type + ": " + t.text + " val: " + t.value);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
}