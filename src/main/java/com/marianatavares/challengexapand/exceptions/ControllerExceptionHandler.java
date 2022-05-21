package com.marianatavares.challengexapand.exceptions;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("The request was not found", ex.getMessage(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
	}

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Illegal argument", ex.getMessage(),
				HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleException(Exception ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse("Error", ex.getMessage(),
				HttpStatus.INTERNAL_SERVER_ERROR);

		return new ResponseEntity<>(exceptionResponse, exceptionResponse.getStatus());
	}

}
