package br.poo.com.reqagile.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {
	
	private Integer id;
	private String title;
	private String description;
	private List<Requirement> requirements;
//	private List<UserAccount> users;
	
	public Project(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="projectID",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="title",unique=true,nullable=false) 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="description",unique=false,nullable=false,columnDefinition="TEXT")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy="project")
	public List<Requirement> getRequirements() {
		return requirements;
	}
	
	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}
	
	@Override
	public String toString() {
		return("idProject= " + id + ", title= " + title + ", description= " + description);
	}

}
