package com.infosys.barni.exception;

public class CategoryException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public CategoryException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public CategoryException() {
		super();
	}
}