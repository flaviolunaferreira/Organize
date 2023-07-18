package the.coyote.cadastros.exceptions;

public class NotFound extends RuntimeException {

    public NotFound(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFound(String message) {
        super(message);
    }
        
}
