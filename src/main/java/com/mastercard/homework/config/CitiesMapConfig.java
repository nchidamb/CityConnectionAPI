package com.mastercard.homework.config;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mastercard.homework.reader.PropertiesReader;

@Configuration
public class CitiesMapConfig {
	
	@Autowired
	private PropertiesReader propertiesReader;
	
	@Bean(name="citiesMap")
	public Map<String,Set<String>> citiesMap() {
		return propertiesReader.readFromFile();
	}
	
}
