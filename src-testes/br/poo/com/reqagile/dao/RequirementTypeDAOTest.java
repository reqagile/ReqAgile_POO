package br.poo.com.reqagile.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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
import br.poo.com.reqagile.model.RequirementType;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DataBaseConfigTest.class})
@Transactional
public class RequirementTypeDAOTest extends AbstractTransactionalJUnit4SpringContextTests {

	RequirementType userStory = new RequirementType();
	RequirementType useCase = new RequirementType();
	
	List<Property> propsUS = new ArrayList<Property>();
	List<Property> propsUC = new ArrayList<Property>();
	
	@Autowired
	RequirementTypeDAO rtDAO;
	
	public void createProperties() {
		
		Property propUS1 = new Property();
		Property propUS2 = new Property();
		Property propUC1 = new Property();
		Property propUC2 = new Property();
		
		propUS1.setDescription("Propriedade de User Story 1");
		propUS2.setDescription("Propriedade de User Story 2");
		propUC1.setDescription("Propriedade de Use Case 1");
		propUC2.setDescription("Propriedade de Use Case 2");
		
		propsUS.add(propUS1);
		propsUS.add(propUS2);
		
		propsUC.add(propUC1);
		propsUC.add(propUC2);
		
	}
	
	@Test
	public void testSetGet() {
//		TODO: Setar todos os campos obrigatórios.
		createProperties();
		
		String userStoryName = new String("User Story");
		String useCaseName = new String("Use Case");
		
		userStory.setName(userStoryName);
		userStory.setProperties(propsUS);
		useCase.setName(useCaseName);
		useCase.setProperties(propsUC);
		
		assertEquals(userStoryName, userStory.getName());
		assertEquals(useCaseName, useCase.getName());
		assertEquals(propsUS, userStory.getProperties());
		assertEquals(propsUC, useCase.getProperties());
		
	}
	
	@Before
	@Test
	public void testSave() {
//	Provavelmente está falhando provavelmente porque um campo obrigatório
//	não foi setado em testSetGet().
		
		testSetGet();
		
		rtDAO.save(userStory);
		rtDAO.save(useCase);
		
		assertNotNull(userStory.getId());
		assertNotNull(useCase.getId());
	}
	
	@Rollback
	@After
	@Test
	public void testDelete() {
		Integer usID = userStory.getId();
		Integer ucID = useCase.getId();
		
		rtDAO.delete(userStory);
		rtDAO.delete(useCase);
		
		assertNull(rtDAO.findById(usID));
		assertNull(rtDAO.findById(ucID));
	}
	
	@Test
	public void testFindById() {
		assertEquals(userStory, rtDAO.findById(userStory.getId()));
		assertEquals(useCase, rtDAO.findById(useCase.getId()));
		assertNotEquals(userStory, rtDAO.findById(useCase.getId()));
		assertNotEquals(useCase, rtDAO.findById(userStory.getId()));
		
		Integer fakeID = (userStory.getId() + useCase.getId())*2;
		assertNull(rtDAO.findById(fakeID));
	}
	
	@Test
	public void testUpdateName() {
		String usNameOld = userStory.getName();
		String usNameNew = "Novo " + usNameOld;
		
		assertEquals(usNameOld, rtDAO.findById(userStory.getId()).getName());
		userStory.setName(usNameNew);
		rtDAO.update(userStory);
		assertEquals(usNameNew, rtDAO.findById(userStory.getId()).getName());
	}
	
	@Test
	public void testUpdateProperties() {
		List<Property> oldProps = useCase.getProperties();
		List<Property> newProps = new ArrayList<Property>();
		
		Property newProp1 = new Property();
		Property newProp2 = new Property();
		
		newProp1.setDescription("New Use Case property 1");
		newProp2.setDescription("New Use Case property 2");
		newProps.add(newProp1);
		newProps.add(newProp2);
		
		assertEquals(oldProps, rtDAO.findById(useCase.getId()).getProperties());
		useCase.setProperties(newProps);
		rtDAO.update(useCase);
		assertEquals(newProps, rtDAO.findById(useCase.getId()).getProperties());
	}
	
}
