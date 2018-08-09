package com.testSetTool.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contractType")
public class Contract {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contractTypeId", nullable = false, unique = true)
	private Integer contractTypeId;
	
	@Column(name = "contractType", nullable=false)
	private String contractType;
	
	public Integer getContractTypeId() {
		return contractTypeId;
	}
	public void setContractTypeId(Integer contractTypeId) {
		this.contractTypeId = contractTypeId;
	}
	public String getContractType() {
		return contractType;
	}
	public void setContractType(String contractType) {
		this.contractType = contractType;
	}
	
	public Contract() {}
	
	public Contract(String contractType ) {
		this.contractType = contractType;
		
	}

}
