package com.springboot.myapplication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class CourseException extends Exception
{
	private String message;

	HttpStatus statusCode;

	LocalDateTime localDataTime;

	public CourseException() {
		super();
	}



	public CourseException(String message, HttpStatus statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}



	public CourseException(String message, HttpStatus statusCode, LocalDateTime localDataTime) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.localDataTime = localDataTime;
	}

	@Override
	public String toString() {
		return "CourseException [message=" + message + ", statusCode=" + statusCode + ", localDataTime=" + localDataTime
				+ "]";
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



	public LocalDateTime getLocalDataTime() {
		return localDataTime;
	}



	public void setLocalDataTime(LocalDateTime localDataTime) {
		this.localDataTime = localDataTime;
	}




}
