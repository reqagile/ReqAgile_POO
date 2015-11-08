package br.poo.com.reqagile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.poo.com.reqagile.dao.ProjectDAO;
import br.poo.com.reqagile.model.Project;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	ProjectDAO projectDAO;

	public void save(Project project) {
		projectDAO.save(project);		
	}

	public void update(Project project) {
		projectDAO.update(project);
	}

	public void delete(Project project) {
		projectDAO.delete(project);		
	}

	public Project findById(Integer id) throws Exception {
		return projectDAO.findById(id);
	}

	public Project findByTitle(String title) throws Exception {
		return projectDAO.findByTitle(title);
	}
}
