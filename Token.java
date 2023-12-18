package comp;

public class Token {
    TokenType type;
    String text;
    Object value;
    
    public Token() {
        this.type = null;
        this.text = null;
        this.value = null;
    }
    public Token(TokenType type, String text, Object value) {
        this.type = type;
        this.text = text;
        this.value = value;
    }
    public Token(TokenType type, String text) {
        this.type = type;
        this.text = text;
        this.value = null;
    }
}
