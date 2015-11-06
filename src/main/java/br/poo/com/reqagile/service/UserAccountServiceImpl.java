package br.poo.com.reqagile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.poo.com.reqagile.dao.UserAccountDAO;
import br.poo.com.reqagile.model.UserAccount;

@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService{
	
	@Autowired
	UserAccountDAO userDao;
	
	/*	public void setStockDao(StockDao stockDao) {
		this.stockDao = stockDao;
	}*/

	public void save(UserAccount user) {
		userDao.save(user);
	}

	public void update(UserAccount user) {
		userDao.update(user);
	}

	public void delete(UserAccount user) {
		userDao.delete(user);
	}

	public UserAccount findById(Integer id) {
		return userDao.findById(id);
	}

	public UserAccount findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public UserAccount findByLogin(String login) {
		return userDao.findByLogin(login);
	}

}
