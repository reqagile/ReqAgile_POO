package mvc.model;

public interface AccountOperations {
	/**
	 * Verifica se o usu�rio existe e se a senha � igual � informada pelo usu�rio.
	 * @param login	username informado pelo usu�rio
	 * @param password senha informada pelo usu�rio
	 * @throws java.sql.SQLException
	 */
	public boolean authenticateUser(String login, String password) throws AccountException;
	
	/**
	 * Cria novo usu�rio com as informa��es recebidas em userData:
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
