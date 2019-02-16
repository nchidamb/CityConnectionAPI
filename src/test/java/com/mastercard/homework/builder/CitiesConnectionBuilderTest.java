package com.mastercard.homework.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class CitiesConnectionBuilderTest {

	private CitiesConnectionBuilder citiesConnectionBuilder;
	
	@Before
	public void setUp() {
		citiesConnectionBuilder = new CitiesConnectionBuilder();
	}
	
	@Test
	public void build() {
		Map<String, Set<String>> inputMap = buildInputCityMap();
		String origin = "Tampa";
		String destination = "Dallas";
		citiesConnectionBuilder.build(inputMap, origin, destination);
		assertEquals(1, inputMap.size());
		assertEquals(3, inputMap.get(origin).size());
		assertTrue(inputMap.get(origin).contains(destination));
	}
	
	@Test
	public void buildNewCityConnection() {
		Map<String, Set<String>> inputMap = buildInputCityMap();
		String origin = "Chicago";
		String destination = "Dallas";
		citiesConnectionBuilder.build(inputMap, origin, destination);
		assertEquals(2, inputMap.size());
		assertEquals(1, inputMap.get(origin).size());
		assertTrue(inputMap.get(origin).contains(destination));
	}
	
	private Map<String,Set<String>> buildInputCityMap() {
		Map<String,Set<String>> map = new HashMap<String,Set<String>>();
		Set<String> set = new HashSet<String>();
		set.add("NewYork");
		set.add("Chicago");
		map.put("Tampa", set);
		return map;
	}
	
}
