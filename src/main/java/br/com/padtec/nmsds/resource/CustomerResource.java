package br.com.padtec.nmsds.resource;

import java.util.List;

import br.com.padtec.nmsds.controller.CustomerService;
import br.com.padtec.nmsds.controller.NmsDeploymentController;
import br.com.padtec.nmsds.entity.Customer;
import br.com.padtec.nmsds.entity.NmsDeploymentEntity;
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
	
	@POST  
	@Transactional  
	public Response create(Customer customer) {
		System.out.println(customer.getCustomerLongName());
		Customer.persist(customer);  
	    return Response.ok(customer).status(201).build();  
	}
	
	@PUT  
	@Path("{id}")  
	@Transactional  
	public Response update(@PathParam("id") Long id, Customer customer) {

	    if (customerService.isCustomerShortNameNotEmpty(customer)) {  
	        return Response.ok("Food was not found").type(MediaType.APPLICATION_JSON_TYPE).build();  
	    }

	    Customer nmsVersionsEntity = customerService.update(id, customer);

	    return Response.ok(nmsVersionsEntity).build();  
	}
	
	@DELETE  
	@Path("{id}")  
	@Transactional  
	public Response delete(@PathParam("id") Long id) {  
		Customer customer = Customer.findById(id);

	    if (customer == null) {  
	        throw new WebApplicationException("Food with id " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    customer.delete();  
	    return Response.status(204).build();  
	}  
	
	
	
	
	
}
