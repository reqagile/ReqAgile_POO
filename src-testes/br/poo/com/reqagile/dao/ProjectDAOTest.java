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
import br.poo.com.reqagile.model.Project;

/**
 * 
 * @author Ana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DataBaseConfigTest.class})
@Transactional
public class ProjectDAOTest extends AbstractTransactionalJUnit4SpringContextTests {    
	
	Project reqagile = new Project();
	Project midas = new Project();
	Project game = new Project();
	
	@Autowired
	ProjectDAO projectDao;
	
	@Before
    @Test
    public void testSave() {
		reqagile.setTitle("REQ");
		reqagile.setDescription("Projeto Req");
		midas.setTitle("MIDAS");
		midas.setDescription("Projeto Midas");
		game.setTitle("GAME");
		game.setDescription("Projeto GAME");
    	projectDao.save(reqagile);
    	projectDao.save(midas);
    	projectDao.save(game);
    }
	
	@Rollback
	@After
    @Test
    public void testDelete() throws Exception {
		int idReq, idMidas, idGame;
		idReq = reqagile.getId();
		idMidas = midas.getId();
		idGame = game.getId();
		projectDao.delete(reqagile);
		projectDao.delete(midas);
		projectDao.delete(game);
       
       	assertNull(projectDao.findById(idReq));
       
      	assertNull(projectDao.findById(idMidas));
      	
      	assertNull(projectDao.findById(idGame));
    }
	
	@Test 
    public void testFindById() throws Exception {
    	assertEquals(reqagile.toString(),projectDao.findById(reqagile.getId()).toString());
    	assertNotEquals(reqagile.toString(),projectDao.findById(midas.getId()).toString());
    	assertNotEquals(reqagile.toString(),projectDao.findById(game.getId()).toString());
    	
        assertEquals(midas.toString(),projectDao.findById(midas.getId()).toString());
        assertEquals(game.toString(),projectDao.findById(game.getId()).toString());

        try {
        	assertNull(projectDao.findById(1001));
        } catch(Exception e) {
        	System.out.println("id nao existe");
        }
    }

    @Test
    public void testFindByTitle() throws Exception {
    	assertEquals(reqagile.toString(),projectDao.findByTitle("REQ").toString());
        assertEquals(midas.toString(),projectDao.findByTitle("MIDAS").toString());
        assertEquals(game.toString(),projectDao.findByTitle("GAME").toString());
        
        try {
        	projectDao.findByTitle("titulo_que_nao_existe");
        } catch(Exception e) {
        	System.out.println("titulo nao existe");
        }
    }  
    
    @Test
    public void testUpdateTitle() throws Exception {
    	assertEquals(reqagile.toString(),projectDao.findByTitle("REQ").toString());
        assertEquals(midas.toString(),projectDao.findByTitle("MIDAS").toString());
        assertEquals(game.toString(),projectDao.findByTitle("GAME").toString());
    	
    	reqagile.setTitle("novo_reqagile");
    	midas.setTitle("novo_midas");
    	game.setTitle("novo_game");
    	
    	projectDao.update(reqagile);
    	projectDao.update(midas);
    	projectDao.update(game);
    	
    	assertEquals(reqagile.toString(),projectDao.findByTitle("novo_reqagile").toString());
        assertEquals(midas.toString(),projectDao.findByTitle("novo_midas").toString());
        assertEquals(game.toString(),projectDao.findByTitle("novo_game").toString());
        
        try {
        	assertNull(projectDao.findByTitle("reqagile"));
        } catch(Exception e) {
        	System.out.println("Titulo nao existe");
        }
        
        try {
        	assertNull(projectDao.findByTitle("midas"));
        } catch(Exception e) {
        	System.out.println("Titulo nao existe");
        }
        
        try {
        	assertNull(projectDao.findByTitle("game"));
        } catch(Exception e) {
        	System.out.println("Titulo nao existe");
        }
    }
}
