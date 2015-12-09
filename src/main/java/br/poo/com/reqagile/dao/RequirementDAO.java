package br.poo.com.reqagile.dao;

import br.poo.com.reqagile.model.Requirement;

/**
 * Interface que fornece a assinatura dos metodos peculiares para
 * classes de Requeriment que possam implementar tais metodos na
 * persistencia.
 * 
 *@author Wellington Stanley
 * */
public interface RequirementDAO extends GenericDAO<Integer, Requirement> {

	Requirement findByName(String nome) throws Exception;
	
	
}
