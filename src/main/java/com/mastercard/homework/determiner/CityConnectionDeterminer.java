package com.mastercard.homework.determiner;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class CityConnectionDeterminer {

	@Resource(name="citiesMap")
	private Map<String,Set<String>> citiesMap;
	
	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return true if origin is connected with destination, false otherwise
	 * This is a breadth first search algorithm implementation
	 */
	public boolean determineConnectivity(String origin, String destination) {
		Set<String> citiesVisited = new HashSet<String>();
		Queue<String> citiesToVisit = new ArrayDeque<String>();
		citiesToVisit.add(origin);

		while(!citiesToVisit.isEmpty()) {
			String city = citiesToVisit.poll();
			citiesVisited.add(city);
			Set<String> connectedCities = citiesMap.get(city);
			if(connectedCities.contains(destination)) {
				return true;
			}
			populateMoreCitiesToVisit(citiesVisited, citiesToVisit, connectedCities);
		}
		return false;
	}

	private void populateMoreCitiesToVisit(Set<String> citiesVisited, Queue<String> citiesToVisit,
			Set<String> connectedCities) {
		for(String connectedCity: connectedCities) {
			if(!citiesVisited.contains(connectedCity)) {
				citiesToVisit.add(connectedCity);
			}
		}
	}
}
