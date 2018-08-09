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

import com.testSetTool.entities.EquipmentInventory;
import com.testSetTool.entities.LocationCapability;
import com.testSetTool.entities.RepairCapability;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.LocationCapRepository;
import com.testSetTool.repositories.LocationRepository;
import com.testSetTool.repositories.RepairCapabilityRepository;

@RestController
@RequestMapping("/api")
public class LocationCapController {
	@Autowired
	private LocationRepository locationRepository;
	@Autowired
	private RepairCapabilityRepository capabilityRepository;
	@Autowired
	private LocationCapRepository locationCapRepository;
	
	@GetMapping("/locationCapability")
	public List<LocationCapability> getLocationCapability(){	
		LocationCapability locCap = new LocationCapability();
		return locationCapRepository.findAll();
		
	}
		
	@GetMapping("/locationCapability/{id}")
	public LocationCapability getLocationCapabilityById(@PathVariable("id") Integer id) {
		return locationCapRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("locationCapabilityID " + id + " not found"));
	}
	
	@PostMapping("/locationCapability/{repairID}/{locationID}")
	public  Optional<Object> createLocationCapability(@PathVariable("repairID") Integer repairID,
										@PathVariable("locationID") Integer locationID,
										@Valid @RequestBody LocationCapability locationCap) {
		return capabilityRepository.findById(repairID).map(repairCapability -> {
			locationCap.setRepairCapability(repairCapability);
			return locationRepository.findById(locationID).map(location ->{
				locationCap.setLocation(location);
				return locationCapRepository.save(locationCap);	
			});
		});
	}
	
	@PutMapping("/locationCapability/{id}")
	public Optional<Object> updateLocationCapability(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody LocationCapability capRequest) {
		if(!locationCapRepository.existsById(id)) {
	       throw new ResourceNotFoundException("Id " + id + "not found");
	    }
        return locationCapRepository.findById(id).map(locationCap -> {
        	locationCap.setEstablishedDate(capRequest.getEstablishedDate());
        	return locationCapRepository.save(locationCap);	 
        });
    }
	
	@DeleteMapping("/locationCapability/{id}")
	public Optional<Object> deleteLocationCapability(@PathVariable (value="id")Integer id) {
		if(!locationCapRepository.existsById(id)) {
	        throw new ResourceNotFoundException("Id " + id + "Id not found");
	      }
		return locationCapRepository.findById(id).map(locationCap -> {
			locationCapRepository.delete(locationCap);
            return ResponseEntity.ok().build();
        });
    }

}
