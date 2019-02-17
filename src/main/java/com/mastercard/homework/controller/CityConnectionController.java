package com.mastercard.homework.controller;

import org.springframework.web.bind.annotation.RestController;

import com.mastercard.homework.service.CityConnectionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Api(description="City Connections API")
public class CityConnectionController {
    
	private static final String YES = "Yes";
	private static final String NO = "No";
	
	@Autowired
	private CityConnectionService cityConnectionService;
	
    @GetMapping(path = "/connected")
    @ApiOperation(value="Checks if given cities are connected")
    public String isConnected(@NotBlank @RequestParam("origin") String origin, 
    		@NotBlank @RequestParam("destination") String destination) {
    	boolean isConnected = cityConnectionService.isConnected(origin, destination);
    	return (isConnected) ? YES : NO;
    }    
}