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
@Table(name = "PROPERTY")
public class Property {
	private Integer id;
	private String description;
	private RequirementType type;
	
/*	@ManyToOne
    @JoinColumn(name = "requirementTypeID")
	private RequirementType requirementType;*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="propertyID", unique=true, nullable=false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="description", unique=true, nullable=false)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne
    @JoinColumn(name="requirementTypeID")
	public RequirementType getType() {
		return type;
	}
	
	public void setType(RequirementType type) {
		this.type = type;
	}
}
