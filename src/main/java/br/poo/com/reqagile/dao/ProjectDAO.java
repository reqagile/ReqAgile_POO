package br.poo.com.reqagile.dao;

import java.util.List;
import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.Requirement;
import br.poo.com.reqagile.model.UserAccount;

/**
 * Interface que fornece a assinatura dos metodos peculiares para
 * classes de Projeto que possam implementar tais metodos na
 * persistencia.
 * 
 *@author Wellington Stanley
 * */

public interface ProjectDAO extends GenericDAO<Integer, Project>{
				
		public Project findByTitle(String title) throws Exception;
		
		public List<Project> list();
		
		public List<UserAccount> listProjectMembers(Integer projectID) throws Exception;
		
		public List<Requirement> listRequirement (Integer projectID);
		
		
		

}

