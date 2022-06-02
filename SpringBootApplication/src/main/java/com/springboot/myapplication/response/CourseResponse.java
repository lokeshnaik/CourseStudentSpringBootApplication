package com.springboot.myapplication.response;

public class CourseResponse 
{

	private String message;
	private int statusCode;
	private Object data;


	public CourseResponse() {
		super();
	}


	public CourseResponse(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}


	public CourseResponse(String message, int statusCode, Object data) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.data = data;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}



}
