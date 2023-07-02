package the.coyote.usuarios.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorEntity> notFoundException(NotFound e, ServletRequest request) {
        ErrorEntity error = new ErrorEntity (
                System.currentTimeMillis(),
                HttpStatus.NOT_FOUND.value(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DuplicateValue.class)
    public ResponseEntity<ErrorEntity> duplicateValueException(DuplicateValue e, ServletRequest request) {
        ErrorEntity error = new ErrorEntity(
                System.currentTimeMillis(),
                HttpStatus.NOT_ACCEPTABLE.value(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(error);
    }

    @ExceptionHandler(IntegretyViolation.class)
    public ResponseEntity<ErrorEntity> integretyViolation(IntegretyViolation e, ServletRequest request) {
        ErrorEntity error = new ErrorEntity(
                System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
