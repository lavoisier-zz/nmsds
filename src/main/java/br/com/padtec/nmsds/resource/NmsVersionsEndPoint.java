package br.com.padtec.nmsds.resource;

import java.util.List;

import br.com.padtec.nmsds.controller.NmsVersionsController;
import br.com.padtec.nmsds.entity.NmsDeploymentEntity;
import br.com.padtec.nmsds.entity.NmsVersionsEntity;
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

@Path("/nmsds/nmsversions")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class NmsVersionsEndPoint {

	@Inject
	private NmsVersionsController nmsVersionsController;
	
	@GET
	public List<NmsVersionsEntity> findAll() {  
	    return NmsVersionsEntity.listAll();  
	}
	
	@POST  
	@Transactional  
	public Response create(NmsVersionsEntity nmsVersion) {
		System.out.println(nmsVersion.getNmsVersion());
		NmsVersionsEntity.persist(nmsVersion);  
	    return Response.ok(nmsVersion).status(201).build();  
	}
	@PUT  
	@Path("{id}")  
	@Transactional  
	public Response update(@PathParam("id") Long id, NmsVersionsEntity nmsVersion) {

	    if (nmsVersionsController.isNmsVersionNameIsNotEmpty(nmsVersion)) {  
	        return Response.ok("NMSVersion was not found").type(MediaType.APPLICATION_JSON_TYPE).build();  
	    }

	    NmsVersionsEntity nmsVersionsEntity = nmsVersionsController.update(id, nmsVersion);

	    return Response.ok(nmsVersionsEntity).build();  
	}
	
	@DELETE  
	@Path("{id}")  
	@Transactional  
	public Response delete(@PathParam("id") Long id) {  
		NmsVersionsEntity nmsVersionsEntity = NmsVersionsEntity.findById(id);

	    if (nmsVersionsEntity == null) {  
	        throw new WebApplicationException("Version id " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsVersionsEntity.delete();  
	    return Response.status(204).build();  
	}  
	
	
	
	
}
