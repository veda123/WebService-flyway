package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.LocationCapability;

public interface LocationCapRepository extends JpaRepository<LocationCapability, Integer>  {

}
