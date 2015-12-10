package br.poo.com.reqagile.dao;

import java.util.List;

import br.poo.com.reqagile.model.UserAccount;
import br.poo.com.reqagile.model.UserRoles;

public interface UserRolesDAO extends GenericDAO<Integer, UserRoles>{
	public List<UserAccount> listUsers(String role);
	
	public List<UserAccount> listAdms(String role);
}
