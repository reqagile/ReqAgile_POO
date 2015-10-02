package mvc.model;

import java.sql.SQLException;

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
	public void CreateNew() throws SQLException {
		// TODO Auto-generated method stub
	}

	@Override
	public void Delete(Acting registry) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Alter(Acting registry) throws SQLException {
		// TODO Auto-generated method stub
		
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
