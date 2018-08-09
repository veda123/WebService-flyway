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

import com.testSetTool.entities.BillOfMaterials;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.BillOfMaterialsRepository;
import com.testSetTool.repositories.EquipmentRepository;

@RestController
@RequestMapping("/api")
public class BillOfMaterialsController {
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired 
	private BillOfMaterialsRepository bofRepository;
	
	@GetMapping("/billOfMaterials")
	public List<BillOfMaterials> getMaterials(){	
		return bofRepository.findAll();
	}
	
	@GetMapping("/billOfMaterials/{id}")
	public BillOfMaterials getMaterials(@PathVariable("id") Integer id) {
		return bofRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bill of Materials Id " + id + " not found"));
	}

	@PostMapping("/billOfMaterials/{equipmentID}/{equipmentPartID}")
	public @Valid Optional<Object> createLocation(@PathVariable("equipmentID") Integer equipmentID,
										  @PathVariable("equipmentPartID") Integer equipmentPartID,
										  @Valid @RequestBody BillOfMaterials billOfMaterials) {
		return equipmentRepository.findById(equipmentID).map(equipment -> {
			billOfMaterials.setEquipment(equipment);
			return equipmentRepository.findById(equipmentPartID).map(equipmentPart -> {
				billOfMaterials.setEquipmentPart(equipmentPart);
				return bofRepository.save(billOfMaterials);
			});
		});
	}
	
	@PutMapping("/billOfMaterials/{id}")
	public Optional<Object> updateLocationPOC(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody BillOfMaterials bofRequest) {
		if(!bofRepository.existsById(id)) {
		   throw new ResourceNotFoundException("Id " + id + "not found");
		 }
        return bofRepository.findById(id).map(billOfMaterials -> {
        	billOfMaterials.setManufacture(bofRequest.getManufacture());
        	billOfMaterials.setLrupartnumber(bofRequest.getLrupartnumber());
        	billOfMaterials.setQuantity(bofRequest.getQuantity());
        	return bofRepository.save(billOfMaterials);      
        });
    }
	
	@DeleteMapping("/billOfMaterials/{id}")
	public Optional<Object> deleteBOM(@PathVariable (value="id")Integer id) {
		if(!bofRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return bofRepository.findById(id).map(BillOfMaterials -> {
			bofRepository.delete(BillOfMaterials);
            return ResponseEntity.ok().build();
        });
    }
}
