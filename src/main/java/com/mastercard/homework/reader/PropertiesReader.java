package com.mastercard.homework.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.mastercard.homework.builder.CitiesMapBuilder;
import com.mastercard.homework.exception.CityConnectionSystemException;

@Component
public class PropertiesReader {
	
	@Value("${file.path:src/main/resource/city.txt}")
	private String filePath;
	
	@Autowired
	private CitiesMapBuilder citiesMapBuilder;
	
	public Map<String,Set<String>> readFromFile() {
		List<String> cityConnList = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
			cityConnList = stream.collect(Collectors.toList());
		} catch (IOException e) {
			throw new CityConnectionSystemException(e.getMessage(), e);
		}
		return citiesMapBuilder.build(cityConnList);
	}
}
