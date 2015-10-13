package mvc.model;

import java.sql.SQLException;

/**
 * Classe para gerenciar as diverças 
 * tabelas de requisiitos
 * 
 * @author Eduardo Scartezini
 *
 */
public class Requisition implements Operations<Requisition> {
	

	/**
	 * Cria uma nova tabela quando 
	 * é criado um novo tipo de 
	 * requisito. assim os requisitos
	 * sao controlados por essa tabela;
	 * 
	 * @throws SQLException
	 */
	public static void createTable() throws SQLException{
		
	}
	
	
	@Override
	public void createNew() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Requisition registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alter(Requisition registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}



}
