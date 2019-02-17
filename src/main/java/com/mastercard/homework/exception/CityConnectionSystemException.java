package com.mastercard.homework.exception;

public class CityConnectionSystemException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public CityConnectionSystemException(String message) {
		super(message);
	}
	
	public CityConnectionSystemException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
