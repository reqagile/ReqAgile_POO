package mvc.model.dbconnect;

import java.sql.SQLException;
import mvc.model.AccountException;


/**
 * Interface que define as regras da conexão 
 * da aplicação java com o DataBase
 * 
 * 
 * @author Eduardo Scartezini
 *
 * @param <Table>
 * 		parametrizado pela tabela a ser usada
 */
public interface ConnectionTable<Table> {
	
	/**
	 * Inserir um novo registro no DataBase
	 * 
	 * @param registry
	 * 		Objeto do registro a ser inserido 
	 * 
	 * @throws java.sql.SQLException
	 */
	public void insertRegistry(Table registry) throws java.sql.SQLException;

	/**
	 * Recupera um registro do Data Base
	 * 
	 * 
	 * @param id
	 * 		chave primaria do registro
	 * @return
	 * 		Objeto para registro
	 * 
	 * @throws SQLException
	 * @throws AccountException
	 */
	public Table selectRegistry(int id) throws SQLException, AccountException;	
	
	/**
	 * Recupera um registro do Data Base
	 * 
	 * 
	 * @param secondaryKey
	 * 		Chave secundaria do registro
	 * @return
	 * 		Objeto para o registro
	 * @throws SQLException
	 * @throws AccountException
	 */
	public Table selectRegistry(String secondaryKey) throws SQLException, AccountException;
	/**
	 * Delata um registro do DataBase
	 * @param id
	 * 		chave primaria do registro
	 * 
	 * @throws java.sql.SQLException
	 */
	public void deleteRegistry(int id)throws java.sql.SQLException;
	
	
	/**
	 * Altera um registro do DataBase
	 * @param registry
	 * 		Objeto do registro
	 * 
	 * @throws java.sql.SQLException
	 */
	public void alterRegistry(Table registry) throws java.sql.SQLException;

}
