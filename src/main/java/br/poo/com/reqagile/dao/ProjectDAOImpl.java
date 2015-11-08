package br.poo.com.reqagile.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import br.poo.com.reqagile.model.Project;

/**
 * 
 * @author Ana
 *
 */

@Repository("projectDao")
@Transactional
public class ProjectDAOImpl extends CustomHibernateDaoSupport implements ProjectDAO {
	public void save(Project project) {
		getHibernateTemplate().save(project);		
	}

	public void update(Project project) {
		getHibernateTemplate().update(project);
		
	}

	public void delete(Project project) {
		getHibernateTemplate().delete(project);
	}

	public Project findById(Integer id) throws Exception {
		List<?> list = getHibernateTemplate().find(
		"from Project where idProjeto=?",id);
		
		if(!list.isEmpty()) return (Project)list.get(0);
		else {
			throw new Exception("Projeto nao encontrado");
		}
	}

	public Project findByTitle(String title) throws Exception {
		List<?> list = getHibernateTemplate().find(
				"from Project where titulo=?",title);
				
		if(!list.isEmpty()) return (Project)list.get(0);
		else {
			throw new Exception("Projeto nao encontrado");
		}
	}

	public List<Project> list() {
		@SuppressWarnings("unchecked")
		List<Project> listProject = (List<Project>) getSessionFactory().getCurrentSession().
				createCriteria(Project.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listProject;
	}

	/**
	 * 
	 * @param id do projeto
	 * @return uma lista com os ids dos usuarios que fazem parte do projeto
	 * @throws Exception
	 */
	public List<?> listTeamMembers(Integer id) throws Exception {
		List<?> userAccountIdList = getHibernateTemplate().find("select UserAccount.idUser "
				+ "from Project, Role, UserAccount "
				+ "where Role.idUser=UserAccount.idUser "
				+ "and Project.idProjetot=Role.idProject "
				+ "and Project.idProjeto=?",id);
		
		
		return userAccountIdList;
	}

}

