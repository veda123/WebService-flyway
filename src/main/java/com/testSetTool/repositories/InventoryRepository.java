package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.EquipmentInventory;

public interface InventoryRepository extends JpaRepository<EquipmentInventory, Integer> {

}
