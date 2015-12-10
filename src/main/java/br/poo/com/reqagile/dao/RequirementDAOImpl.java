package br.poo.com.reqagile.dao;

import org.hibernate.Query;

import br.poo.com.reqagile.model.Requirement;

public class RequirementDAOImpl extends GenericDAOImplAbstract<Integer, Requirement>
	implements RequirementDAO{

	public Requirement findByName(String nome) throws Exception {
			Query query= currentSession().createQuery("from Requirement where nome=:nome");
			query.setParameter("nome", nome);
			
			return (Requirement) query.uniqueResult();
			
	}
	

}
