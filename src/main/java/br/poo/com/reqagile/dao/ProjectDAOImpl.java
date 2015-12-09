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
	
	public Project findByEmail(Integer id) {		
		Query query= currentSession().createQuery("from Project where id=:id");
		query.setParameter("id", id);
		
		return (Project) query.uniqueResult();
	}

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
		List<?> userAccountIdList = getHibernateTemplate().find("select UserAccount "
				+ "from Project p, UserRoles r, UserAccount u"
				+ "where r.userID = u.id "
				+ "and p.projetoID = p.id "
				+ "and p.id=?",id);
		
		
		return (List<UserAccount>) userAccountIdList;
	}

	/**
	 * 
	 * @param id do projeto
	 * @return uma lista com os ids dos usuarios que fazem parte do projeto
	 */
	@SuppressWarnings("unchecked")
	public List<Requirement> listRequirement(Integer id) {
		List<?> requirementList = getHibernateTemplate().find("select Requirement "
				+ "from Project p"
				+ "where p.id=?",id);
		
		
		return (List<Requirement>) requirementList;
	}

}

