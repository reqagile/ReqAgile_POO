package br.poo.com.reqagile.service;

import java.util.List;

import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.UserAccount;

public interface UserAccountService extends GenericService<Integer, UserAccount> {
	
	public UserAccount findByEmail(String userEmail);
	
	public UserAccount findByLogin(String userLogin);
	
	public UserAccount findByName(String userName);
	
	public boolean isUserRegistered(String userName, String password);
	
	public List<UserAccount> list() throws Exception;
	
	public List<Project> listProject(Integer userID) throws Exception;
}
