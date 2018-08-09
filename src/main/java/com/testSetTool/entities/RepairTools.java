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
@Table(name = "repair_tools")
@JsonPropertyOrder({ "repairToolId", "repairCapability", "equipment", "quantity"})
public class RepairTools {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "repairToolId", nullable = false, unique = true)
	private Integer repairToolId;
	
	@Column(name = "quantity", nullable=false)
	private Integer quantity;
	
	@ManyToOne()
    @JoinColumn(name = "capabilityId", referencedColumnName = "capabilityId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private RepairCapability repairCapability;
	
	@ManyToOne()
    @JoinColumn(name = "equipmentId", referencedColumnName = "equipmentID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Equipment equipment;
	
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Integer getRepairToolId() {
		return repairToolId;
	}
	public void setRepairToolId(Integer repairToolId) {
		this.repairToolId = repairToolId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public RepairCapability getRepairCapability() {
		return repairCapability;
	}
	public void setRepairCapability(RepairCapability repairCapability) {
		this.repairCapability = repairCapability;
	}

}
