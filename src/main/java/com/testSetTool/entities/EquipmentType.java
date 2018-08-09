package com.testSetTool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment_type")
public class EquipmentType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equipmenttypeID", nullable = false, unique = true)
	private Integer equipmenttypeID;
	
	@Column(name = "equipmenttype", nullable=false)
	private String equipmenttype;
	
	public Integer getEquipmentTypeID() {
		return equipmenttypeID;
	}
	public void setEquipmentTypeID(Integer equipmentTypeID) {
		this.equipmenttypeID = equipmentTypeID;
	}
	public String getEquipmentType() {
		return equipmenttype;
	}
	public void setEquipmentType(String equipmentType) {
		this.equipmenttype = equipmentType;
	}
	
	 public EquipmentType() {}
	 
	 public EquipmentType(String equipmenttype) {
		 this.equipmenttype = equipmenttype;
		 
	 }


}
