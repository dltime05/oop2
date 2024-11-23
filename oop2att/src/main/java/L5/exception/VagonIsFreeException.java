package L5.exception;

public class VagonIsFreeException extends RuntimeException {
    public VagonIsFreeException(String message) {
        super(message);
    }
}
