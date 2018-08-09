package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.BillOfMaterials;

public interface BillOfMaterialsRepository  extends JpaRepository<BillOfMaterials, Integer> {

}
