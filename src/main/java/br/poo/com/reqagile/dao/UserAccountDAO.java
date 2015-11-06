package br.poo.com.reqagile.dao;

import java.util.List;

import br.poo.com.reqagile.model.UserAccount;

public interface UserAccountDAO {
	void save(UserAccount user);
	
	void update(UserAccount user);
	
	void delete(UserAccount user);
	
	UserAccount findById(Integer id);
	
	UserAccount findByEmail(String email);
	
	UserAccount findByLogin(String login);
	
	List<UserAccount> list();

}
