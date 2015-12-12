package br.poo.com.reqagile.dao;

import java.util.List;

import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.UserAccount;

/**
 * Interface que fornece a assinatura dos metodos peculiares para
 * classes de UserAccount que possam implementar tais metodos na
 * persistencia.
 * 
 *@author Wellington Stanley
 * */

public interface UserAccountDAO extends GenericDAO<Integer, UserAccount>{
	public UserAccount findByEmail(String userEmail);
	
	public UserAccount findByLogin(String userLogin);
	
	public UserAccount findByName(String userName);
	
	public boolean isUserRegistered(String userName, String password);
	
	public List<UserAccount> list();
	
	public List<Project> listProject(Integer userID) throws Exception;


}
