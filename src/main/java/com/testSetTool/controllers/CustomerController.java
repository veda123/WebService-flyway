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
import com.testSetTool.entities.LocationPOC;
import com.testSetTool.entities.RepairTools;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.ContractRepository;
import com.testSetTool.repositories.CustomerRepository;
import com.testSetTool.repositories.DBFileRepository;
import com.testSetTool.repositories.EquipmentRepository;
import com.testSetTool.repositories.InventoryRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private ContractRepository contractRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private DBFileRepository dbFileRepository;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){	
		return customerRepository.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomersById(@PathVariable("id") Integer id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer Id " + id + " not found"));
	}
	
	@PostMapping("/customer/{inventoryID}/{contractTypeId}/{fileId}")
	public Optional<Object> createCustomer(@PathVariable("inventoryID") Integer inventoryID,
										@PathVariable("contractTypeId") Integer contractTypeId,
										@PathVariable("fileId") String fileId,
										@Valid @RequestBody Customer customer) {
		return inventoryRepository.findById(inventoryID).map(inventory -> {
			customer.setInventory(inventory);
			return contractRepository.findById(contractTypeId).map(contractType ->{
				customer.setContract(contractType);
				return dbFileRepository.findById(fileId).map(dbFile ->{
					customer.setDbFile(dbFile);
					return customerRepository.save(customer);	
				});	
			});
		});
	}
	
	@PutMapping("/customer/{id}")
	public Optional<Object> updateCustomer(@PathVariable (value="id")Integer id,
		      								  @Valid @RequestBody Customer CustomerRequest) {								      
        return customerRepository.findById(id).map(customer -> {
        	customer.setCustomerName(CustomerRequest.getCustomerName());
        	customer.setContractStartDate(CustomerRequest.getContractStartDate());
        	customer.setContractEndDate(CustomerRequest.getContractEndDate());
        	customer.setPointOfContact(CustomerRequest.getPointOfContact());
        	return customerRepository.save(customer);	       
        });
    }
	
	@DeleteMapping("/customer/{id}")
	public Optional<Object> deleteCustomer(@PathVariable (value="id")Integer id) {
		return customerRepository.findById(id).map(customer -> {
			customerRepository.delete(customer);
            return ResponseEntity.ok().build();
        });
    }
	
}
