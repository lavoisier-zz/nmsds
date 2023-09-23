package br.com.padtec.nmsds.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

@Entity
public class Customer extends PanacheEntityBase {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private Long id;  
	
	@Column
	private String customerShortName;
	
	@Column
	private String customerLongName;
	
	@Column
	private String details;

	public String getCustomerShortName() {
		return customerShortName;
	}

	public void setCustomerShortName(String customerShortName) {
		this.customerShortName = customerShortName;
	}

	public String getCustomerLongName() {
		return customerLongName;
	}

	public void setCustomerLongName(String customerLongName) {
		this.customerLongName = customerLongName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
