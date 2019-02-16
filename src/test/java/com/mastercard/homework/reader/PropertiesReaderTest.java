package com.mastercard.homework.reader;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.mastercard.homework.builder.CitiesMapBuilder;
import com.mastercard.homework.exception.CityConnectionSystemException;

@RunWith(MockitoJUnitRunner.class)
public class PropertiesReaderTest {

	@InjectMocks
	private PropertiesReader propertiesReader;
	
	@Mock
	private CitiesMapBuilder citiesMapBuilderMock;
	
	@Mock
	private Map<String,Set<String>> mockMap;
	
	@Test
	public void readFromFile() {
		ReflectionTestUtils.setField(propertiesReader, "filePath", "src/test/resource/city.txt");
		when(citiesMapBuilderMock.build(Mockito.anyList())).thenReturn(mockMap);
		assertEquals(mockMap, propertiesReader.readFromFile());
		verify(citiesMapBuilderMock).build(Mockito.anyList());
	}
	
	@Test(expected=CityConnectionSystemException.class)
	public void readFromUnavailableFile() {
		ReflectionTestUtils.setField(propertiesReader, "filePath", "src/test/resource/unavailable.txt");
		propertiesReader.readFromFile();
	}
}
