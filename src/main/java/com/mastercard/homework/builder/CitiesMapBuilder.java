package com.mastercard.homework.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.homework.exception.CityConnectionSystemException;

@Component
public class CitiesMapBuilder {
	
	private static final String DELIMITER = ",";
	
	@Autowired
	private CitiesConnectionBuilder citiesConnectionBuilder;
	
	public Map<String, Set<String>> build(List<String> cityConnList) {
		Map<String, Set<String>> citiesMap = new HashMap<String, Set<String>>();
		for(String cityConn : cityConnList) {
			if(cityConn.contains(DELIMITER)) {
				String[] connectedCities = cityConn.split(DELIMITER);
				citiesConnectionBuilder.build(citiesMap, connectedCities[0].trim(), connectedCities[1].trim());
				citiesConnectionBuilder.build(citiesMap, connectedCities[1].trim(), connectedCities[0].trim());
			} else {
				throw new CityConnectionSystemException("File content error - Missing the delimiter");
			}
		}
		return citiesMap;
	}
}
