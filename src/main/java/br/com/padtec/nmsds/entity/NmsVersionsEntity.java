package br.com.padtec.nmsds.entity;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

public class NmsVersionsEntity extends PanacheEntityBase {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;  
	
	@Column
	private String nmsVersion;
	
	@Column
	private String shortNmsVersion;
	
	@Column
	private Date buildDate;

	public String getNmsVersion() {
		return nmsVersion;
	}

	public void setNmsVersion(String nmsVersion) {
		this.nmsVersion = nmsVersion;
	}

	public String getShortNmsVersion() {
		return shortNmsVersion;
	}

	public void setShortNmsVersion(String shortNmsVersion) {
		this.shortNmsVersion = shortNmsVersion;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public void setBuildDate(Date buildDate) {
		this.buildDate = buildDate;
	}

}
