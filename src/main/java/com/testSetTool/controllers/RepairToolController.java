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

import com.testSetTool.entities.Customer;
import com.testSetTool.entities.RepairCapability;
import com.testSetTool.entities.RepairTools;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.EquipmentRepository;
import com.testSetTool.repositories.RepairCapabilityRepository;
import com.testSetTool.repositories.ToolsRepository;

@RestController
@RequestMapping("/api")
public class RepairToolController {

	@Autowired
	private RepairCapabilityRepository capabilityRepository;
	@Autowired
	private ToolsRepository toolRepository;
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@GetMapping("/repairTools")
	public List<RepairTools> getRepairTools(){	
		return toolRepository.findAll();
	}
	
	@GetMapping("/repairTools/{id}")
	public RepairTools getRepairToolById(@PathVariable("id") Integer id) {
		return toolRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Repair Tool Id " + id + " not found"));
	}
	
	@PostMapping("/repairTools/{equipmentID}/{capabilityId}")
	public Optional<Object> createRepairTool(@PathVariable("equipmentID") Integer equipmentID,
										@PathVariable("capabilityId") Integer capabilityId,
										@Valid @RequestBody RepairTools repairTool) {
		return equipmentRepository.findById(equipmentID).map(equipment -> {
			repairTool.setEquipment(equipment);
			return capabilityRepository.findById(capabilityId).map(repairCapability ->{
				repairTool.setRepairCapability(repairCapability);
				return toolRepository.save(repairTool);	
			});
		});
	}
	
	@PostMapping("/repairTools/{capabilityId}")
	public Optional<Object> createRepairToolByQuantity(
										@PathVariable("capabilityId") Integer capabilityId,
										@Valid @RequestBody RepairTools repairTool) {
			return capabilityRepository.findById(capabilityId).map(repairCapability ->{
				repairTool.setRepairCapability(repairCapability);
				return toolRepository.save(repairTool);	
			});		
	}
	
	@PutMapping("/repairTools/{toolId}/{equipmentID}")
	public Optional<Object> updateRepairTool(@PathVariable (value="toolId")Integer toolId,
												@PathVariable("equipmentID") Integer equipmentID,
		      								  @Valid @RequestBody RepairTools toolRequest) {
		if(!toolRepository.existsById(toolId)) {
			throw new ResourceNotFoundException("Id " + toolId + "not found");
		}
        return toolRepository.findById(toolId).map(repairTool -> {
        	repairTool.setQuantity(toolRequest.getQuantity());
        	return equipmentRepository.findById(equipmentID).map(equipment -> {
    			repairTool.setEquipment(equipment);
    			return toolRepository.save(repairTool);	       
        	});
        });
    }
	
	@PutMapping("/repairTools/{toolId}")
	public Optional<Object> updateRepairToolByQuantity(@PathVariable (value="toolId")Integer toolId,
		      								  @Valid @RequestBody RepairTools toolRequest) {
		if(!toolRepository.existsById(toolId)) {
			throw new ResourceNotFoundException("Id " + toolId + "not found");
		}
        return toolRepository.findById(toolId).map(repairTool -> {
        	repairTool.setQuantity(toolRequest.getQuantity());
        	return toolRepository.save(repairTool);	     
        });
    }
	
	@DeleteMapping("/repairTools/{id}")
	public Optional<Object> deleteRepairTool(@PathVariable (value="id")Integer id) {
		if(!toolRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return toolRepository.findById(id).map(repairTool -> {
			toolRepository.delete(repairTool);
            return ResponseEntity.ok().build();
        });
    }
}
