package com.testSetTool.entities;

import java.util.Date;

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
@Table(name = "customer")
@JsonPropertyOrder({ "customerId", "customerName", "inventory", "contractStartDate", "contractEndDate","contractType","dbFile","pointOfContact" })
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customerId", nullable = false, unique = true)
	private Integer customerId;
	
	@Column(name = "customerName", nullable=false)
	private String customerName;
	
	@Column(name = "contractStartDate", nullable=false)
	private String contractStartDate;
	
	@Column(name = "contractEndDate", nullable=false)
	private String contractEndDate;
		
	@Column(name = "pointOfContact", nullable=true)
	private String pointOfContact;
	
	@ManyToOne()
    @JoinColumn(name = "id", referencedColumnName = "id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private DBFile dbFile;
	
	@ManyToOne()
    @JoinColumn(name = "contractTypeId", referencedColumnName = "contractTypeId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Contract contractType;
	
	@ManyToOne()
    @JoinColumn(name = "inventoryId", referencedColumnName = "inventoryId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EquipmentInventory inventory;
	
	public EquipmentInventory getInventory() {
		return inventory;
	}
	public void setInventory(EquipmentInventory inventory) {
		this.inventory = inventory;
	}
	public String getPointOfContact() {
		return pointOfContact;
	}
	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getContractStartDate() {
		return contractStartDate;
	}
	public void setContractStartDate(String contractStartDate) {
		this.contractStartDate = contractStartDate;
	}
	public String getContractEndDate() {
		return contractEndDate;
	}
	public void setContractEndDate(String contractEndDate) {
		this.contractEndDate = contractEndDate;
	}

	public DBFile getDbFile() {
		return dbFile;
	}
	public void setDbFile(DBFile dbFile) {
		this.dbFile = dbFile;
	}
	public Contract getContractType() {
		return contractType;
	}
	public void setContract(Contract contractType) {
		this.contractType = contractType;
	}
	
	public Customer() {}
	
}
