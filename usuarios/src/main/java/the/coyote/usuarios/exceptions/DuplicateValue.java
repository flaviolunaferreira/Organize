package the.coyote.usuarios.exceptions;

public class DuplicateValue extends RuntimeException {

    public DuplicateValue(String message) {
        super(message);
    }
    public DuplicateValue(String message, Throwable cause) {
        super(message, cause);
    }
}
