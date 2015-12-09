package br.poo.com.reqagile.service;

import br.poo.com.reqagile.model.Requirement;

public interface RequirementService extends GenericService<Integer, Requirement>{

	Requirement findByTitle(String nome) throws Exception;

}
