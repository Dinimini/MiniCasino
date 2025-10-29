package pa.minicasino.exception;

public class InvalidBetException extends RuntimeException {
    public InvalidBetException(String message) {
        super(message);
    }
}
