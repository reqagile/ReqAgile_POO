package br.poo.com.reqagile.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe responsavel por implementar os metodos em comum
 * de todas as DAOs(Data Access Object). Por este motivo ela
 * esta parametrizada pelos objetos PK e T, que normalmente sera um id
 * e uma classe que iremos trabalhar com suas operacoes adicionais e peculiares,
 * por exemplo, UserAccount e Projeto. 
 * 
 * @author Wellington Stanley
 * 
 * */

@Repository("GenericDAO")
@Transactional
public abstract class GenericDAOImplAbstract<PK extends Serializable,T> extends CustomHibernateDaoSupport
	implements GenericDAO<PK, T>{

	protected Class<T> daoType;
    
    @SuppressWarnings("unchecked")
    public GenericDAOImplAbstract(){
        this.daoType =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
	
    public T findById(PK key) {
        return (T) getHibernateTemplate().get(daoType, key);
    }
 
    public void save(T entity) {
        getHibernateTemplate().persist(entity);
    }
 
    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }
	
    public void update(T entity) {
		getHibernateTemplate().update(entity);
	}
	
	
/*    public List<UserAccount> list() {
		@SuppressWarnings("unchecked")
		List<UserAccount> listUser = (List<UserAccount>) getSessionFactory().getCurrentSession().
				createCriteria(UserAccount.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	    return listUser;
    }*/

}
