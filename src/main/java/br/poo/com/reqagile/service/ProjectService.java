package br.poo.com.reqagile.service;
import br.poo.com.reqagile.model.Project;

public interface ProjectService {
	void save(Project project);
	
	void update(Project project);
	
	void delete(Project project);
	
	Project findById(Integer id) throws Exception;
	
	Project findByTitle(String title) throws Exception;
}
