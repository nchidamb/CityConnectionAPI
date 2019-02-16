package com.mastercard.homework.config;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mastercard.homework.reader.PropertiesReader;

@RunWith(MockitoJUnitRunner.class)
public class CitiesMapConfigTest {

	@InjectMocks
	private CitiesMapConfig citiesMapConfig;
	
	@Mock
	private PropertiesReader propertiesReaderMock;
	
	@Mock
	private Map<String,Set<String>> mockMap;
	
	@Test
	public void citiesMap() {
		when(propertiesReaderMock.readFromFile()).thenReturn(mockMap);
		assertEquals(mockMap, citiesMapConfig.citiesMap());
		verify(propertiesReaderMock).readFromFile();
	}
	
}
