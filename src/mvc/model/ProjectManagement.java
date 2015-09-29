package mvc.model;

import java.sql.SQLException;

import mvc.model.dbconnect.ConnectionTable;
import mvc.model.dbconnect.SqlProject;

public abstract class ProjectManagement {
	
	protected static ConnectionTable<Project> dbConnection = new SqlProject();
	
	
	/**
	 * Metodo responsavel por criar um novo projeto
	 * 
	 * @param title
	 * @param description
	 * @throws ProjectException
	 */
	public abstract void createNewProject(String title, String description) throws ProjectException;
	
	
	/**
	 * Método responsavel por alterar alguma caracteristica
	 * de um projeto
	 * 
	 * @param project
	 * @throws ProjectException
	 */
	public abstract void alterProject(Project project) throws ProjectException;
	
	
	/**
	 * Metodo responsavel por excluir um projeto do sistema
	 * de banco de dados
	 * 
	 * @param project
	 * @throws ProjectException
	 */
	public abstract void deleteProject(Project project) throws ProjectException;
	
	
	/**
	 * Metodo que pesquisa um projeto no Banco de dados 
	 * 
	 * @param title
	 * @return Project
	 * 		Objeto para projeto
	 * @throws ProjectException
	 * 		Para erros com banco de dados ou projeto não encontrados
	 */
	public static Project searchProject(String title) throws ProjectException{
		try{
			Project project = dbConnection.selectRegistry(title);
			if(project != null){
				return project;
			}else{
				throw new ProjectException("Projeto não cadastrado");
			}
		}catch(SQLException e){
			throw new ProjectException("Erro no acesso ao banco de dados");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static ConnectionTable getDbConnection() {
		return dbConnection;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void setDbConnection(ConnectionTable dbConnection) {
		UserAccount.dbConnection = dbConnection;
	}
	
}
