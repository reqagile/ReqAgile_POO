package br.poo.com.reqagile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.poo.com.reqagile.dao.UserAccountDAO;
import br.poo.com.reqagile.model.Project;
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
	
	public List<UserAccount> list() throws Exception{
		try {
			return userAccountDao.list();
		} catch (Exception e) {
			throw new Exception("Erro ao pesquisar usuários", e);
		}
	}
	
	public List<Project> listProject(Integer userID) throws Exception{
		try {
			return userAccountDao.listProject(userID);
		} catch (Exception e) {
			throw new Exception("Erro ao pesquisar projetos", e);
		}
	}

}
