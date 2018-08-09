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
import com.testSetTool.entities.Equipment;
import com.testSetTool.entities.EquipmentInventory;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.EquipmentRepository;
import com.testSetTool.repositories.InventoryRepository;
import com.testSetTool.repositories.LocationRepository;

@RestController
@RequestMapping("/api")
public class InventoryController {
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("/inventory")
	public List<EquipmentInventory> getInventory(){	
		return inventoryRepository.findAll();
	}
	
	@GetMapping("/inventory/{id}")
	public EquipmentInventory getInventory(@PathVariable("id") Integer id) {
		return inventoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Inventory Id " + id + " not found"));
	}
	
	@PostMapping("/inventory/{equipmentID}/{locationID}")
	public Optional<Object> createInventory(@PathVariable("equipmentID") Integer equipmentID,
										@PathVariable("locationID") Integer locationID,
										@Valid @RequestBody EquipmentInventory inventory) {
		return equipmentRepository.findById(equipmentID).map(equipment -> {
			inventory.setEquipment(equipment);
			return locationRepository.findById(locationID).map(location ->{
				inventory.setLocation(location);
				return inventoryRepository.save(inventory);	
			});
		});
	}
	
	@PutMapping("/inventory/{id}")
	public Optional<Object> updateInventory(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody EquipmentInventory InventoryRequest) {
		if(!inventoryRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
        return inventoryRepository.findById(id).map(inventory -> {
        	inventory.setManufactureDate(InventoryRequest.getManufactureDate());
        	inventory.setOwner(InventoryRequest.getOwner());
        	inventory.setOwnership(InventoryRequest.getOwnership());
        	inventory.setRev(InventoryRequest.getRev());
        	inventory.setStatus(InventoryRequest.getStatus());
        	inventory.setSerialNumber(InventoryRequest.getSerialNumber());
        	return inventoryRepository.save(inventory);	       
        });
    }
	
	@DeleteMapping("/inventory/{id}")
	public Optional<Object> deleteInventory(@PathVariable (value="id")Integer id) {
		if(!inventoryRepository.existsById(id)) {
			throw new ResourceNotFoundException("Id " + id + "not found");
		}
		return inventoryRepository.findById(id).map(inventory -> {
			inventoryRepository.delete(inventory);
            return ResponseEntity.ok().build();
        });
    }

}
