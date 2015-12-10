package br.poo.com.reqagile.service;
import java.util.List;

import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.Requirement;
import br.poo.com.reqagile.model.UserAccount;

public interface ProjectService extends GenericService<Integer, Project>{
	
	public Project findByTitle(String title) throws Exception;
	
	public List<Project> list() throws Exception;
	
	public List<UserAccount> listProjectMembers(Integer projectID) throws Exception;
	
	public List<Requirement> listRequirement (Integer projectID);
	
}
