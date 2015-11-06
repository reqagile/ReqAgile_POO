package br.poo.com.reqagile.service;

import java.util.List;

public interface GenericService<PK,T> {
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findById(PK id);
	
	public List<T> list(); 
}
