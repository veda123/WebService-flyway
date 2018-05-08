package com.testSetTool.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSetTool.entities.Location;
import com.testSetTool.repositories.LocationRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("/locations")
	public List<Location> getLocations(){
		
		return locationRepository.findAll();
	}

}
