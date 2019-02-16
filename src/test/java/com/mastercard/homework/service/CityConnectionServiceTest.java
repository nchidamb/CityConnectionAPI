package com.mastercard.homework.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mastercard.homework.determiner.CityConnectionDeterminer;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectionServiceTest {

	@InjectMocks
	private CityConnectionService cityConnectionService;
	
	@Mock
	private Map<String,Set<String>> citiesMapMock;
	
	@Mock
	private CityConnectionDeterminer cityConnectionDeterminerMock;
	
	@Test
	public void isConnectedSamePlace() {
		assertTrue(cityConnectionService.isConnected("NewYork", "NewYork"));
	}
	
	@Test
	public void isConnectedWithOriginNotinMap() {
		String origin = "NewYork";
		String dest = "Chicago";
		when(citiesMapMock.containsKey(origin)).thenReturn(false);
		assertFalse(cityConnectionService.isConnected(origin, dest));
		verify(citiesMapMock).containsKey(origin);
	}
	
	@Test
	public void isConnectedWithDestinationNotinMap() {
		String origin = "NewYork";
		String dest = "Chicago";
		when(citiesMapMock.containsKey(origin)).thenReturn(true);
		when(citiesMapMock.containsKey(dest)).thenReturn(false);
		assertFalse(cityConnectionService.isConnected(origin, dest));
		verify(citiesMapMock).containsKey(origin);
		verify(citiesMapMock).containsKey(dest);
	}
	
	@Test
	public void isConnected() {
		String origin = "NewYork";
		String dest = "Chicago";
		when(citiesMapMock.containsKey(origin)).thenReturn(true);
		when(citiesMapMock.containsKey(dest)).thenReturn(true);
		when(cityConnectionDeterminerMock.determineConnectivity(origin, dest)).thenReturn(true);
		assertTrue(cityConnectionService.isConnected(origin, dest));
		verify(citiesMapMock).containsKey(origin);
		verify(citiesMapMock).containsKey(dest);
	}
}
