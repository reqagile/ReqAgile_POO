package mvc.model;

import java.sql.*;

import mvc.model.dbconnect.ConnectionTable;
import mvc.model.dbconnect.SqlUser;


public class UserAccount implements Operations<UserAccount> {	
	
	private static ConnectionTable<UserAccount> dbConnection = new SqlUser();
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
	
	@Override
	public void CreateNew() throws SQLException {
		//TODO: verificar o n�mero de campos em String.
		try {
			dbConnection.insertRegistry(this);
		} catch (SQLException e) {
			//TODO: tratar excess�o de maneiras diferentes de acordo o conte�do de e.
			throw new SQLException("Database Failure");
		}
	}
	
	@Override
	public void Delete(UserAccount account) throws SQLException {
		dbConnection.deleteRegistry(account);		
	}

	@Override
	public void Alter(UserAccount account) throws SQLException {
		dbConnection.alterRegistry(account);
		
	}

	
	public static UserAccount Search(String login) throws SQLException {
		return dbConnection.selectRegistry(login);
	}
	
	
	
	/**
	 * Verifica se o usu�rio informado existe e se a sua senha coincide com a
	 * senha informada pelo usu�rio. No caso de sucesso, retorna a conta do usu�rio.
	 * Caso contr�rio, retorna um objeto UserAccount nulo.
	 * @param login
	 * 			Nome de usu�rio
	 * @param password
	 * 			Senha
	 * @throws AccountException
	 * 			No caso de erro na interface com o banco de dados, lan�a a exce��o.
	 */
	public static UserAccount authenticateUser(String login, String password) throws AccountException {
		try {
			UserAccount	user = UserAccount.Search(login);
			if((user != null) && user.getPassword().equals(password)) {
				return user;
			}else {
				return null;
			}
		}catch(SQLException e) {
			throw new AccountException("Erro no acesso ao banco de dados!");
		}
	}

	public int getIdUser() {
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
