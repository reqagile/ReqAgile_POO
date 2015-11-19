package br.poo.com.reqagile.service;

import br.poo.com.reqagile.model.UserAccount;

public interface UserAccountService extends GenericService<Integer, UserAccount> {
	
	public UserAccount findByEmail(String userEmail);
	
	public UserAccount findByLogin(String userLogin);
	
	public UserAccount findByName(String userName);
	
	public boolean isUserRegistered(String userName, String password);
}
