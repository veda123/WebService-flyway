package com.testSetTool.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testSetTool.entities.DBFile;

public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
