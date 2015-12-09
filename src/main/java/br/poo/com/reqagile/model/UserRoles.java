package br.poo.com.reqagile.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER_ROLES")
public class UserRoles {
	
	private Integer id;
	private UserAccount user;
	private String role;
	private Project project;

/*	CREATE TABLE `user_roles` (  
			  `USER_ROLE_ID` int(10) unsigned NOT NULL,  
			  `USER_ID` int(10) unsigned NOT NULL,  
			  `AUTHORITY` varchar(45) NOT NULL,  
			  PRIMARY KEY  (`USER_ROLE_ID`),  
			  KEY `FK_user_roles` (`USER_ID`),  
			  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)*/
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userRolesID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userID")
	public UserAccount getUser() {
		return user;
	}
	
	public void setUser(UserAccount user) {
		this.user = user;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "projectID")
	public Project getProject() {
		return project;
	}
	
	public void setProject(Project project) {
		this.project = project;
	}
	
	@Column(name = "role", unique = true, nullable = false, columnDefinition = "varchar(255) default 'ROLE_USER'")
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}

}
