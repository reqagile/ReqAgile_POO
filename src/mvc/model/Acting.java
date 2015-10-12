package mvc.model;

import java.sql.SQLException;

/**
 * Classe para definir a função de um usuario
 * em um projeto.
 * @author Eduardo Scartezini
 *
 */
public class Acting implements Operations<Acting>{
	
	private Project project;
	private UserAccount account;
	private String function;
	
	public Acting(){
	}
	
	public Acting(Project project, UserAccount account, String function) {
		this.project = project;
		this.account = account;
		this.function = function;
	}

	@Override
	/**
	 * Serve para persistir a função do user
	 * no DataBase
	 */
	public void createNew() throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Acting registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alter(Acting registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public Acting search(Project project, UserAccount account){
		// TODO 
		return null;
	}
	
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public UserAccount getAccount() {
		return account;
	}

	public void setAccount(UserAccount account) {
		this.account = account;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

}
