package br.com.padtec.nmsds.resource;

import java.util.Iterator;
import java.util.List;

import br.com.padtec.nmsds.entity.Customer;
import br.com.padtec.nmsds.entity.NmsDeployments;
import br.com.padtec.nmsds.services.CustomerService;
import br.com.padtec.nmsds.services.NmsDeploymentService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/nmsds/customers")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class CustomerResource {


	@Inject
	private CustomerService customerService;
	
	@GET
	public List<Customer> findAll() {  
	    return Customer.listAll();  
	}
	
	@GET
	@Path("{id}")
	public Customer getCustomerId(@PathParam("id") Long id) {  
			//Customer nmsVersionsEntity = customerService.update(id, customer);
		System.out.println("getCustomerId(@PathParam(\"id\") Long id) {  ");
		return Customer.findById(id);
	}

	
	@POST
	@Transactional  
	public Response create(Customer customer) {
		System.out.println("POST called at http://localhost:8080/nmsds/customer");
		System.out.println("Customer to be add is :" + customer.toString());
		
		/*
		 * List<Customer> customerList = Customer.listAll(); long maxId; maxId = 0; if
		 * (customerList != null && !customerList.isEmpty()) { for (Iterator iterator =
		 * customerList.iterator(); iterator.hasNext();) { Customer customerLocal =
		 * (Customer) iterator.next(); if (maxId < customerLocal.getId()) { maxId =
		 * customerLocal.getId(); } else { // do nothing, maxId is already the Maximum
		 * Id } } } System.out.println("maxId = " + maxId); customer.setId(maxId+1);
		 */
		Customer customerEntity = customerService.addNew(customer);
		//Customer.persist(customer);
		return Response.ok().build(); 
	//	return Response.ok(customer).status(201).build();  
	}
	
	@PUT  
	@Path("{id}")
	@Transactional
	public Response update(@PathParam("id") Long id, Customer customer) {	
		System.out.println("customerService.isCustomerShortNameNotEmpty(customer)" + customerService.isCustomerShortNameNotEmpty(customer));
	    if (customerService.isCustomerShortNameNotEmpty(customer)) {  
	        return Response.ok("Customer was not found").type(MediaType.APPLICATION_JSON_TYPE).build();  
	    }

	    System.out.println("@Put was called for Customer Id == "+ id);
	    Customer customerEntity = customerService.update(id, customer);

	    return Response.ok(customerEntity).build();  
	}
	
	@DELETE  
	@Path("{id}")  
	@Transactional  
	public Response delete(@PathParam("id") Long id) {  
		Customer customer = Customer.findById(id);

	    if (customer == null) {  
	        throw new WebApplicationException("Customer with id " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    customer.delete();  
	    //return Response.status(204).build();
	    return Response.ok().build();  
	}  
	
	
	
	
	
}
