package br.poo.com.reqagile.dao;

import static org.junit.Assert.*;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	Project reqagile = new Project("reqagile","descricao");
	Project midas = new Project("midas","descricao");
	Project game = new Project("game","descricao");
	
	@Autowired
	ProjectDAO projectDao;
	
	@Before
    @Test
    public void testSave() {
    	projectDao.save(reqagile);
    	projectDao.save(midas);
    	projectDao.save(game);
    }
	
	@After
    @Test
    public void testDelete() throws Exception {
       projectDao.delete(reqagile);
       projectDao.delete(midas);
       projectDao.delete(game);
       
       try {
       		projectDao.findById(reqagile.getId());
       } catch(Exception e) {
       		System.out.println("projeto de id = " + reqagile.getId()+ " apagado com sucesso");
       }
       
       try {
      		projectDao.findById(midas.getId());
      } catch(Exception e) {
      		System.out.println("projeto de id = " + midas.getId()+ " apagado com sucesso");
      }
       
       try {
      		projectDao.findById(game.getId());
      } catch(Exception e) {
      		System.out.println("projeto de id = " + game.getId()+ " apagado com sucesso");
      }
    }
	
	@Test 
    public void testFindById() throws Exception {
    	assertEquals(reqagile.toString(),projectDao.findById(reqagile.getId()).toString());
    	assertNotEquals(reqagile.toString(),projectDao.findById(midas.getId()).toString());
    	assertNotEquals(reqagile.toString(),projectDao.findById(game.getId()).toString());
    	
        assertEquals(midas.toString(),projectDao.findById(midas.getId()).toString());
        assertEquals(game.toString(),projectDao.findById(game.getId()).toString());

        try {
        	projectDao.findById(1001);
        } catch(Exception e) {
        	System.out.println("id nao existe");
        }
    }

    @Test
    public void testFindByTitle() throws Exception {
    	assertEquals(reqagile.toString(),projectDao.findByTitle("reqagile").toString());
        assertEquals(midas.toString(),projectDao.findByTitle("midas").toString());
        assertEquals(game.toString(),projectDao.findByTitle("game").toString());
        
        try {
        	projectDao.findByTitle("titulo_que_nao_existe");
        } catch(Exception e) {
        	System.out.println("titulo nao existe");
        }
    }  
    
    @Test
    public void testUpdateTitle() throws Exception {
    	assertEquals(reqagile.toString(),projectDao.findByTitle("reqagile").toString());
        assertEquals(midas.toString(),projectDao.findByTitle("midas").toString());
        assertEquals(game.toString(),projectDao.findByTitle("game").toString());
    	
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
        	projectDao.findByTitle("reqagile");
        } catch(Exception e) {
        	System.out.println("Titulo nao existe");
        }
        
        try {
        	projectDao.findByTitle("midas");
        } catch(Exception e) {
        	System.out.println("Titulo nao existe");
        }
        
        try {
        	projectDao.findByTitle("game");
        } catch(Exception e) {
        	System.out.println("Titulo nao existe");
        }
    }
}
