package the.coyote.cadastros.controllers;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import the.coyote.cadastros.entity.ErrosEntity;
import the.coyote.cadastros.exceptions.NotFound;

@ControllerAdvice
public class ErrosController {

    @ExceptionHandler(NotFound.class)
	public ResponseEntity<ErrosEntity> notFound(NotFound e, ServletRequest request) {
		ErrosEntity error = new ErrosEntity(
				System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(),
				e.getMessage()
		);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
    
}
