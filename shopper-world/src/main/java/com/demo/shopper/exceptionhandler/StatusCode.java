package com.demo.shopper.exceptionhandler;

public enum StatusCode {
	
	DUPLICATE_INSERT("Duplicate Insert","3001");
	public String getStatusMessage() {
		return statusMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	private final String statusMessage;
	private final String statusCode;
	
	StatusCode(String statusMessage, String statusCode){
		this.statusCode=statusCode;
		this.statusMessage=statusMessage;
	}

	
}
