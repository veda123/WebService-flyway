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
@Table(name = "locationCapability")
@JsonPropertyOrder({ "locationCapID","repairCapability","location", "establishedDate"})
public class LocationCapability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locationCapID", nullable = false, unique = true)
	private Integer locationCapID;
	
	@Column(name = "establishedDate", nullable=false)
	private String establishedDate;
	
	@ManyToOne()
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Location location;
	
	@ManyToOne()
    @JoinColumn(name = "capabilityId", referencedColumnName = "capabilityId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private RepairCapability repairCapability;
	
	public Integer getLocationCapID() {
		return locationCapID;
	}
	public void setLocationCapID(Integer locationCapID) {
		this.locationCapID = locationCapID;
	}
	public String getEstablishedDate() {
		return establishedDate;
	}
	public void setEstablishedDate(String establishedDate) {
		this.establishedDate = establishedDate;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public RepairCapability getRepairCapability() {
		return repairCapability;
	}
	public void setRepairCapability(RepairCapability repairCapability) {
		this.repairCapability = repairCapability;
	}

}
