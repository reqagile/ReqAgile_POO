package mvc.model.dbconnect;

import java.sql.SQLException;

import mvc.model.Requisition;


/**
 * Classe para fazer a liação 
 * com as diverças tabelas 
 * que definem requisito
 * 
 * @author Eduardo Scartezini
 *
 */
public class SqlRequisition implements ConnectionTable<Requisition>{

	@Override
	public void insertRegistry(Requisition registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Requisition selectRegistry(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Requisition selectRegistry(String secondaryKey) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRegistry(Requisition registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterRegistry(Requisition registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
