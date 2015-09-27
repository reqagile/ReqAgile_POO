package mvc.model.dbconnect;

import java.sql.SQLException;
import mvc.model.Project;

public class SqlProject implements ConnectionTable<Project> {
	
	
	/**
	 *  Construtor do SqlProject. 
	 * 
	 * 		Verifica se a conexão com Data Base,
	 * 	caso não esteja conectado ele tenta conectar.
	 */
	public SqlProject(){
		int i = 0;
		while(MySql.isConnected() == false && i < 10){
			MySql.connect();
			i++;
		}
	}
	
	
	@Override
	public void insertRegistry(Project project) throws SQLException {
		String query = "INSERT INTO user VALUES "+"(NULL,'"+project.getTitle()+"','"+
						project.getDescription()+"');";
		
		MySql.stm.executeUpdate(query);
		
	}

	@Override
	public Project selectRegistry(int idProject) throws SQLException {
		String query = "SELECT * FROM user WHERE idprojeto = "+idProject+";";
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			Project project = new Project();
			
			project.setIdProject(Integer.parseInt(MySql.rs.getString("idprojeto")));
			project.setTitle(MySql.rs.getString("titulo"));
			project.setDescription(MySql.rs.getString("descricao"));
			
		}else{
			throw new SQLException("Projeto não cadastrado");
		}
		
		return null;
	}

	
	
	@Override
	public Project selectRegistry(String title) throws SQLException {
		String query = "SELECT * FROM user WHERE titulo = "+title+";";
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			Project project = new Project();
			
			project.setIdProject(Integer.parseInt(MySql.rs.getString("idprojeto")));
			project.setTitle(MySql.rs.getString("titulo"));
			project.setDescription(MySql.rs.getString("descricao"));
			
		}else{
			throw new SQLException("Projeto não cadastrado");
		}
		return null;
	}
	
	

	@Override
	public void deleteRegistry(int idProject) throws SQLException {
		String query = "DELETE FROM user WHERE idprojeto = "+idProject+";";
		
		MySql.stm.executeUpdate(query);
	}

	
	
	@Override
	public void alterRegistry(Project project) throws SQLException {
		String query = "UPDATE user SET titulo = \""+project.getTitle()+"\" , descricao = \""+
						project.getDescription()+"\" WHERE idprojeto = "+project.getIdProject()+";";
		
		MySql.stm.executeUpdate(query);
	}

}
