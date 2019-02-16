package com.mastercard.homework.determiner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

public class CityConnectionDeterminerTest {

	private CityConnectionDeterminer cityConnectionDeterminer;
	
	@Before
	public void setUp() {
		cityConnectionDeterminer = new CityConnectionDeterminer();
		ReflectionTestUtils.setField(cityConnectionDeterminer, "citiesMap", buildCityMap());
	}
	
	@Test
	public void determineConnectivity() {
		assertTrue(cityConnectionDeterminer.determineConnectivity("Boston", "Newark"));
		assertTrue(cityConnectionDeterminer.determineConnectivity("Boston", "Philadelphia"));
		assertFalse(cityConnectionDeterminer.determineConnectivity("Philadelphia", "Albany"));
		assertFalse(cityConnectionDeterminer.determineConnectivity("Philadelphia", "Trenton"));
		assertTrue(cityConnectionDeterminer.determineConnectivity("Trenton", "Albany"));
	}
	
	private Map<String,Set<String>> buildCityMap() {
		Map<String,Set<String>> map = new HashMap<String,Set<String>>();		
		map.put("Boston", (Set<String>) new HashSet<String>(Arrays.asList("New York", "Newark")));
		map.put("New York", (Set<String>) new HashSet<String>(Arrays.asList("Boston")));
		map.put("Philadelphia", (Set<String>) new HashSet<String>(Arrays.asList("Newark")));
		map.put("Newark", (Set<String>) new HashSet<String>(Arrays.asList("Boston", "Philadelphia")));
		map.put("Trenton", (Set<String>) new HashSet<String>(Arrays.asList("Albany")));
		map.put("Albany", (Set<String>) new HashSet<String>(Arrays.asList("Trenton")));
		return map;
	}
}
