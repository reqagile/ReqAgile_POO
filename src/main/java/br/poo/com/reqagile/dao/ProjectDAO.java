package br.poo.com.reqagile.dao;

import java.util.List;
import br.poo.com.reqagile.model.Project;

public interface ProjectDAO {
	
		void save(Project project);
		
		void update(Project project);
		
		void delete(Project project);
		
		Project findById(Integer id) throws Exception;
		
		Project findByTitle(String title) throws Exception;
		
		List<?> listTeamMembers(Integer id) throws Exception;
		
		List<Project> list();

}

