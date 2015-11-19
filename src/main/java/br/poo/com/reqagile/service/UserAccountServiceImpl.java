package br.poo.com.reqagile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.poo.com.reqagile.dao.UserAccountDAO;
import br.poo.com.reqagile.model.UserAccount;

@Service("userAccountService")
public class UserAccountServiceImpl extends GenericServiceImplAbstract<Integer, UserAccount> 
		implements UserAccountService{
	
	@Autowired
	UserAccountDAO userAccountDao;
	
	public UserAccount findByEmail(String email) {
		return userAccountDao.findByEmail(email);
	}

	public UserAccount findByLogin(String login) {
		return userAccountDao.findByLogin(login);
	}
	
	public UserAccount findByName(String name){
		return userAccountDao.findByName(name);
	}
	
	public boolean isUserRegistered(String userName, String password){
		
		return true;
	}

}
