package br.poo.com.reqagile.service;

import br.poo.com.reqagile.model.UserAccount;

public interface UserAccountService {

	void save(UserAccount user);
	
	void update(UserAccount user);
	
	void delete(UserAccount user);
	
	UserAccount findById(Integer id) throws Exception;
	
	UserAccount findByEmail(String email) throws Exception;
	
	UserAccount findByLogin(String login) throws Exception;

}
