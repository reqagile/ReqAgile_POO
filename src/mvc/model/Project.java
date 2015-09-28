package mvc.model;

public class Project extends ProjectManagement{

	private int id;
	private String title;
	private String description;
	

	@Override
	public void createNewProject(String title, String description) throws ProjectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterProject(Project project) throws ProjectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProject(Project project) throws ProjectException {
		// TODO Auto-generated method stub
		
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
