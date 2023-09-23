package br.com.padtec.nmsds.controller;

import br.com.padtec.nmsds.entity.NmsDeploymentEntity;
import br.com.padtec.nmsds.entity.NmsVersionsEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class NmsVersionsController {
	
	public NmsVersionsEntity update(Long id, NmsVersionsEntity nmsVersions) {  
		NmsVersionsEntity nmsVersionEntity = NmsVersionsEntity.findById(id);

	    if (nmsVersionEntity == null) {  
	        throw new WebApplicationException("NmsVersions with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsVersionEntity.setNmsVersion(nmsVersions.getNmsVersion());  
	    nmsVersionEntity.setBuildDate(nmsVersions.getBuildDate());

	    return nmsVersionEntity;  
	}

	/**  
	 * This method is main purpose to show simple "Business" example  
	 * @param nmsDeploymentVersions  
	 * @return  
	 */  
	public boolean isNmsVersionNameIsNotEmpty(NmsVersionsEntity nmsVersions) {  
	    return nmsVersions.getNmsVersion().isEmpty();  

	}

}
