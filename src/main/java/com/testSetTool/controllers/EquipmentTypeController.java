package com.testSetTool.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSetTool.entities.EquipmentType;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.EquipTypeRepository;

@RestController
@RequestMapping("/api")
public class EquipmentTypeController {
	
	@Autowired
	private  EquipTypeRepository equipmentTypeRepository;
	
	@GetMapping("/equipmentType")
	public List<EquipmentType> getAll(){		
		return equipmentTypeRepository.findAll();
	}
	
	@GetMapping("/equipmentType/{equipmentTypeID}")
	public EquipmentType getEquipment(@PathVariable("equipmentTypeID") Integer equipmentTypeID) {
		return equipmentTypeRepository.findById(equipmentTypeID).orElseThrow(() -> new ResourceNotFoundException("EquipmentType Id " + equipmentTypeID + " not found"));
	}
	

}
