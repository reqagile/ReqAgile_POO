package br.poo.com.reqagile.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.poo.com.reqagile.model.UserAccount;

@Repository("userAccountDao")
public class UserAccountDaoImpl extends CustomHibernateDaoSupport implements UserAccountDao{

	@Transactional
	public void save(UserAccount user) {
		getHibernateTemplate().save(user);
		
	}
	
	@Transactional
	public void update(UserAccount user) {
		getHibernateTemplate().update(user);
	}

	@Transactional
	public void delete(UserAccount user) {
		getHibernateTemplate().delete(user);
		
	}

	@Transactional
	public UserAccount findById(Integer id) {
		List<?> list = getHibernateTemplate().find(
		"from usuario where idUser=?",id);
		
		return (UserAccount)list.get(0);
	}

	@Transactional
	public UserAccount findByEmail(String email) {
		List<?> list = getHibernateTemplate().find(
				"from usuario where email=?",email);
		
		return (UserAccount)list.get(0);
	}

	@Transactional
	public UserAccount findByLogin(String login) {
		List<?> list = getHibernateTemplate().find(
				"from usuario where login=?",login);
		
		return (UserAccount)list.get(0);
	}

    @Transactional
    public List<UserAccount> list() {
		@SuppressWarnings("unchecked")
		List<UserAccount> listUser = (List<UserAccount>) getSessionFactory().getCurrentSession().
				createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listUser;
    }
}
