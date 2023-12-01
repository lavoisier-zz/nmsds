package br.com.padtec.nmsds.services;

import br.com.padtec.nmsds.entity.Customer;
import br.com.padtec.nmsds.entity.NmsDeployments;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class CustomerService {
	

	public Customer update(Long id, Customer customer) {  
		Customer customerEntity = Customer.findById(id);

	    if (customerEntity == null) {  
	        throw new WebApplicationException("Customer with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }
	    
	    customerEntity.setCustomerLongName(customer.getCustomerLongName());
	    customerEntity.setDetails(customer.getDetails());
	    customerEntity.setCustomerShortName(customer.getCustomerShortName());
	    customerEntity.setId(id);
	
	    return customerEntity;  
	}

	public boolean isCustomerShortNameNotEmpty(Customer customer) {  
	    return customer.getCustomerShortName().isEmpty();

	}
	
	public Customer getCustomerById(long id) {
		Customer customerEntity = Customer.findById(id);

	    if (customerEntity == null) {  
	        throw new WebApplicationException("Customer with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }
		return customerEntity;
	}

	public Customer addNew(Customer customer) {
		//Customer.persist(customer);
		customer.persist();
		return customer;
	}

}
