package br.poo.com.reqagile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROJETO")
public class Project {
	private Integer id;
	private String title;
	private String description;
	
	public Project() {
		
	}
	
	public Project(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	@Id
	@GeneratedValue
	@Column(name="idProjeto",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="titulo",unique=true,nullable=false) 
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="descricao",unique=false,nullable=false,columnDefinition="TEXT")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return("idProject= " + id + ", title= " + title + ", description= " + description);
	}

}
