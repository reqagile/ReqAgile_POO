package br.poo.com.reqagile.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.Requirement;
import br.poo.com.reqagile.model.UserAccount;

/**
 * 
 * @author Ana
 *
 */

@Repository("projectDao")
@Transactional
public class ProjectDAOImpl extends GenericDAOImplAbstract<Integer, Project> implements ProjectDAO {
	
	public Project findByTitle(String title) throws Exception {
			Query query= currentSession().createQuery("from Project where title=:title");
			query.setParameter("title", title);
			
			return (Project) query.uniqueResult();
			
	}

	/**
	 * 
	 * @param id do projeto
	 * @return uma lista com os ids dos usuarios que fazem parte do projeto
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<UserAccount> listTeamMembers(Integer id) throws Exception {
		List<?> userAccountIdList = getHibernateTemplate().find("us from UserRoles ur, "
				+ "User us "
				+ "where ur.user = us.id "
				+ "and ur.project = ?",id);
		
		
		return (List<UserAccount>) userAccountIdList;
	}

	/**
	 * 
	 * @param id do projeto
	 * @return uma lista com os ids dos usuarios que fazem parte do projeto
	 */
	@SuppressWarnings("unchecked")
	public List<Requirement> listRequirement(Integer id) {
		List<?> requirementList = getHibernateTemplate().find("from Requirement r,"
				+ "where r.project = ?",id);
		
		
		return (List<Requirement>) requirementList;
	}

}

