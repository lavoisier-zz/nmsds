package br.com.padtec.nmsds.resource;

import java.util.List;

import br.com.padtec.nmsds.entity.NmsDeployments;
import br.com.padtec.nmsds.entity.NmsVersions;
import br.com.padtec.nmsds.services.NmsVersionsService;
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

public class NmsVersionsResource {

	@Inject
	private NmsVersionsService nmsVersionsResource;
	
	@GET
	public List<NmsVersions> findAll() {  
		System.out.println("GET called http://localhost:8080/nmsds/nmsversions");
	    return NmsVersions.listAll();  
	}
	
	@POST  
	@Transactional  
	public Response create(NmsVersions nmsVersion) {
		System.out.println(nmsVersion.getNmsVersion());
		NmsVersions.persist(nmsVersion);  
	    return Response.ok(nmsVersion).status(201).build();  
	}
	@PUT  
	@Path("{id}")  
	@Transactional  
	public Response update(@PathParam("id") Long id, NmsVersions nmsVersion) {

	    if (nmsVersionsResource.isNmsVersionNameIsNotEmpty(nmsVersion)) {  
	        return Response.ok("NMSVersion was not found").type(MediaType.APPLICATION_JSON_TYPE).build();  
	    }

	    NmsVersions nmsVersionsEntity = nmsVersionsResource.update(id, nmsVersion);

	    return Response.ok(nmsVersionsEntity).build();  
	}
	
	@DELETE  
	@Path("{id}")  
	@Transactional  
	public Response delete(@PathParam("id") Long id) {  
		NmsVersions nmsVersionsEntity = NmsVersions.findById(id);

	    if (nmsVersionsEntity == null) {  
	        throw new WebApplicationException("Version id " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsVersionsEntity.delete();  
	    return Response.status(204).build();  
	}  
	
	
	
	
}
