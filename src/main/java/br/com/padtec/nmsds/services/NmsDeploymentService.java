package br.com.padtec.nmsds.services;

import br.com.padtec.nmsds.entity.NmsDeployments;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class NmsDeploymentService {
	
	public NmsDeployments update(Long id, NmsDeployments nmsDeploymentVersions) {  
	    NmsDeployments nmsDeployments = NmsDeployments.findById(id);

	    if (nmsDeployments == null) {  
	        throw new WebApplicationException("Nms Deployments with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    
	    nmsDeployments.setNmsVersion(nmsDeploymentVersions.getNmsVersion());  
	    nmsDeployments.setBuild(nmsDeploymentVersions.getBuild());
	    System.out.println("Passei aqui");

	    return nmsDeployments;  
	}

	/**  
	 * This method is main purpose to show simple "Business" example  
	 * @param nmsDeploymentVersions  
	 * @return  
	 */  
	public boolean isNmsVersionNameIsNotEmpty(NmsDeployments nmsDeploymentVersions) {  
	    return nmsDeploymentVersions.getNmsVersion().isEmpty();  

	}
}
