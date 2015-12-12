package br.poo.com.reqagile.service;

import br.poo.com.reqagile.model.Requirement;

public interface RequirementService extends GenericService<Integer, Requirement>{

	public Requirement findByTitle(String nome) throws Exception;

}
