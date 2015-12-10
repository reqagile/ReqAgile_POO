package br.poo.com.reqagile.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

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
import br.poo.com.reqagile.model.UserRoles;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DataBaseConfigTest.class})
@Transactional
public class UserRolesTest extends AbstractTransactionalJUnit4SpringContextTests{

	@Autowired
	ProjectDAOTest projDAOT;
	
	@Autowired
	UserAccountDAOTest userDAOT;
	    
	@Autowired
	UserRolesDAO userRoles;  

	private UserRoles reqRole = new UserRoles();
	private UserRoles reqRole2 = new UserRoles();
	private UserRoles reqRoleAdm = new UserRoles();
	private UserRoles reqMidas = new UserRoles();
	private UserRoles reqMidas2 = new UserRoles();
	private UserRoles reqMidasAdm = new UserRoles();
	private UserRoles reqGame = new UserRoles();
	private UserRoles reqGame2 = new UserRoles();
	private UserRoles reqGameAdm = new UserRoles();

	
	@Test
	public void testSetarRoles(){
		this.reqRoleAdm.setUser(userDAOT.fulano);
		this.reqRoleAdm.setRole("ADMIN");
		this.reqRoleAdm.setProject(projDAOT.reqagile);
		
		this.reqRole.setUser(userDAOT.ciclano);
		this.reqRole.setProject(projDAOT.reqagile);
		
		this.reqRole2.setUser(userDAOT.beltrano);
		this.reqRole2.setProject(projDAOT.reqagile);
		
		this.reqMidasAdm.setUser(userDAOT.ciclano);
		this.reqMidasAdm.setRole("ADMIN");
		this.reqMidasAdm.setProject(projDAOT.midas);
		
		this.reqMidas.setUser(userDAOT.beltrano);
		this.reqMidas.setProject(projDAOT.midas);
		
		this.reqMidas2.setUser(userDAOT.fulano);
		this.reqMidas2.setProject(projDAOT.reqagile);
		
		this.reqGameAdm.setUser(userDAOT.beltrano);
		this.reqGameAdm.setRole("ADMIN");
		this.reqGameAdm.setProject(projDAOT.game);
		
		this.reqGame.setUser(userDAOT.fulano);
		this.reqGame.setProject(projDAOT.game);
		
		this.reqGame2.setUser(userDAOT.ciclano);
		this.reqGame2.setProject(projDAOT.reqagile);
	}
	
   /**
    * Cria os tres userRoles antes de cada um dos testes
    */
    @Before
    @Test
    public void testSave() {
    	projDAOT.testSave();
    	userDAOT.testSave();
    	testSetarRoles();
    	
    	userRoles.save(this.reqRoleAdm);
    	userRoles.save(this.reqRole);
    	userRoles.save(this.reqRole2);
    	userRoles.save(this.reqGameAdm);
    	userRoles.save(this.reqGame);
    	userRoles.save(this.reqGame2);
    	userRoles.save(this.reqMidasAdm);
    	userRoles.save(this.reqMidas);
    	userRoles.save(this.reqMidas2);
    }
    
    @Rollback
    @After
    @Test
    public void testDelete() throws Exception {
    	int idMid2, idReq2, idGame2;
		idMid2 = reqMidas2.getId();
		idReq2 = reqRole2.getId();
		idGame2 = reqGame2.getId();

		userRoles.delete(reqGame2);
		userRoles.delete(reqMidas2);
		userRoles.delete(reqRole2);
       
   		assertNull(userRoles.findById(idReq2));
   		assertNotEquals( userRoles.findById(reqRole.getId()) , idReq2);
  		assertNull(userRoles.findById(idMid2));
  		assertEquals( userRoles.findById(reqMidas.getId()) , idMid2);
  		assertNull(userRoles.findById(idGame2));
  		assertEquals( userRoles.findById(reqGame.getId()) , idGame2);

    }
    
    @Test
    public void testUpdateRole() throws Exception {
    	assertEquals(reqGame.getRole(), "USER");
    	assertNotEquals(reqGame.getRole(), "ADMIN");
    	assertEquals(reqGame2.getRole(), "USER");
    	assertNotEquals(reqGame2.getRole(), "ADMIN");
    	assertEquals(reqGameAdm.getRole(), "ADMIN");
    	assertNotEquals(reqGameAdm.getRole(), "USER");

    	assertEquals(reqRole.getRole(), "USER");
    	assertNotEquals(reqRole.getRole(), "ADMIN");
    	assertEquals(reqRole2.getRole(), "USER");
    	assertNotEquals(reqRole2.getRole(), "ADMIN");
    	assertEquals(reqRoleAdm.getRole(), "ADMIN");
    	assertNotEquals(reqRoleAdm.getRole(), "USER");
    	
    	assertEquals(reqMidas.getRole(), "USER");
    	assertNotEquals(reqMidas.getRole(), "ADMIN");
    	assertEquals(reqMidas2.getRole(), "USER");
    	assertNotEquals(reqMidas2.getRole(), "ADMIN");
    	assertEquals(reqMidasAdm.getRole(), "ADMIN");
    	assertNotEquals(reqMidasAdm.getRole(), "USER");

    	reqRole.setRole("ADMIN");
    	reqMidas.setRole("ADMIN");
    	reqGame.setRole("ADMIN");
    	reqRoleAdm.setRole("USER");
    	reqMidasAdm.setRole("USER");
    	reqGameAdm.setRole("USER");

    	userRoles.update(reqRole);
    	userRoles.update(reqMidas);
    	userRoles.update(reqGame);
    	userRoles.update(reqRoleAdm);
    	userRoles.update(reqGameAdm);
    	userRoles.update(reqMidasAdm);
    	
    	assertEquals(reqRole.getRole(), "ADMIN");
    	assertNotEquals(reqRole.getRole(), "USER");
    	
    	assertEquals(reqMidas.getRole(), "ADMIN");
    	assertNotEquals(reqMidas.getRole(), "USER");
    	
    	assertEquals(reqGame.getRole(), "ADMIN");
    	assertNotEquals(reqGame.getRole(), "USER");

    	assertEquals(reqGameAdm.getRole(), "USER");
    	assertNotEquals(reqGameAdm.getRole(), "ADMIN");

    	assertEquals(reqRoleAdm.getRole(), "USER");
    	assertNotEquals(reqRoleAdm.getRole(), "ADMIN");
    	

    	assertEquals(reqMidasAdm.getRole(), "USER");
    	assertNotEquals(reqMidasAdm.getRole(), "ADMIN");
    	
    }
    
}
