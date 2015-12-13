package br.poo.com.reqagile.dao;

import org.springframework.stereotype.Repository;

import br.poo.com.reqagile.model.RequirementType;

@Repository("RequirementTypeDAO")
public class RequirementTypeDAOImpl extends GenericDAOImplAbstract<Integer, RequirementType>
	implements RequirementTypeDAO {

}
