package br.com.padtec.nmsds.resource;

import java.util.List;

import br.com.padtec.nmsds.entity.NmsDeployments;
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



@Path("/nmsds/deployments")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class NmsDeploymentsResource {

	/*
	 * @GET // @Produces(MediaType.TEXT_PLAIN) public String hello() { return
	 * "Ola Davi, como vai você \n está tudo bem ? \n Nos vamos almocar onde ?"; }
	 */

	@Inject
	private NmsDeploymentService nmsDeploymentResource;
	
	@GET
	public List<NmsDeployments> findAll() {  
	    return NmsDeployments.listAll();  
	}
	
	@POST  
	@Transactional  
	public Response create(NmsDeployments nmsVersion) {
		System.out.println(nmsVersion.getNmsVersion());
		NmsDeployments.persist(nmsVersion);  
	    return Response.ok(nmsVersion).status(201).build();  
	}
	
	@PUT  
	@Path("{id}")  
	@Transactional  
	public Response update(@PathParam("id") Long id, NmsDeployments nmsVersion) {

	    if (nmsDeploymentResource.isNmsVersionNameIsNotEmpty(nmsVersion)) {  
	        return Response.ok("Food was not found").type(MediaType.APPLICATION_JSON_TYPE).build();  
	    }

	    NmsDeployments nmsVersionsEntity = nmsDeploymentResource.update(id, nmsVersion);

	    return Response.ok(nmsVersionsEntity).build();  
	}
	
	@DELETE  
	@Path("{id}")  
	@Transactional  
	public Response delete(@PathParam("id") Long id) {  
		NmsDeployments nmsVersionsEntity = NmsDeployments.findById(id);

	    if (nmsVersionsEntity == null) {  
	        throw new WebApplicationException("Food with id " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsVersionsEntity.delete();  
	    return Response.status(204).build();  
	}  
	
	

}
