package com.testSetTool.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testSetTool.entities.Country;
import com.testSetTool.entities.Customer;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.CountryRepository;

@RestController
@RequestMapping("/api")
public class CountryController {
	
	@Autowired
	private CountryRepository countryRepository;
	
	@GetMapping("/countries")
	public List<Country> getCountries(){
		
		return countryRepository.findAll();
	}
	
	@GetMapping("/countries/{id}")
	public Country getCustomersById(@PathVariable("id") Integer id) {
		return countryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Country Id " + id + " not found"));
	}
	

}
