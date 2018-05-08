package com.testSetTool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "locationID", nullable = false, unique = true)
	private Integer locationID;
	
	@Column(name = "locationname", nullable=false)
	private String locationname;
	
	@Column(name = "address", nullable=false)
	private String address;
	
	@Column(name = "city", nullable=false)
	private String city;
	
	@Column(name = "country", nullable=false)
	private String country;
	
	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "zipcode", nullable=false)
	private String zipcode;
	
	@Column(name = "timezone", nullable=false)
	private Integer timezone;
	
	
	public Integer getLocationID() {
		return locationID;
	}
	public void setLocationID(Integer locationID) {
		this.locationID = locationID;
	}
	public String getLocationName() {
		return locationname;
	}
	public void setLocationName(String locationName) {
		this.locationname = locationName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getzipcode() {
		return zipcode;
	}
	public void setzipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Integer gettimezone() {
		return timezone;
	}
	public void settimezone(Integer timezone) {
		this.timezone = timezone;
	}
	
	
public Location() {
		
	}


public Location(String locationName, String address, String city, String country, String phone, String zipcode, int timezone) {
	this.locationname = locationName;
	this.address = address;
	this.city = city;
	this.country = country;
	this.phone = phone;
	this.zipcode = zipcode;
	this.timezone = timezone;
		
}

}
