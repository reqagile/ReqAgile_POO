package br.poo.com.reqagile.service;
import java.util.List;

import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.Requirement;
import br.poo.com.reqagile.model.UserAccount;

public interface ProjectService extends GenericService<Integer, Project>{
	
	Project findByTitle(String title) throws Exception;
	
	List<UserAccount> listTeamMembers(Integer id) throws Exception;
	
	List<Requirement> listRequirement (Integer id);
	
}
