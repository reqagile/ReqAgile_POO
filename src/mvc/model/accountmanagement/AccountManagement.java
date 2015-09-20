package mvc.model.accountmanagement;

import mvc.model.connectDB.ConnectionUser;

public abstract class AccountManagement {
	
	private static ConnectionUser dbConnection;

	public static ConnectionUser getDbConnection() {
		return dbConnection;
	}

	public static void setDbConnection(ConnectionUser dbConnection) {
		AccountManagement.dbConnection = dbConnection;
	}
	
	/**
	 * Verifica se o usu�rio existe e se a senha � igual � informada pelo usu�rio.
	 * @param login	username informado pelo usu�rio
	 * @param password senha informada pelo usu�rio
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
