package mvc.model;

import java.sql.SQLException;

import mvc.model.dbconnect.SqlActing;

/**
 * Classe para definir a função de um usuario
 * em um projeto.
 * @author Eduardo Scartezini
 *
 */
public class Acting implements Operations<Acting>{
	
	private SqlActing sqlActing = new SqlActing();
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

	
	/**
	 * deleta todas informaçoes referente a 
	 * um projeto
	 * 
	 * @param project
	 * @throws SQLException
	 */
	public void delete(Project project) throws SQLException{
		sqlActing.deleteRegistry(project);
	}
	
	/**
	 * deleta todas as informaçoes referente a uma 
	 * conta
	 * 
	 * @param account
	 * @throws SQLException
	 */
	public void delete(UserAccount account) throws SQLException{
		sqlActing.deleteRegistry(account);
	}
	
	
	@Override
	/**
	 * Serve para persistir a função do user
	 * no DataBase
	 */
	public void createNew() throws SQLException {
		if(this.project != null && this.account != null && this.function != null){
			sqlActing.insertRegistry(this);
		}
	}

	@Override
	public void delete(Acting acting) throws SQLException {
		sqlActing.deleteRegistry(acting);
	}

	@Override
	/**
	 * Altera a funçao, caso o usuario ja exista 
	 * como no projeto.
	 * Pega o usuario e o projeto
	 * e altera a função  
	 * 
	 */
	public void alter(Acting acting) throws SQLException {
		sqlActing.deleteRegistry(acting);
		sqlActing.insertRegistry(acting);
	}
	
	/**
	 * Pesquisa a funçao de
	 * uma user em um projeto
	 * 
	 * @param project
	 * @param account
	 * @return
	 * @throws SQLException
	 */
	public Acting search(Project project, UserAccount account) throws SQLException{ 
		return sqlActing.selectRegistry(project.getIdProject(), account.getIdUser());
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
