package mvc.model;

public class Project implements ProjectManagement{
	
	private int id;
	private String title;
	private String description;
	
	@Override
	public void createNewProject(String title, String description) throws ProjectException {
		// TODO Auto-generated method stub
		
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
