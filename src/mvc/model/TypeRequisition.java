package mvc.model;

import java.sql.SQLException;


/**
 * Classe que gerencia a tabela
 * de tipos de requisito 
 * 
 * @author Eduardo Scartezini
 *
 */
public class TypeRequisition implements Operations<TypeRequisition> {
	
	private int idTypeRequisition;
	private String title;
	private String description;
	private Project project;
	
	
	public TypeRequisition(){
	}
	
	public TypeRequisition(String title, String description, Project project) {
		this.title = title;
		this.description = description;
		this.project = project;
	}

	//	parametros são os campos a ser preenchido 
//	quando é criado um novo projeto desse tipo
//    dataType são os tipos de dado a ser usado para aquele
//    parametro, exempo:
//    	parameters[0] -> name
//    	dataType[0] -> varchar(32)
//    	parameters[1] -> id
//    	dataType[1] -> int(11)
	private String[] parameters;
	private String[] dataType;
	
	/*---------------------------------------------------------------------------------------------*/
	
	
	@Override
	public void createNew() throws SQLException {
		// TODO Auto-generated method stub
		// TODO Criar uma tabela do tipo de requisito
		
	}

	@Override
	public void delete(TypeRequisition registry) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Deletar a tabela do requisito
		
	}

	@Override
	public void alter(TypeRequisition registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

/*-----------------------------------------------------------------------------------*/
	
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
    	
    public int getIdTypeRequisition() {
		return idTypeRequisition;
	}

	public void setIdTypeRequisition(int idTypeRequisition) {
		this.idTypeRequisition = idTypeRequisition;
	}

	/**
     * parametros são os campos a ser preenchido 
	 *	quando é criado um novo projeto desse tipo
     *	dataType são os tipos de dado a ser usado para aquele
     *	parametro, exempo:
     *	parameters[0] -> name
     *	dataType[0] -> varchar(32)
     *	parameters[1] -> id
     *	dataType[1] -> int(11)
     * @return
     */
	public String[] getParameters() {
		return parameters;
	}

	
	public void setParameters(String[] parameters) {
		this.parameters = parameters;
	}
	
	
	  /**
     * parametros são os campos a ser preenchido 
	 *	quando é criado um novo projeto desse tipo
     *	dataType são os tipos de dado a ser usado para aquele
     *	parametro, exempo:
     *	parameters[0] -> name
     *	dataType[0] -> varchar(32)
     *	parameters[1] -> id
     *	dataType[1] -> int(11)
     * @return
     */
	public String[] getDataType() {
		return dataType;
	}

	public void setDataType(String[] dataType) {
		this.dataType = dataType;
	}


}
