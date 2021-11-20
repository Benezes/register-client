package br.com.gabriel.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardMessageError> objectNotFoundException(ObjectNotFoundException ex,
			HttpServletRequest request) {

		StandardMessageError err = new StandardMessageError();

		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Not found");
		err.setMessage(ex.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(ObjectAlreadyExistException.class)
	public ResponseEntity<StandardMessageError> objectAlreadyExistException(ObjectAlreadyExistException ex,
			HttpServletRequest request) {

		StandardMessageError err = new StandardMessageError();

		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Bad Request");
		err.setMessage(ex.getMessage());
		err.setPath(request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}
