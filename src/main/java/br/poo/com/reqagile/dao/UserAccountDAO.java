package br.poo.com.reqagile.dao;

import java.util.List;

import br.poo.com.reqagile.model.UserAccount;

public interface UserAccountDAO {
	void save(UserAccount user);
	
	void update(UserAccount user);
	
	void delete(UserAccount user);
	
	UserAccount findById(Integer id) throws Exception;
	
	UserAccount findByEmail(String email) throws Exception;
	
	UserAccount findByLogin(String login) throws Exception;
	
	List<UserAccount> list();

}
