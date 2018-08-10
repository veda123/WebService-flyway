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

@Entity
@Table(name = "repair_capability")
public class RepairCapability {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "capabilityId", nullable = false, unique = true)
	private Integer capabilityId;

	@Column(name = "lrupartnumber", nullable=false)
	private String lrupartnumber;

	@Column(name = "lrudescription", nullable=false)
	private String lrudescription;

	@Column(name = "CMM", nullable=false)
	private String CMM;

	@ManyToOne()
	@JoinColumn(name = "equipmentId", referencedColumnName = "equipmentID")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Equipment equipment;

	public String getLrudescription() {
		return lrudescription;
	}
	public void setLrudescription(String lrudescription) {
		this.lrudescription = lrudescription;
	}
	public Integer getCapabilityId() {
		return capabilityId;
	}
	public void setCapabilityId(Integer capabilityId) {
		this.capabilityId = capabilityId;
	}
	public String getLRUPartnumber() {
		return lrupartnumber;
	}
	public void setLRUPartNumber(String lrupartnumber) {
		this.lrupartnumber = lrupartnumber;
	}
	public String getCMM() {
		return CMM;
	}
	public void setCMM(String cMM) {
		CMM = cMM;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public RepairCapability() {}

}
