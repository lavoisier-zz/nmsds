package br.com.padtec.nmsds.entity;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public class NmsDeployment extends PanacheEntityBase {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;  

	@Column  
	private String nmsversion;  

	@Column  
	private String build;  

	@Column  
	private String customername;

	public String getNmsVersion() {
		// TODO Auto-generated method stub
		return nmsversion;
	}

	public void setNmsVersion(String nmsVersion2) {
		// TODO Auto-generated method stub
		nmsversion = new String(nmsVersion2);
	}

	public String getBuild() {
		// TODO Auto-generated method stub
		return build;
	}

	public void setBuild(String build2) {
		// TODO Auto-generated method stub
		build = new String(build2);
		
	}
	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}



	
}
