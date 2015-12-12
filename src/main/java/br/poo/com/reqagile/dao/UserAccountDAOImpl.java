package br.poo.com.reqagile.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.poo.com.reqagile.model.Project;
import br.poo.com.reqagile.model.UserAccount;

@Repository("UserAccountDAO")
@Transactional
public class UserAccountDAOImpl extends GenericDAOImplAbstract<Integer, UserAccount>
	implements UserAccountDAO{

	public UserAccount findByEmail(String email) {		
		Query query= currentSession().createQuery("from UserAccount where email=:email");
		query.setParameter("email", email);
		
		return (UserAccount) query.uniqueResult();
	}
	
	public UserAccount findByLogin(String login) {

		Query query= currentSession().createQuery("from UserAccount where login=:login");
		query.setParameter("login", login);
		
		return (UserAccount) query.uniqueResult();
	}

	public UserAccount findByName(String name) {
		Query query= currentSession().createQuery("from UserAccount where name=:name");
		query.setParameter("name", name);
		
		return (UserAccount) query.uniqueResult();
		
	}

    public boolean isUserRegistered(String userName, String password) {
        /*You can use any character instead of 'A'. If a record is found, 
        only single character, in this example 'A', will return from database
        
        Query employeeTaskQuery = currentSession().createQuery(
                "select 'A' from Admin u where username=:username and password=:password");
        employeeTaskQuery.setParameter("username", userName);
        employeeTaskQuery.setParameter("password", password); */
        return true;
    }
    
    @Override
	@SuppressWarnings("unchecked")
	public List<UserAccount> list() {
    	return currentSession().createCriteria(daoType).list();
	}
    

	/**
	 * 
	 * @param id do usuario
	 * @return uma lista com os projetos que o usuario faz parte
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<Project> listProject(Integer id) throws Exception {
		List<?> projectList = getHibernateTemplate().find("pj from UserRoles ur, "
				+ "Project pj "
				+ "where ur.project = pj.id "
				+ "and ur.project = ?",id);
		
		
		return (List<Project>) projectList;
	}
 
/*    @Override
    public Admin getAdmin(String username) {
        Query query = currentSession().createQuery(
                "from Admin " +
                        "where username=:username");
        query.setParameter("username", username);
        return (Admin) query.uniqueResult();
 
    }*/
	
}