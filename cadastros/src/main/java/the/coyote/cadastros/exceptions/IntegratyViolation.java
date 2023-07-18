package the.coyote.cadastros.exceptions;

public class IntegratyViolation extends RuntimeException {

    public IntegratyViolation(String message, Throwable cause) {
        super(message, cause);
    }

    public IntegratyViolation(String message) {
        super(message);
    }
}
