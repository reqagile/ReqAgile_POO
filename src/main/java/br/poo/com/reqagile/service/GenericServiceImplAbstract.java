package br.poo.com.reqagile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.poo.com.reqagile.dao.GenericDAO;

@Service()
@Transactional(propagation = Propagation.REQUIRED)
public abstract class GenericServiceImplAbstract<PK,T> implements GenericService<PK, T> {

	@Autowired
    private GenericDAO<PK, T> genericDao;

    public void save(T entity) {
        genericDao.save(entity);
    }
 
    public void update(T entity){
    	genericDao.update(entity);
    }

    public void delete(T entity) {
    	genericDao.delete(entity);
    }
    
    public T findById(PK id) {
    	return genericDao.findById(id);
    }

    public List<T> list() {
        return genericDao.list();
    }

}