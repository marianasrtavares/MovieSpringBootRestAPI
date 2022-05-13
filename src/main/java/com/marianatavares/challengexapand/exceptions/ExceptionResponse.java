package com.marianatavares.challengexapand.exceptions;

import org.springframework.http.HttpStatus;

public class ExceptionResponse {

	private String message;
	private String details;
	private HttpStatus status;

	public ExceptionResponse(String message, String details, HttpStatus status) {
		this.message = message;
		this.details = details;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	public HttpStatus getStatus() {
		return status;
	}

}
