package com.testSetTool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "countryID", nullable = false, unique = true)
	private Integer countryID;
	
	@Column(name = "shortname", nullable=false)
	private String shortname;
	
	@Column(name = "countryname", nullable=false)
	private String countryname;

	public Integer getId() {
		return countryID;
	}

	public void setId(Integer id) {
		this.countryID = id;
	}

	public String getShortName() {
		return shortname;
	}

	public void setShortName(String shortName) {
		this.shortname = shortName;
	}

	public String getCountryName() {
		return countryname;
	}

	public void setCountryName(String countryName) {
		this.countryname = countryName;
	}
	
	public Country(){}
	
	public Country(String shortname, String countryname ) {
		this.shortname = shortname;
		this.countryname = countryname;
		
	}

}
