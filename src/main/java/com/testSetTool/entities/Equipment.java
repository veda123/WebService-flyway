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
@Table(name = "equipment")
@JsonPropertyOrder({ "equipmentID", "equipmentname", "equipmentPartNumber", "description", "equipmentType"})
public class Equipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipmentID", nullable = false, unique = true)
	private Integer equipmentID;
	@Column(name = "equipmentname", nullable=false)
	private String equipmentname;
	@Column(name = "equipmentpartnumber", nullable=false)
	private String equipmentpartnumber;
	@Column(name = "description", nullable=false)
	private String description;
	
	@ManyToOne()
    @JoinColumn(name = "equipmenttypeID", referencedColumnName = "equipmenttypeID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private EquipmentType equipmentType;
	
	public Integer getEquipmentID() {
		return equipmentID;
	}
	public void setEquipmentID(Integer equipmentID) {
		this.equipmentID = equipmentID;
	}
	public String getEquipmentname() {
		return equipmentname;
	}
	public void setEquipmentname(String equipmentname) {
		this.equipmentname = equipmentname;
	}
	public String getEquipmentPartNumber() {
		return equipmentpartnumber;
	}
	public void setEquipmentPartNumber(String equipmentPartNumber) {
		this.equipmentpartnumber = equipmentPartNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public EquipmentType getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}
	
	public Equipment() {}
	
	public Equipment(String equipmentname, String equipmentpartnumber, String description,EquipmentType equipmentType) {
		this.equipmentname = equipmentname;
		this.equipmentpartnumber = equipmentpartnumber;
		this.description = description;
		this.equipmentType = equipmentType;
		
	}
	
}
