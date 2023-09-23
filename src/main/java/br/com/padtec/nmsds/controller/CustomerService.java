package br.com.padtec.nmsds.controller;

import br.com.padtec.nmsds.entity.Customer;
import br.com.padtec.nmsds.entity.NmsDeploymentEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class CustomerService {
	

	public Customer update(Long id, Customer customer) {  
		Customer customerEntity = Customer.findById(id);

	    if (customerEntity == null) {  
	        throw new WebApplicationException("NmsVersions with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    customerEntity.setCustomerShortName(customer.getCustomerShortName());
	
	    return customerEntity;  
	}

	public boolean isCustomerShortNameNotEmpty(Customer customer) {  
	    return customer.getCustomerShortName().isEmpty();

	}


}
