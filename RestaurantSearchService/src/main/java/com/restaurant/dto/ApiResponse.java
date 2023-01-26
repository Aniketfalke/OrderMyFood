package com.restaurant.dto;



import org.springframework.http.HttpStatus;

public class ApiResponse {

	
	private String message;
	
	private boolean success;
	
	private HttpStatus status;

	
	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(String message, boolean success) {
		super();
		this.message = message;
		this.success = success;
	}
	

	
	public ApiResponse(String message, boolean success, HttpStatus error) {
		super();
		this.message = message;
		this.success = success;
		this.status = error;
	}

	
	public HttpStatus getError() {
		return status;
	}

	public void setError(HttpStatus error) {
		this.status = error;
	}

	public String getMessage() {
		return message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	
}
