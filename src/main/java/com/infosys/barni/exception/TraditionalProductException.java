package com.infosys.barni.exception;

public class TraditionalProductException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public TraditionalProductException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public TraditionalProductException() {
		super();
	}
}