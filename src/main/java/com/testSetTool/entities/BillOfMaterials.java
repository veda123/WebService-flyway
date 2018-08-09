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
@Table(name = "billOfMaterials")
@JsonPropertyOrder({ "billID", "equipment","lrupartnumber","equipmentPart","manufacture","quantity"})
public class BillOfMaterials {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "billID", nullable = false, unique = true)
	private Integer billID;
	
	@Column(name = "lrupartnumber", nullable=false)
	private String lrupartnumber;
	
	@Column(name = "manufacture", nullable=false)
	private String manufacture;
	
	@Column(name = "quantity", nullable=false)
	private Integer quantity;
	
	@ManyToOne()
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmentID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Equipment equipment;
	
	@ManyToOne()
    @JoinColumn(name = "equipmentPartID", referencedColumnName = "equipmentID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Equipment equipmentPart;
	
	public Equipment getEquipmentPart() {
		return equipmentPart;
	}
	public void setEquipmentPart(Equipment equipmentPart) {
		this.equipmentPart = equipmentPart;
	}
	public String getLrupartnumber() {
		return lrupartnumber;
	}
	public void setLrupartnumber(String lrupartnumber) {
		this.lrupartnumber = lrupartnumber;
	}
	public Integer getBillID() {
		return billID;
	}
	public void setBillID(Integer billID) {
		this.billID = billID;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

}
