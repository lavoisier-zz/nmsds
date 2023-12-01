package br.com.padtec.nmsds.services;

import br.com.padtec.nmsds.entity.NmsDeployments;
import br.com.padtec.nmsds.entity.NmsVersions;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

@ApplicationScoped

public class NmsVersionsService {
	
	public NmsVersions update(Long id, NmsVersions nmsVersions) {  
		NmsVersions nmsVersionEntity = NmsVersions.findById(id);

	    if (nmsVersionEntity == null) {  
	        throw new WebApplicationException("NmsVersions with id of " + id + " does not exist.", Response.Status.NOT_FOUND);  
	    }

	    nmsVersionEntity.setId(id);
	    nmsVersionEntity.setNmsVersion(nmsVersions.getNmsVersion());  
	    nmsVersionEntity.setBuild(nmsVersions.getBuild());

	    return nmsVersionEntity;  
	}

	/**  
	 * This method is main purpose to show simple "Business" example  
	 * @param nmsDeploymentVersions  
	 * @return  
	 */  
	public boolean isNmsVersionNameIsNotEmpty(NmsVersions nmsVersions) {  
	    return nmsVersions.getNmsVersion().isEmpty();  

	}

}
