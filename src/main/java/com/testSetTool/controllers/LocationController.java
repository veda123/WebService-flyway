package com.testSetTool.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSetTool.entities.Location;
import com.testSetTool.entities.LocationPOC;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.CountryRepository;
import com.testSetTool.repositories.LocationRepository;

@RestController
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/locations")
	public List<Location> getLocations(){
		
		return locationRepository.findAll();
	}
	
	@GetMapping("/locations/{locationID}")
	public Location getLocation(@PathVariable("locationID") Integer locationID) {
		return locationRepository.findById(locationID).orElseThrow(() -> new ResourceNotFoundException("locationID " + locationID + " not found"));
	}
	
	@PostMapping("/location/{countryId}")
	public Optional<Object> createLocation(@PathVariable("countryId") Integer countryId,
								@RequestBody Location location) {
		return countryRepository.findById(countryId).map(country ->{
			location.setCountry(country);
			return locationRepository.save(location);
		});		
	}

	@DeleteMapping("/locations/{locationID}")
    public Optional<Object> deleteLocation(@PathVariable Integer locationID) {
		if(!locationRepository.existsById(locationID)) {
			throw new ResourceNotFoundException("Id " + locationID + "not found");
		}
        return locationRepository.findById(locationID).map(location -> {
            locationRepository.delete(location);
            return ResponseEntity.ok().build();
        });
    }
	
	
    @PutMapping("/locations/{locationID}")
    public Optional<Object> updateLocation(@PathVariable Integer locationID, @RequestBody Location locRequest) {
    	if(!locationRepository.existsById(locationID)) {
			throw new ResourceNotFoundException("Id " + locationID + "not found");
		}
        return locationRepository.findById(locationID).map(location -> {
            location.setAddress(locRequest.getAddress());
            location.setCity(locRequest.getCity());
            location.setLocationName(locRequest.getLocationName());
            location.setPhone(locRequest.getPhone());
            location.settimezone(locRequest.gettimezone());
            location.setzipcode(locRequest.getzipcode());
            return locationRepository.save(location);
        });
    }


}
