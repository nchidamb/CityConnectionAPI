package com.mastercard.homework.builder;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class CitiesConnectionBuilder {

	public void build(Map<String, Set<String>> citiesMap, String origin, String destination) {
		if(citiesMap.containsKey(origin)) {
			citiesMap.get(origin).add(destination);
		} else {
			Set<String> connectionSet = new HashSet<String>();
			connectionSet.add(destination);
			citiesMap.put(origin, connectionSet);
		}
	}
}
