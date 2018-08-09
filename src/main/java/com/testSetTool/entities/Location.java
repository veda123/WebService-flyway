package com.testSetTool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "location")
@JsonPropertyOrder({ "locationID", "locationName", "address", "city", "country","phone","zipcode","timezone" })
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locationID", nullable = false, unique = true)
	private Integer locationID;
	
	@Column(name = "locationname", nullable=false)
	private String locationname;
	
	@Column(name = "address", nullable=false)
	private String address;
	
	@Column(name = "city", nullable=false)
	private String city;

	@Column(name = "phone", nullable = true)
	private String phone;
	
	@Column(name = "zipcode", nullable=false)
	private String zipcode;
	
	@Column(name = "timezone", nullable=false)
	private Double timezone;
	
	@ManyToOne()
    @JoinColumn(name = "countryID", referencedColumnName = "countryID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Country country;
	
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

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
	public Double gettimezone() {
		return timezone;
	}
	public void settimezone(Double timezone) {
		this.timezone = timezone;
	}
	
	public Location() {}

}
