package com.mastercard.homework.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class CityConnectionExceptionHandler extends ResponseEntityExceptionHandler { 
    
	private static final Logger LOGGER = LoggerFactory.getLogger(CityConnectionExceptionHandler.class);
	
	@ExceptionHandler(value = { CityConnectionSystemException.class })
    public ResponseEntity<Object> handleCityConnectionSystemException(CityConnectionSystemException ex, WebRequest request) {
		LOGGER.error("Exception occured while processing the request - " + ex.getMessage());
		String errorResponse = "Internal Server Error : " + ex.getMessage();
        return handleExceptionInternal(ex, errorResponse, 
        		new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}