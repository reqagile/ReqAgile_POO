package br.poo.com.reqagile.dao;

import org.springframework.stereotype.Repository;

import br.poo.com.reqagile.model.Property;

@Repository("PropertyDAO")
public class PropertyDAOImpl extends GenericDAOImplAbstract<Integer, Property> implements PropretyDAO {
	
}
