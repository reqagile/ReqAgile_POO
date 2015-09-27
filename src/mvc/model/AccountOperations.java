package mvc.model;

import java.sql.SQLException;
import mvc.model.dbconnect.ConnectionTable;
import mvc.model.dbconnect.SqlUser;

public abstract class AccountOperations {
	/**
	 * Conexão com o banco de dados.
	 */
	protected static ConnectionTable<UserAccount> dbConnection = new SqlUser();


	/**
	 * Registra os dados do usuário na base de dados. É necessário ter
	 * definido valores para todos os atributos do objeto, por meio de
	 * um construtor ou pelos métodos set.
	 */
	public abstract void CreateNewUser() throws AccountException;
	
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
	
	
	@SuppressWarnings("rawtypes")
	public static ConnectionTable getDbConnection() {
		return dbConnection;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setDbConnection(ConnectionTable dbConnection) {
		UserAccount.dbConnection = dbConnection;
	}
}
