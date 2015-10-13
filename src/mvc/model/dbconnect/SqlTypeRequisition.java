package mvc.model.dbconnect;

import java.sql.SQLException;

import mvc.model.Project;
import mvc.model.TypeRequisition;

/**
 * Classe para fazer a ligação 
 * com a tabela que guarda os 
 * tipos de requisito
 * 
 * @author Eduardo Scartezini
 *
 */
public class SqlTypeRequisition implements ConnectionTable<TypeRequisition>{
	
	
	
	@Override
	public void insertRegistry(TypeRequisition typeRequisition) throws SQLException {
		String query = "INSERT INTO tiporeq VALUES"+"(NULL,\""+typeRequisition.getTitle()+"\",\""+
					typeRequisition.getDescription()+"\","+typeRequisition.getProject().getIdProject()+");";
		
		MySql.stm.executeUpdate(query);
	}

	@Override
	public TypeRequisition selectRegistry(int id) throws SQLException {
		String query = "SELECT * FROM tiporeq WHERE idtipoReq = "+id+";";
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			TypeRequisition typeRequisition = new TypeRequisition();
			typeRequisition.setIdTypeRequisition(Integer.parseInt(MySql.rs.getString("idtipoReq")));
			typeRequisition.setTitle(MySql.rs.getString("nome"));
			typeRequisition.setDescription(MySql.rs.getString("descricao"));
			typeRequisition.setProject(Project.search(Integer.parseInt(MySql.rs.getString("projeto"))));
			
			return typeRequisition;
		}else {
			throw new SQLException();
		}
		
	}

	@Override
	public TypeRequisition selectRegistry(String title) throws SQLException {
		String query = "SELECT * FROM tiporeq WHERE nome = \""+title+"\";";
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			TypeRequisition typeRequisition = new TypeRequisition();
			typeRequisition.setIdTypeRequisition(Integer.parseInt(MySql.rs.getString("idtipoReq")));
			typeRequisition.setTitle(MySql.rs.getString("nome"));
			typeRequisition.setDescription(MySql.rs.getString("descricao"));
			typeRequisition.setProject(Project.search(Integer.parseInt(MySql.rs.getString("projeto"))));
			
			return typeRequisition;
		}else {
			throw new SQLException();
		}	
	
	}

	
	@Override
	public void deleteRegistry(TypeRequisition typeRequisition) throws SQLException {
		String query = "DELETE FROM tiporeq WHERE idtipoReq = "+typeRequisition.getIdTypeRequisition()+";";
		MySql.stm.executeUpdate(query);
	}

	
	@Override
	public void alterRegistry(TypeRequisition typeRequisition) throws SQLException {
		String query = "UPDATE tiporeq SET nome = \""+typeRequisition.getTitle()+"\", descricao = \""+
					typeRequisition.getDescription()+"\", projeto = "+typeRequisition.getProject().getIdProject()+
					"WHERE idtipoReq = "+typeRequisition.getIdTypeRequisition()+";";
		
		MySql.stm.executeUpdate(query);
	}

	
	
	
}
