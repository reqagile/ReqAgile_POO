package br.poo.com.reqagile.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.poo.com.reqagile.model.UserAccount;

@Repository("userAccountDao")
@Transactional
public class UserAccountDAOImpl extends CustomHibernateDaoSupport implements UserAccountDAO{

	public void save(UserAccount user) {
		getHibernateTemplate().save(user);
		
	}
	
	public void update(UserAccount user) {
		getHibernateTemplate().update(user);
	}

	public void delete(UserAccount user) {
		getHibernateTemplate().delete(user);
		
	}

	public UserAccount findById(Integer id) throws Exception {
		List<?> list = getHibernateTemplate().find(
			"from UserAccount where idUser=?",id);
				
		if(!list.isEmpty()) return (UserAccount)list.get(0);
			else {
				throw new Exception("Usuario nao encontrado");
			}
	}

	public UserAccount findByEmail(String email) throws Exception {
		List<?> list = getHibernateTemplate().find(
				"from UserAccount where email=?",email);
		
		if(!list.isEmpty()) return (UserAccount)list.get(0);
		else {
			throw new Exception("Usuario nao encontrado");
		}
	}

	public UserAccount findByLogin(String login) throws Exception {
		List<?> list = getHibernateTemplate().find(
				"from UserAccount where login=?",login);
		
		if(!list.isEmpty()) return (UserAccount)list.get(0);
		else {
			throw new Exception("Usuario nao encontrado");
		}
	}

    public List<UserAccount> list() {
		@SuppressWarnings("unchecked")
		List<UserAccount> listUser = (List<UserAccount>) getSessionFactory().getCurrentSession().
				createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listUser;
    }
}
