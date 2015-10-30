package br.poo.com.reqagile.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.poo.com.reqagile.model.UserAccount;

@Repository("userAccountDao")
@Transactional
public class UserAccountDaoImpl extends CustomHibernateDaoSupport implements UserAccountDao{

	public void save(UserAccount user) {
		getHibernateTemplate().save(user);
		
	}
	
	public void update(UserAccount user) {
		getHibernateTemplate().update(user);
	}

	public void delete(UserAccount user) {
		getHibernateTemplate().delete(user);
		
	}

	public UserAccount findById(Integer id) {
		List<?> list = getHibernateTemplate().find(
		"from usuario where idUser=?",id);
		
		return (UserAccount)list.get(0);
	}

	public UserAccount findByEmail(String email) {
		List<?> list = getHibernateTemplate().find(
				"from usuario where email=?",email);
		
		return (UserAccount)list.get(0);
	}

	public UserAccount findByLogin(String login) {
		List<?> list = getHibernateTemplate().find(
				"from usuario where login=?",login);
		
		return (UserAccount)list.get(0);
	}

    public List<UserAccount> list() {
		@SuppressWarnings("unchecked")
		List<UserAccount> listUser = (List<UserAccount>) getSessionFactory().getCurrentSession().
				createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listUser;
    }
}
