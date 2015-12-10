package br.poo.com.reqagile.dao;

public interface GenericDAO<PK,T> {
	public void save(T entity);

	public void update(T entity);

	public void delete(T entity);

	public T findById(PK id);

//	T findByLogin(String login);

}