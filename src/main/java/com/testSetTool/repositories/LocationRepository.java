package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.Location;

public interface LocationRepository extends JpaRepository<Location,Integer>{

}
