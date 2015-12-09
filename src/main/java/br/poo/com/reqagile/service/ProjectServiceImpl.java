package br.poo.com.reqagile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.poo.com.reqagile.dao.ProjectDAO;
import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.Requirement;
import br.poo.com.reqagile.model.UserAccount;

@Service("projectService")
public class ProjectServiceImpl extends GenericServiceImplAbstract<Integer, Project>
	implements ProjectService {
	
	@Autowired
	ProjectDAO projectDAO;

	public Project findByTitle(String title) throws Exception {
		try {
			return projectDAO.findByTitle(title);
		} catch (Exception e) {
			throw new Exception("Erro ao pesquisar projeto", e);
		}
	}
	
	public List<UserAccount> listTeamMembers(Integer id) throws Exception{
		try {
			return projectDAO.listTeamMembers(id);			
		} catch (Exception e) {
			throw new Exception("Erro ao pesquisar membros do projeto", e);
		}
	}
	
	public List<Requirement> listRequirement (Integer id){
		return projectDAO.listRequirement(id);
	}


}
