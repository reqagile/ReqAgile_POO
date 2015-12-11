package br.poo.com.reqagile.dao;

import static org.junit.Assert.*;

import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.poo.com.reqagile.config.DataBaseConfigTest;
import br.poo.com.reqagile.model.Property;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DataBaseConfigTest.class})
@Transactional
public class PropertyDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	Property prop = new Property();
	Property prop2 = new Property();
	
	@Autowired
	PropretyDAO pDAO;
	
	public void testSetDescription() {
		String p = new String("Descricao da propriedade.");
		String p2 = new String("Segunda propriedade.");
		
		this.prop.setDescription(p);
		this.prop2.setDescription(p2);
		
		assertEquals(p, prop.getDescription());
		assertEquals(p2, prop2.getDescription());
	}
	
	@Before
	@Test
	public void testSave() {
		testSetDescription();
		pDAO.save(prop);
		pDAO.save(prop2);
	}
	
	@Rollback
	@After
	@Test
	public void testDelete() {
		Integer id = prop.getId();
		pDAO.delete(prop);
		assertNull(pDAO.findById(id));
		
		id = prop2.getId();
		pDAO.delete(prop2);
		assertNull(pDAO.findById(id));
	}
	
	@Test
	public void testFindById() {
		assertEquals(prop, pDAO.findById(prop.getId()));
		assertNotEquals(prop2, pDAO.findById(prop.getId()));
		assertNotEquals(prop, pDAO.findById(prop2.getId()));
		assertEquals(prop2, pDAO.findById(prop2.getId()));
		
		Integer fakeID = (prop.getId() + prop2.getId())*2;
		assertNull(pDAO.findById(fakeID));
	}
	
	@Test
	public void testUpdateDescription() {
		String descAntes = prop.getDescription();
		String descDepois = new String("Nova descricao...");
		
		assertEquals(descAntes, pDAO.findById(prop.getId()).getDescription());
		prop.setDescription(descDepois);
		pDAO.update(prop);
		assertEquals(descDepois, pDAO.findById(prop.getId()).getDescription());
	}

}
