package mvc.model;

public interface AccountOperations {
	/**
	 * Verifica se o usuário existe e se a senha é igual à informada pelo usuário.
	 * @param login	username informado pelo usuário
	 * @param password senha informada pelo usuário
	 * @throws java.sql.SQLException
	 */
	public boolean authenticateUser(String login, String password) throws AccountException;
	
	/**
	 * Cria novo usuário com as informações recebidas em userData:
	 * @param userData
	 * 
	 *		0 - iduser;
	 *  	1 - name;
	 *  	2 - login;
	 *  	3 - password;
	 *  	4 - email;
	 */
	public void CreateNewUser(String[] userData) throws AccountException;
}
