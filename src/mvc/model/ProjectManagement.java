package mvc.model;

public abstract class ProjectManagement {
	
	
	public abstract void createNewProject(String title, String description) throws ProjectException;
	
	public abstract void alterProject(Project project) throws ProjectException;
	
	public abstract void deleteProject(Project project) throws ProjectException;
	
	public static void searchProject(String title) throws ProjectException{
		//TODO
	}
}
