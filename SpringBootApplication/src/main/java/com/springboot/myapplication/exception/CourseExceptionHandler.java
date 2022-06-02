package com.springboot.myapplication.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.myapplication.response.ExceptionResponse;

@ControllerAdvice
public class CourseExceptionHandler extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(CourseException.class)
	public final ResponseEntity<ExceptionResponse> courseException(CourseException ex)
	{
		ExceptionResponse exception= new ExceptionResponse();
		exception.setMessage(ex.getMessage());
		exception.setStatusCode(ex.getStatusCode());
		exception.setLocalDateTime(LocalDateTime.now());

		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResponse(exception.getMessage(),exception.getStatusCode(),exception.getLocalDateTime()));
	}
}
