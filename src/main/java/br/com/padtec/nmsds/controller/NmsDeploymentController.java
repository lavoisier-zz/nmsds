package br.com.padtec.nmsds.controller;

import br.com.padtec.nmsds.entity.NmsDeploymentEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class NmsDeploymentController {
	
	public NmsDeploymentEntity update(Long id, NmsDeploymentEntity nmsDeploymentVersions) {  
	    NmsDeploymentEntity nmsEntity = NmsDeploymentEntity.findById(id);

	    if (nmsEntity == null) {  
	        throw new WebApplicationException("NmsVersions with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsEntity.setNmsVersion(nmsDeploymentVersions.getNmsVersion());  
	    nmsEntity.setBuild(nmsDeploymentVersions.getBuild());
	    System.out.println("Passei aqui");

	    return nmsEntity;  
	}

	/**  
	 * This method is main purpose to show simple "Business" example  
	 * @param nmsDeploymentVersions  
	 * @return  
	 */  
	public boolean isNmsVersionNameIsNotEmpty(NmsDeploymentEntity nmsDeploymentVersions) {  
	    return nmsDeploymentVersions.getNmsVersion().isEmpty();  

	}
}
