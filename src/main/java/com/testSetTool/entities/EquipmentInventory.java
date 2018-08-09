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
@Table(name = "equipmentInventory")
@JsonPropertyOrder({ "inventoryId", "equipment", "serialNumber", "rev", "manufactureDate","status","owner","ownership","location" })
public class EquipmentInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inventoryId", nullable = false, unique = true)
	private Integer inventoryId;
	
	@Column(name = "serialNumber", nullable=false)
	private String serialNumber;
	
	@Column(name = "rev", nullable=true)
	private String rev;
	
	@Column(name = "manufactureDate", nullable=false)
	private String manufactureDate;
	
	@Column(name = "status", nullable=false)
	private String status;
	
	@Column(name = "owner", nullable=false)
	private String owner;
	
	@Column(name = "ownership", nullable=false)
	private String ownership;
	
	@ManyToOne()
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmentID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Equipment equipment;
	
	@ManyToOne()
    @JoinColumn(name = "locationID", referencedColumnName = "locationID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Location location;
	
	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getRev() {
		return rev;
	}
	public void setRev(String rev) {
		this.rev = rev;
	}
	public String getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(String manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public EquipmentInventory() {}
	

}
