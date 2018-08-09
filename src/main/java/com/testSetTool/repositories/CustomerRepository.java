package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
