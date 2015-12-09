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
				
		Project findByTitle(String title) throws Exception;
		
		List<UserAccount> listTeamMembers(Integer id) throws Exception;
		
		List<Requirement> listRequirement (Integer id);
		

}

