package br.poo.com.reqagile.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REQUIREMENTTYPE")
public class RequirementType {
	private Integer id;
	private String name;
	private List<Property> properties;
	private List<Requirement> requirements;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="requirementTypeID", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="name", unique=true, nullable=false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "type", targetEntity = Property.class, cascade = CascadeType.ALL)
	public List<Property> getProperties() {
		return properties;
	}
	
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", targetEntity = Requirement.class)
	public List<Requirement> getRequirements() {
		return requirements;
	}
	
	public void setRequirements(List<Requirement> requirements) {
		this.requirements = requirements;
	}
}
