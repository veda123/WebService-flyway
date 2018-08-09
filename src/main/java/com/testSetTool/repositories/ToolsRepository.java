package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.RepairTools;

public interface ToolsRepository extends JpaRepository<RepairTools, Integer> {

}
