package the.coyote.usuarios.exceptions;

public class IntegretyViolation extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IntegretyViolation(String message) {
        super(message);
    }
    public IntegretyViolation(String message, Throwable cause) {
        super(message, cause);
    }


}
