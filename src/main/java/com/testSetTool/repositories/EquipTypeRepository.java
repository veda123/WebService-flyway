package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.EquipmentType;

public interface EquipTypeRepository extends JpaRepository<EquipmentType, Integer> {

}
