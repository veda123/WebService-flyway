package com.testSetTool.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testSetTool.entities.TPS;
import com.testSetTool.entities.User;
import com.testSetTool.exception.ResourceNotFoundException;
import com.testSetTool.repositories.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/users/{id}")
	public User getUserDetailsbyId(@PathVariable("id") Long id) {
		return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("UserName " + id + " not found"));
	}
	
	@GetMapping("/users")
	public User getUserDetailsbyName(@RequestParam("name")  String name) {
		return userRepository.findByUsername(name).orElseThrow(() -> new ResourceNotFoundException("UserName " + name + " not found"));
	}
}
