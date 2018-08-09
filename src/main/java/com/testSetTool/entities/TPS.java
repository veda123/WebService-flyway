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
@Table(name = "tps")
@JsonPropertyOrder({ "tpsId", "repairCapability", "tpsName", "tpsPart", "version","releaseDate","checksum","checksumType","comments","releaseNotes"})
public class TPS {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tpsId", nullable = false, unique = true)
	private Integer tpsId;
	
	@Column(name = "tpsPart", nullable=true)
	private String tpsPart;
	
	@Column(name = "version", nullable=false)
	private String version;
	
	@Column(name = "releaseDate", nullable=false)
	private String releaseDate;
	
	@Column(name = "checksum", nullable=false)
	private String checksum;
	
	@Column(name = "checksumType", nullable=false)
	private String checksumType;
	
	@Column(name = "comments", nullable=true)
	private String comments;
	
	@Column(name = "releaseNotes", nullable=true)
	private String releaseNotes;
	
	@Column(name = "tpsName", nullable=false)
	private String tpsName;
	
	public String getTpsPart() {
		return tpsPart;
	}
	public void setTpsPart(String tpsPart) {
		this.tpsPart = tpsPart;
	}
	public String getTpsName() {
		return tpsName;
	}
	public void setTpsName(String tpsName) {
		this.tpsName = tpsName;
	}
	@ManyToOne()
    @JoinColumn(name = "capabilityId", referencedColumnName = "capabilityId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private RepairCapability repairCapability;
	
	public Integer getTpsId() {
		return tpsId;
	}
	public void setTpsId(Integer tpsId) {
		this.tpsId = tpsId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getChecksumType() {
		return checksumType;
	}
	public void setChecksumType(String checksumType) {
		this.checksumType = checksumType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getReleaseNotes() {
		return releaseNotes;
	}
	public void setReleaseNotes(String releaseNotes) {
		this.releaseNotes = releaseNotes;
	}
	public RepairCapability getRepairCapability() {
		return repairCapability;
	}
	public void setRepairCapability(RepairCapability repairCapability) {
		this.repairCapability = repairCapability;
	}
}
