package br.poo.com.reqagile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "REQUIREMENT")
public class Requirement {
	private String name;
	private String descricao;
	private Integer id;
	private Project project;
	private RequirementType type;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="requirementID",unique=true,nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name="name",unique=true,nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="descricao",unique=true,nullable=false)
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@ManyToOne
	@JoinColumn(name="projectID", nullable=false)
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}

	
	@ManyToOne
    @JoinColumn(name="requirementTypeID", nullable=false)
	public RequirementType getType() {
		return type;
	}
	
	public void setType(RequirementType type) {
		this.type = type;
	}
}
