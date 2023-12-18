package comp;

public class Tokenizer {
    String text;
    int cur;

    public Tokenizer(String text) {
        this.text = text;
        this.cur = 0;
    }

    //gives current char, or '\0' if invalid
    public char curChar() {
        if (cur >= text.length()) {
            return '\0';
        }
        else if (cur < 0) {
            System.err.println("error: tokenizer.cur < 0");
            System.exit(1);
            return 0; //vscode calm down
        }
        else {
            return text.charAt(cur);
        }
    }

    //gives next char, and increments cur.
    //gives '\0' if invalid
    public char nextChar() {
        if (cur+1 < text.length()) {
            return text.charAt(++cur);
        }
        else {
            cur++;
            return '\0';
        }
    }


    //always leaves cur on the next unread char
    public Token nextToken() {
        Token t = new Token();

        if (curChar() == '\0') {
            t.type = TokenType.eof;
        }
        else if (Character.isDigit(curChar())) {
            t.type = TokenType.num;
            t.text = "";
            do {
                t.text += curChar();
            } while (Character.isDigit(nextChar()));
            t.value = Integer.parseInt(t.text);
        }
        else if (Character.isWhitespace(curChar())) {
            t.type = TokenType.whitespace;
            t.text = "";
            do {
                t.text += curChar();
            } while (Character.isWhitespace(nextChar()));
        }
        else {
            t.type = getSingleCharToken(curChar());
            t.text = curChar() + "";
            nextChar();
        }
        return t;
    }



    public static TokenType getSingleCharToken(char c) {
        final char[] cases = {';', '+', '-', '*', '/', '%', '(', ')'};
        final TokenType[] caseTypes = {
            TokenType.semi,
            TokenType.add,
            TokenType.subtract,
            TokenType.star,
            TokenType.slash,
            TokenType.modulo,
            TokenType.openParens,
            TokenType.closeParens,
            TokenType.invalid
        };

        int id = 0;
        while (id < cases.length && c != cases[id]) {
            id++;
        }

        return caseTypes[id];
    }
}