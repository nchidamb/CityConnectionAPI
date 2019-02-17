package com.mastercard.homework.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectionExceptionHandlerTest {

	@InjectMocks
	private CityConnectionExceptionHandler cityConnectionExceptionHandler;

	@Mock
	private WebRequest mockRequest;
	
	@Mock
	private HttpHeaders mockHeaders;
	
	@Test
	public void handleMissingServletRequestParameter() {
		MissingServletRequestParameterException exception = new MissingServletRequestParameterException("origin", "String");
		ResponseEntity<Object> response = cityConnectionExceptionHandler.handleMissingServletRequestParameter(exception, mockHeaders, HttpStatus.BAD_REQUEST, mockRequest);
		assertEquals("origin parameter is missing", response.getBody());
	}
	
}
