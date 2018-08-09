package com.testSetTool;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.testSetTool.entities.Location;
import com.testSetTool.repositories.LocationRepository;

@SpringBootApplication
@EnableJpaAuditing
public class TestSetWebServicesApplication implements CommandLineRunner {
	
	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TestSetWebServicesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {}
}
