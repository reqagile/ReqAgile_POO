package models;

import java.sql.SQLException;

public interface Operations<T> {
	
	
	/**
	 * Persiste a criaçao de um usiario, 
	 * o objeto ja tem que esta instanicado e 
	 * com todo seu atributos criados
	 * 
	 * @throws SQLException
	 */
	public void CreateNew() throws SQLException;
	
	/**
	 * deleta um tipo de registro da sua respequitiva
	 * tabela, parametrizado pelo tipo de dado da 
	 * tabela
	 * 
	 * @param registry
	 * @throws SQLException
	 */
	public void Delete(T registry) throws SQLException;
	
	
	/**
	 * altera um tipo de registro da sua respequitiva
	 * tabela, parametrizado pelo tipo de dado da 
	 * tabela
	 * 
	 * @param registry
	 * @throws SQLException
	 */
	public void Alter(T registry) throws SQLException;
	
}
