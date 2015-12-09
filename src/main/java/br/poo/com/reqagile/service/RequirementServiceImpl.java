package br.poo.com.reqagile.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.poo.com.reqagile.dao.RequirementDAO;
import br.poo.com.reqagile.model.Requirement;

public class RequirementServiceImpl extends GenericServiceImplAbstract<Integer, Requirement>
		implements RequirementService{
	@Autowired
	RequirementDAO requirementDAO;

	@Override
	public Requirement findByTitle(String nome) throws Exception {
		try {
			return requirementDAO.findByName(nome);			
		} catch (Exception e) {
			throw new Exception("Erro ao pesquisar requisito por nome", e);
		}
	}
	

}
