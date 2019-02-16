package com.mastercard.homework.builder;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CitiesMapBuilderTest {

	@InjectMocks
	private CitiesMapBuilder citiesMapBuilder;
	
	@Mock
	private CitiesConnectionBuilder citiesConnectionBuilder;
	
	@Test
	public void build() {
		assertNotNull(citiesMapBuilder.build(buildInputList()));
		verify(citiesConnectionBuilder, times(2)).build(Mockito.anyMap(), Mockito.anyString() , Mockito.anyString());
	}
	
	private List<String> buildInputList() {
		List<String> list = new ArrayList<String>();
		list.add("Chicago,NewYork");
		return list;
	}
	
}
