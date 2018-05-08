package com.testSetTool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location_poc")
public class LocationPOC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ipocid", nullable = false, unique = true)
	private Integer ipocid;
	
	@Column(name = "contactName", nullable=false)
	private String contactname;
	
	@Column(name = "email", nullable=true)
	private String email;
	
	@Column(name = "phone", nullable=true)
	private String phone;
	
	@Column(name = "title", nullable=false)
	private String title;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "locationID", nullable = false)
	 @JsonIgnore
	private Location locationID;



	public Integer getIpocid() {
		return ipocid;
	}

	public void setIpocid(Integer ipocid) {
		this.ipocid = ipocid;
	}

	public String getContactName() {
		return contactname;
	}

	public void setContactName(String contactname) {
		this.contactname = contactname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Location getLocationID() {
		return locationID;
	}

	public void setLocationID(Location locationID) {
		this.locationID = locationID;
	}
	
	
	public LocationPOC() {
		
	}

	public LocationPOC(String  contactname , String email, String phone, String title, Location locationID) {
		this.contactname = contactname;
		this.email = email;
		this.phone = phone;
		this.title = title;
		this.locationID = locationID;
		
	}

}
