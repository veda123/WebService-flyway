package com.testSetTool.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.testSetTool.repositories.LocationPOCRepository;
import com.testSetTool.repositories.LocationRepository;

@RestController
@RequestMapping("/api")
public class LocationPOCController {
	
	@Autowired
	private LocationPOCRepository locationPOCRepository;
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("/locationsPOC")
	public List<LocationPOC> getLocationPOC(){	
		return locationPOCRepository.findAll();
	}
	
	@GetMapping("/locationPOC/{id}")
	public LocationPOC getLocation(@PathVariable("id") Integer id) {
		return locationPOCRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("locationPOCID " + id + " not found"));
	}
	
	@PostMapping("/locations/{locationID}/locationPOC")
	public Optional<Object> createLocation(@PathVariable("locationID") Integer locationID,
			                          @Valid @RequestBody LocationPOC locationPOC) {
		return locationRepository.findById(locationID).map(location -> {
			locationPOC.setLocation(location);
			return locationPOCRepository.save(locationPOC);
			
        });
	}
	  
	@PutMapping("/locationsPOC/{id}")
	public Optional<Object> updateLocationPOC(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody LocationPOC POCRequest) {
		if(!locationPOCRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
        return locationPOCRepository.findById(id).map(locationPOC -> {
        	locationPOC.setContactName(POCRequest.getContactName());
        	locationPOC.setEmail(POCRequest.getEmail());
        	locationPOC.setPhone(POCRequest.getPhone());
        	locationPOC.setTitle(POCRequest.getTitle());
        	return locationPOCRepository.save(locationPOC);
           
        });
    }
	
	@DeleteMapping("/locationsPOC/{id}")
	public Optional<Object> deleteLocationPOC(@PathVariable (value="id")Integer id) {
		if(!locationPOCRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return locationPOCRepository.findById(id).map(locationPOC -> {
            locationPOCRepository.delete(locationPOC);
            return ResponseEntity.ok().build();
        });
    }	
}
