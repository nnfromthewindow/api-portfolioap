package com.portfolioap.apiportfolio.exception;

public class ExistingUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public ExistingUserException(String message) {
		super(message);
	}
}
