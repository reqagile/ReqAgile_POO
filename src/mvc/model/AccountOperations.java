package mvc.model;

import java.sql.SQLException;
import mvc.model.dbconnect.ConnectionTable;

public abstract class AccountOperations {
	
	protected static ConnectionTable dbConnection;


	/**
	 * Cria novo usu�rio com as informa��es recebidas em userData:
	 */
	public abstract void CreateNewUser() throws AccountException;
	
	/**
	 * Verifica se o usu�rio existe e se a senha � igual � informada pelo usu�rio.
	 * @param login	username informado pelo usu�rio
	 * @param password senha informada pelo usu�rio
	 * @throws java.sql.SQLException
	 */
	public boolean authenticateUser(String login, String password) throws AccountException {
		try {
			UserAccount	user = dbConnection.selectRegistry(login);
			return (user != null) && (user.getPassword().equals(password));
		}catch(SQLException e) {
			throw new AccountException("Erro no acesso ao banco de dados!");
		}
	}
	
	
	public static ConnectionTable getDbConnection() {
		return dbConnection;
	}

	public static void setDbConnection(ConnectionTable dbConnection) {
		UserAccount.dbConnection = dbConnection;
	}
}
