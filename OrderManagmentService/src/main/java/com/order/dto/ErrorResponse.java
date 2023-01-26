package com.order.dto;

import java.util.Date;

public class ErrorResponse {

	private String status;
	
	private String message;
	
	private Date timeStamp;

	
	public ErrorResponse(String status, String message, Date timeStamp) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	
	
	
}
