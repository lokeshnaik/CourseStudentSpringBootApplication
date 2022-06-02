package com.springboot.myapplication.response;

public class StudentResponse
{
	private String message;
	private int statusCode;
	private Object data;


	public StudentResponse() {
		super();
	}


	public StudentResponse(String message, int statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}


	public StudentResponse(String message, int statusCode, Object data) {
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
