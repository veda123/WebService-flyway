package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}
