package com.mastercard.homework.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class CityConnectionExceptionHandler extends ResponseEntityExceptionHandler { 
    
	private static final Logger LOGGER = LoggerFactory.getLogger(CityConnectionExceptionHandler.class);
	
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, 
	  HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";
		LOGGER.error(error + ":" + ex.getMessage());
		return new ResponseEntity<Object>(error, headers, status);
	}
}