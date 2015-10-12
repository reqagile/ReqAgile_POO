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
		String query = "INSERT INTO projeto VALUES "+"(NULL,'"+project.getTitle()+"','"+
						project.getDescription()+"');";
		
		MySql.stm.executeUpdate(query);
		
	}

	@Override
	public Project selectRegistry(int idProject) throws SQLException {
		String query = "SELECT * FROM projeto WHERE idprojeto = "+idProject+";";	
		Project project = new Project();
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			
			
			project.setIdProject(Integer.parseInt(MySql.rs.getString("idprojeto")));
			project.setTitle(MySql.rs.getString("titulo"));
			project.setDescription(MySql.rs.getString("descricao"));
			
		}else{
			throw new SQLException("Projeto não cadastrado");
		}
		
		return project;
	}

	
	
	@Override
	public Project selectRegistry(String title) throws SQLException {
		String query = "SELECT * FROM projeto WHERE titulo = "+title+";";
		Project project = new Project();
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){		
			project.setIdProject(Integer.parseInt(MySql.rs.getString("idprojeto")));
			project.setTitle(MySql.rs.getString("titulo"));
			project.setDescription(MySql.rs.getString("descricao"));
			
		}else{
			return null;
		}
		return project;
	}
	
	

	@Override
	public void deleteRegistry(Project project) throws SQLException {
		String query = "DELETE FROM projeto WHERE idprojeto = "+project.getIdProject()+";";
		
		MySql.stm.executeUpdate(query);
	}

	
	
	@Override
	public void alterRegistry(Project project) throws SQLException {
		String query = "UPDATE projeto SET titulo = \""+project.getTitle()+"\" , descricao = \""+
						project.getDescription()+"\" WHERE idprojeto = "+project.getIdProject()+";";
		
		MySql.stm.executeUpdate(query);
	}

}
