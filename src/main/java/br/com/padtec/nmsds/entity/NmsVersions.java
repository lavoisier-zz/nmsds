package br.com.padtec.nmsds.entity;

import java.util.Date;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

@Entity
public class NmsVersions extends PanacheEntityBase {
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;  
	
	public void setId(Long id) {
		this.id = id;
	}

	@Column
	private String nmsVersion;
	
	@Column
	private String build;

	@Column
	private String nmsTagVersion;
	
	public String getNmsTagVersion() {
		return nmsTagVersion;
	}

	public void setNmsTagVersion(String nmsTagVersion) {
		this.nmsTagVersion = nmsTagVersion;
	}

	public Long getId() {
		return id;
	}
	
	public String getNmsVersion() {
		return nmsVersion;
	}

	public void setNmsVersion(String nmsVersion) {
		this.nmsVersion = nmsVersion;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}


}
