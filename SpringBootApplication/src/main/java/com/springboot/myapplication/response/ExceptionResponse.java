package com.springboot.myapplication.response;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ExceptionResponse
{
	private String message; 

	HttpStatus statusCode;

	LocalDateTime localDateTime;



	public ExceptionResponse() {
		super();
	}



	public ExceptionResponse(String message, HttpStatus statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}



	public ExceptionResponse(String message, HttpStatus statusCode, LocalDateTime localDateTime) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.localDateTime = localDateTime;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public void setLocalDateTime(LocalDateTime localDateTime) {
		this.localDateTime = localDateTime;
	}



	@Override
	public String toString() {
		return "ExceptionResponse [message=" + message + ", statusCode=" + statusCode + ", localDateTime="
				+ localDateTime + "]";
	}




}
