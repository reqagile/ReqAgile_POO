package mvc.model;

import java.sql.SQLException;
import mvc.model.dbconnect.ConnectionTable;

public abstract class AccountOperations {
	/**
	 * Conex�o com o banco de dados.
	 */
	protected static ConnectionTable dbConnection;


	/**
	 * Registra os dados do usu�rio na base de dados. � necess�rio ter
	 * definido valores para todos os atributos do objeto, por meio de
	 * um construtor ou pelos m�todos set.
	 */
	public abstract void CreateNewUser() throws AccountException;
	
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
	public UserAccount authenticateUser(String login, String password) throws AccountException {
		try {
			UserAccount	user = dbConnection.selectRegistry(login);
			if((user != null) && user.getPassword().equals(password)) {
				return user;
			}else {
				return null;
			}
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
