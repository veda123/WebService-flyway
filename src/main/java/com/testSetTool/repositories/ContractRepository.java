package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.Contract;

public interface ContractRepository extends JpaRepository<Contract, Integer> {

}
