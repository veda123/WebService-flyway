package com.testSetTool.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSetTool.entities.Contract;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.ContractRepository;

@RestController
@RequestMapping("/api")
public class ContractController {
	
	@Autowired
	private  ContractRepository contractRepository;
	
	@GetMapping("/contractType")
	public List<Contract> getAll(){		
		return contractRepository.findAll();
	}

	@GetMapping("/contractType/{id}")
	public Contract getContract(@PathVariable("id") Integer contractId) {
		return contractRepository.findById(contractId).orElseThrow(() -> new ResourceNotFoundException("locationPOCID " + contractId + " not found"));
	}
	
}
