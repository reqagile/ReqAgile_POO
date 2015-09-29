package mvc.model;

import java.sql.SQLException;

import mvc.model.dbconnect.ConnectionTable;
import mvc.model.dbconnect.SqlProject;

public class Project implements Operations<Project>{
	
	private static ConnectionTable<Project> dbConnection = new SqlProject();
	private int id;
	private String title;
	private String description;
	
	
	@Override
	public void CreateNew() throws SQLException {
			dbConnection.insertRegistry(this);
	}

	@Override
	public void Alter(Project project) throws SQLException {
			dbConnection.alterRegistry(project);
	}

	@Override
	public void Delete(Project project) throws SQLException {
			dbConnection.deleteRegistry(project);
	}
	
	/**
	 * Metodo que pesquisa um projeto no Banco de dados 
	 * 
	 * @param title
	 * @return Project
	 * 		Objeto para projeto
	 * @throws ProjectException
	 * 		Para erros com banco de dados ou projeto não encontrados
	 */
	public static Project Search(String title) throws SQLException{
		try{
			Project project = dbConnection.selectRegistry(title);
			if(project != null){
				return project;
			}else{
				throw new SQLException("Projeto não cadastrado");
			}
		}catch(SQLException e){
			throw new SQLException("Database Faluier");
		}
	}

	public Project (){
	
	}
	
	
	public Project(int id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public int getIdProject() {
		return id;
	}

	public void setIdProject(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

}
