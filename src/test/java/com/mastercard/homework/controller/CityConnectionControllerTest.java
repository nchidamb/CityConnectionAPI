package com.mastercard.homework.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mastercard.homework.service.CityConnectionService;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectionControllerTest {

	@InjectMocks
	private CityConnectionController cityConnectionController;
	
	@Mock
	private CityConnectionService cityConnectionServiceMock;
	
    @Test
    public void isConnected() throws Exception {
    	String origin = "origin";
    	String destination = "destination";
    	when(cityConnectionServiceMock.isConnected(origin, destination)).thenReturn(true);
        assertEquals("Yes", cityConnectionController.isConnected(origin,destination));
        verify(cityConnectionServiceMock).isConnected(origin,destination);
    }
    
    @Test
    public void isConnected_NoConnectionCase() throws Exception {
    	String origin = "origin";
    	String destination = "destination";
    	when(cityConnectionServiceMock.isConnected(origin, destination)).thenReturn(false);
        assertEquals("No", cityConnectionController.isConnected(origin,destination));
        verify(cityConnectionServiceMock).isConnected(origin,destination);
    }
}
