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

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name = "location_poc")
@JsonPropertyOrder({ "id","location", "contactName", "email", "phone", "country","title" })
public class LocationPOC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	private Integer id;
	
	@Column(name = "contactname", nullable=false)
	private String contactname;
	
	@Column(name = "email", nullable=true)
	private String email;
	
	@Column(name = "phone", nullable=true)
	private String phone;
	
	@Column(name = "title", nullable=true)
	private String title;
	
	@ManyToOne()
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Location location;

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	public LocationPOC() {}

	public LocationPOC(String  contactName , String email, String phone, String title, Location location) {
		this.contactname = contactName;
		this.email = email;
		this.phone = phone;
		this.title = title;
		this.location = location;
		
	}

}
