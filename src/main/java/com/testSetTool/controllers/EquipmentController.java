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
import com.testSetTool.entities.LocationPOC;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.EquipTypeRepository;
import com.testSetTool.repositories.EquipmentRepository;

@RestController
@RequestMapping("/api")
public class EquipmentController {
	@Autowired
	private EquipmentRepository equipRepository;
	@Autowired
	private  EquipTypeRepository equipmentTypeRepository;
	
	@GetMapping("/equipments")
	public List<Equipment> getEquipments(){	
		return equipRepository.findAll();
	}
	
	@GetMapping("/equipments/{id}")
	public Equipment getLocation(@PathVariable("id") Integer id) {
		return equipRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Equipment Id " + id + " not found"));
	}
	
	@PostMapping("/equipment/{equipmenttypeID}")
	public Optional<Object> createEquipment(@PathVariable("equipmenttypeID") Integer equipmenttypeID,
			                          @Valid @RequestBody Equipment equipment) {
		return equipmentTypeRepository.findById(equipmenttypeID).map(equipmentType -> {
			equipment.setEquipmentType(equipmentType);
			return equipRepository.save(equipment);	
        });
	}
	
	@PutMapping("/equipment/{id}")
	public Optional<Object> updateEquipment(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody Equipment EquipRequest) {	
		if(!equipRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
        return equipRepository.findById(id).map(equipment -> {
        	equipment.setEquipmentname(EquipRequest.getEquipmentname());
        	equipment.setEquipmentPartNumber(EquipRequest.getEquipmentPartNumber());
        	equipment.setDescription(EquipRequest.getDescription());
        	return equipRepository.save(equipment);     	       
        });
    }
	
	@DeleteMapping("/equipment/{id}")
	public Optional<Object> deleteEquipment(@PathVariable (value="id")Integer id) {
		if(!equipRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return equipRepository.findById(id).map(equipment -> {
			equipRepository.delete(equipment);
            return ResponseEntity.ok().build();
        });
    }
	
	  

}
