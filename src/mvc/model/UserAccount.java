package mvc.model;

import java.sql.*;

import mvc.model.dbconnect.ConnectionTable;
import mvc.model.dbconnect.SqlActing;
import mvc.model.dbconnect.SqlUser;
import mvc.model.exception.AccountException;


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
	public void createNew() throws SQLException {
		//TODO: verificar o número de campos em String.
		try {
			dbConnection.insertRegistry(this);
		} catch (SQLException e) {
			//TODO: tratar excessão de maneiras diferentes de acordo o conteúdo de e.
			throw new SQLException("Database Failure");
		}
	}
	
	@Override
	public void delete(UserAccount account) throws SQLException {
		SqlActing sqlActing = new SqlActing();
		
		//Trantando pq um usuario pode nao 
		//ter função em nem um projeto
		try{
			sqlActing.deleteRegistry(account);
		}catch(SQLException e){
		}
		
		dbConnection.deleteRegistry(account);		
	}

	@Override
	public void alter(UserAccount account) throws SQLException {
		dbConnection.alterRegistry(account);
		
	}

	
	public static UserAccount search(String login) throws SQLException {
		return dbConnection.selectRegistry(login);
	}
	
	public static UserAccount search(int idAccount) throws SQLException{
		return dbConnection.selectRegistry(idAccount);
		
	}
	
	
	/**
	 * Verifica se o usuário informado existe e se a sua senha coincide com a
	 * senha informada pelo usuário. No caso de sucesso, retorna a conta do usuário.
	 * Caso contrário, retorna um objeto UserAccount nulo.
	 * @param login
	 * 			Nome de usuário
	 * @param password
	 * 			Senha
	 * @throws AccountException
	 * 			No caso de erro na interface com o banco de dados, lança a exceção.
	 */
	public static UserAccount authenticateUser(String login, String password) throws AccountException {
		try {
			UserAccount	user = UserAccount.search(login);
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
