package mvc.model;

import java.sql.*;


public class UserAccount extends AccountOperations {	
	
	private int idUser;
	private String name;
	private String login;
	private String password;
	private String email;

	public UserAccount() {
		
	}
	
	public UserAccount(String name, String login, String password, String email) {
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
	}
	
	
	public void CreateNewUser() throws AccountException {
		//TODO: verificar o número de campos em String.
		try {
			dbConnection.insertRegistry(this);
		} catch (SQLException e) {
			//TODO: tratar excessão de maneiras diferentes de acordo o conteúdo de e.
			throw new AccountException("Database Failure");
		}
	}
	

	public int getId() {
		return idUser;
	}
	
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
