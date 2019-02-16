package com.mastercard.homework.service;

import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mastercard.homework.determiner.CityConnectionDeterminer;

@Component
public class CityConnectionService {

	@Resource(name="citiesMap")
	private Map<String,Set<String>> citiesMap;
	
	@Autowired
	private CityConnectionDeterminer cityConnectionDeterminer;
	
	public boolean isConnected(String origin, String destination) {
		if(origin.equalsIgnoreCase(destination)) {
			return true;
		} else if(citiesMap.containsKey(origin) && citiesMap.containsKey(destination)) {
			return cityConnectionDeterminer.determineConnectivity(origin, destination);
		}
		return false;
	}
	
}
