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

import com.testSetTool.entities.Equipment;
import com.testSetTool.entities.EquipmentInventory;
import com.testSetTool.entities.LocationPOC;
import com.testSetTool.entities.RepairCapability;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.EquipmentRepository;
import com.testSetTool.repositories.RepairCapabilityRepository;

@RestController
@RequestMapping("/api")
public class RepairCapabilityController {
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private RepairCapabilityRepository capabilityRepository;

	@GetMapping("/repairCapability")
	public List<RepairCapability> getRepairCapability(){
		return capabilityRepository.findAll();
	}

	@GetMapping("/repairCapability/{id}")
	public RepairCapability getRepairCapabilityById(@PathVariable("id") Integer id) {
		return capabilityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("RepairCapability Id " + id + " not found"));
	}

	@PostMapping("/repairCapability/{equipmentID}")
	public Optional<Object> createRepairCapability(@PathVariable("equipmentID") Integer equipmentID,
												   @Valid @RequestBody RepairCapability repairCapability) {
		return equipmentRepository.findById(equipmentID).map(equipment-> {
			repairCapability.setEquipment(equipment);
			return capabilityRepository.save(repairCapability);
		});
	}

	@PutMapping("/repairCapability/{id}")
	public Optional<Object> updateRepairCapability(@PathVariable (value="id")Integer id,
												   @Valid @RequestBody RepairCapability CapabilityRequest) {
		if(!capabilityRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return capabilityRepository.findById(id).map(repairCapability -> {
			repairCapability.setCMM(CapabilityRequest.getCMM());
			repairCapability.setLRUPartNumber(CapabilityRequest.getLRUPartnumber());
			repairCapability.setLrudescription(CapabilityRequest.getLrudescription());
			return capabilityRepository.save(repairCapability);
		});
	}

	@DeleteMapping("/repairCapability/{id}")
	public Optional<Object> deleteRepairCapability(@PathVariable (value="id")Integer id) {
		if(!capabilityRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return capabilityRepository.findById(id).map(repairCapability -> {
			capabilityRepository.delete(repairCapability);
			return ResponseEntity.ok().build();
		});
	}


}