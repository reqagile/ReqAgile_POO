package br.poo.com.reqagile.service;

import br.poo.com.reqagile.model.UserAccount;

public interface UserAccountService {

	void save(UserAccount user);
	
	void update(UserAccount user);
	
	void delete(UserAccount user);
	
	UserAccount findById(Integer id);
	
	UserAccount findByEmail(String email);
	
	UserAccount findByLogin(String login);

}
