package com.marianatavares.challengexapand.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {
	
	private String message;
	private String details;
	private HttpStatus httpStatus;
	
	public ExceptionResponse(String message, String details, HttpStatus httpStatus) {
		this.message = message;
		this.details = details;
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	
	
	
	
	

}
