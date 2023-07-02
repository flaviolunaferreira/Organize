package the.coyote.usuarios.exceptions;

public class IntegretyViolation extends RuntimeException {
    public IntegretyViolation(String message) {
        super(message);
    }
    public IntegretyViolation(String message, Throwable cause) {
        super(message, cause);
    }


}
