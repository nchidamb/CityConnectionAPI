package com.mastercard.homework.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CitiesMapBuilder {
	
	@Autowired
	private CitiesConnectionBuilder citiesConnectionBuilder;
	
	public Map<String, Set<String>> build(List<String> cityConnList) {
		Map<String, Set<String>> citiesMap = new HashMap<String, Set<String>>();
		for(String cityConn : cityConnList) {
			String[] connectedCities = cityConn.split(",");
			citiesConnectionBuilder.build(citiesMap, connectedCities[0].trim(), connectedCities[1].trim());
			citiesConnectionBuilder.build(citiesMap, connectedCities[1].trim(), connectedCities[0].trim());
		}
		return citiesMap;
	}
}
