package mvc.model;

import mvc.model.dbconnect.ConnectionTable;

public abstract class AccountManagement {
	
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
	public boolean authenticateUser(String login, String password) throws java.sql.SQLException {
		String[] userInfo = dbConnection.selectRegistry(login);
		if(userInfo != null && password.equals(userInfo[3])){				
			return true;
		}
		else {
			return false;
		}
	}
}
