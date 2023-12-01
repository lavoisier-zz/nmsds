package br.com.padtec.nmsds.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
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
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerShortName=" + customerShortName + ", customerLongName="
				+ customerLongName + ", details=" + details + "]";
	}

	@Column
	private String details;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

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
