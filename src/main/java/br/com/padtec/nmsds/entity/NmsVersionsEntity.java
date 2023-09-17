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

}
