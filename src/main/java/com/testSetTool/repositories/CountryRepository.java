package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
