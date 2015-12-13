package br.poo.com.reqagile.service;

public interface GenericService<PK,T> {
	
	public void save(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findById(PK id);

}
