package mvc.model;

import java.sql.SQLException;
import mvc.model.dbconnect.ConnectionTable;

public abstract class AccountOperations {
	
	protected static ConnectionTable dbConnection;


	/**
	 * Cria novo usuário com as informações recebidas em userData:
	 */
	public abstract void CreateNewUser() throws AccountException;
	
	/**
	 * Verifica se o usuário existe e se a senha é igual à informada pelo usuário.
	 * @param login	username informado pelo usuário
	 * @param password senha informada pelo usuário
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
