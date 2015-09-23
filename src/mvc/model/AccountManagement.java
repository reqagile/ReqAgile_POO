package mvc.model;

import java.sql.SQLException;

import mvc.model.dbconnect.ConnectionTable;

public abstract class AccountManagement implements AccountOperations {
	
	private static ConnectionTable dbConnection;

	public static ConnectionTable getDbConnection() {
		return dbConnection;
	}

	public static void setDbConnection(ConnectionTable dbConnection) {
		AccountManagement.dbConnection = dbConnection;
	}
	
	/**
	 * Verifica se o usuário existe e se a senha é igual à informada pelo usuário.
	 * @param login	username informado pelo usuário
	 * @param password senha informada pelo usuário
	 * @throws java.sql.SQLException
	 */
	public boolean authenticateUser(String login, String password) throws AccountException {
		String[] userInfo;
		try {
			userInfo = dbConnection.selectRegistry(login);
			return (userInfo != null && password.equals(userInfo[3]));
		} catch (SQLException e) {
			//TODO: tratar excessão de maneiras diferentes de acordo o conteúdo de e.
			throw new AccountException("Database Failure");
		}
	}
	
	public void CreateNewUser(String[] userData) throws AccountException {
		//TODO: verificar o número de campos em String.
		try {
			AccountManagement.dbConnection.insertRegistry(userData[0], userData[1], userData[2], userData[3]);
		} catch (SQLException e) {
			//TODO: tratar excessão de maneiras diferentes de acordo o conteúdo de e.
			throw new AccountException("Database Failure");
		}
	}

}
