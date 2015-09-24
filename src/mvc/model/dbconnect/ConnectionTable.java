package mvc.model.dbconnect;

import java.sql.SQLException;
import mvc.model.AccountException;
import mvc.model.UserAccount;

/**
 * Interface que define como sera dada
 * a conexão com a tabela de usuarios.
 * 
 * Com essa interface eu posso criar diferentes 
 * implementações para diferentes modes do banco de dados
 * 
 * @author Eduardo Scartezini
 *
 */
public interface ConnectionTable {
	
	/**
	 * Insere um novo registro na tabela user
	 * 
	 * @param name
	 * @param login
	 * @param password
	 * @param email
	 * @throws java.sql.SQLException
	 */
	public void insertRegistry(UserAccount account) throws java.sql.SQLException;

	
 
	/**
	 * Selecionar um registro pelo id
	 *  do usuario
	 *  
	 * @param iduser
	 * @return String[]
	 *  	Retorna um array com todos os atributos do registro
	 *  	0 - iduser;
	 *  	1 - name;
	 *  	2 - login;
	 *  	3 - password;
	 *  	4 - email;
	 *  @throws java.sql.SQLException
	 *  	
	 */
	public UserAccount selectRegistry(int iduser) throws SQLException, AccountException;	
	/**
	 * Selecionar um registro pelo login do usuario
	 * 
	 * @param login
	 * @return String[]
	 *
	 *  	Retorna um array com todos os atributos do registro
	 *  	0 - iduser;
	 *  	1 - name;
	 *  	2 - login;
	 *  	3 - password;
	 *  	4 - email;
	 *  @throws java.sql.SQLException
	 */
	public UserAccount selectRegistry(String login) throws java.sql.SQLException, AccountException;
	
	
	/**
	 * Deleta um registro da tabela user
	 * 
	 * @param iduser
	 * @throws java.sql.SQLException
	 */
	public void deleteRegistry(int iduser)throws java.sql.SQLException;
	
	
	/**
	 * Altera um certo atributo de um registro existente;
	 * 
	 * @param iduser
	 * @param attribute
	 * 		atributo à ser alterado
	 * @param value
	 * 		valor à ser atribuido  
	 * @throws java.sql.SQLException
	 */
	public void alterRegistry(UserAccount account) throws java.sql.SQLException;

}
