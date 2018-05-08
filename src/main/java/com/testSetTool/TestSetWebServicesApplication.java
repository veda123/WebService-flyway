package com.testSetTool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.testSetTool.entities.Location;
import com.testSetTool.repositories.LocationRepository;

@SpringBootApplication
@EnableJpaAuditing
public class TestSetWebServicesApplication implements CommandLineRunner {
	
	@Autowired
	private LocationRepository locationRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TestSetWebServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		locationRepository.save(new Location ("testMCO", "testaddress" ,"testcity","testcountry","testphone","testzip",0));
		
	}
}
