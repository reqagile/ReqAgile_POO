package mvc.model;

import java.sql.SQLException;

import mvc.model.dbconnect.ConnectionTable;
import mvc.model.dbconnect.SqlProject;
import mvc.model.exception.ProjectException;

/**
 * Classe para operar projetos
 * @author Eduardo Scartezini
 *
 */
public class Project implements Operations<Project>{
	
	private static ConnectionTable<Project> dbConnection = new SqlProject();
	private int id;
	private String title;
	private String description;
	private UserAccount admin;
	
	
	/**
	 * Com esse contrutor ja define o valor 
	 * de todos os atributos da classe;
	 * 
	 * @param id
	 * @param title
	 * @param description
	 * @param admin
	 */
	public Project(int id, String title, String description, UserAccount admin) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.admin = admin;
	}
	
	@Override
	public void createNew() throws SQLException {
			dbConnection.insertRegistry(this);
			
			//persistir o administrador do novo projeto.
			Acting acting = new Acting(this,this.admin,"Administrador");
			acting.createNew();
	}

	@Override
	public void alter(Project project) throws SQLException {
			dbConnection.alterRegistry(project);
	}

	@Override
	public void delete(Project project) throws SQLException {
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
	public static Project search(String title) throws SQLException{
		Project project = dbConnection.selectRegistry(title);
		if(project != null){
			return project;
		}else{
			throw new SQLException("Projeto não cadastrado");
		}
	}
	
	public static Project search(int idProject) throws SQLException{
		Project project = dbConnection.selectRegistry(idProject);
		if(project != null){
			return project;
		}else{
			throw new SQLException("Projeto não cadastrado");
		}
	}

	/************************************************************************************************/
		
	
	/************************************************************************************************/
	public Project (){
	
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
