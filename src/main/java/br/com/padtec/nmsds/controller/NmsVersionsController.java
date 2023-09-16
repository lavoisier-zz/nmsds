package br.com.padtec.nmsds.controller;

import br.com.padtec.nmsds.entity.NmsVersions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class NmsVersionsController {
	
	public NmsVersions update(Long id, NmsVersions nmsVersions) {  
	    NmsVersions nmsEntity = NmsVersions.findById(id);

	    if (nmsEntity == null) {  
	        throw new WebApplicationException("NmsVersions with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsEntity.setNmsVersion(nmsVersions.getNmsVersion());  
	    nmsEntity.setBuild(nmsVersions.getBuild());

	    return nmsEntity;  
	}

	/**  
	 * This method is main purpose to show simple "Business" example  
	 * @param nmsVersions  
	 * @return  
	 */  
	public boolean isNmsVersionNameIsNotEmpty(NmsVersions nmsVersions) {  
	    return nmsVersions.getNmsVersion().isEmpty();  

	}
}
