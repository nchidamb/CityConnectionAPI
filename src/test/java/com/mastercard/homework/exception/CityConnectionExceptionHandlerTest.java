package com.mastercard.homework.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectionExceptionHandlerTest {

	@InjectMocks
	private CityConnectionExceptionHandler cityConnectionExceptionHandler;

	@Mock
	private WebRequest mockRequest;
	
	@Mock
	private Exception mockException;

	@Test
	public void handleCityConnectionSystemException() {
		CityConnectionSystemException exception = new CityConnectionSystemException("Exception Msg", mockException);
		ResponseEntity<Object> response = cityConnectionExceptionHandler.handleCityConnectionSystemException(exception, mockRequest);
		assertEquals("Internal Server Error : Exception Msg", response.getBody());
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
}
