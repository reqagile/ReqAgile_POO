package br.poo.com.reqagile.dao;

import static org.junit.Assert.*;
import javax.transaction.Transactional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import br.poo.com.reqagile.config.DataBaseConfigTest;
import br.poo.com.reqagile.model.UserAccount;

/**
 * 
 * @author Ana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes={DataBaseConfigTest.class})
@Transactional
public class UserAccountDAOTest extends AbstractTransactionalJUnit4SpringContextTests {    	
	UserAccount fulano = new UserAccount();
    UserAccount ciclano = new UserAccount();
    UserAccount beltrano = new UserAccount();
    
    @Autowired
    UserAccountDAO userAccountDAO;  

    public void testCriarUsuarios(){
    	fulano.setName("fulano");
    	fulano.setLogin("fulano_login");
    	fulano.setPassword("fulano123");
    	fulano.setEmail("fulano@email.com");

    	ciclano.setName("ciclano");
    	ciclano.setLogin("ciclano_login");
    	ciclano.setPassword("ciclano123");
    	ciclano.setEmail("ciclano@email.com");
 
    	beltrano.setName("beltrano");
    	beltrano.setLogin("beltrano_login");
    	beltrano.setPassword("beltrano123");
    	beltrano.setEmail("beltrano@email.com");
    }
    
   /**
    * Cria os tres usuarios antes de cada um dos testes
    */
    @Before
    @Test
    public void testSave() {
    	testCriarUsuarios();
    	userAccountDAO.save(fulano);
    	userAccountDAO.save(ciclano);
    	userAccountDAO.save(beltrano);
    }
    
    /**
     * Deleta os usuarios criados depois de cada um dos testes e entao testa se consegue encontra-los
     * por meio de seus ids
     */
    @Rollback
    @After
    @Test
    public void testDelete() throws Exception {
    	int idFul, idCil, idBel;
		idFul = fulano.getId();
		idCil = ciclano.getId();
		idBel = beltrano.getId();
		userAccountDAO.delete(fulano);
		userAccountDAO.delete(ciclano);
		userAccountDAO.delete(beltrano);
       
       try {
       		assertNull(userAccountDAO.findById(idFul));
       } catch(Exception e) {
       		System.out.println("usuario de id = " + idFul + " apagado com sucesso");
       }
       
       try {
      		assertNull(userAccountDAO.findById(idCil));
      } catch(Exception e) {
      		System.out.println("usuario de id = " + idCil + " apagado com sucesso");
      }
       
       try {
      		assertNull(userAccountDAO.findById(idBel));
      } catch(Exception e) {
      		System.out.println("usuario de id = " + idBel + " apagado com sucesso");
      }
    }
    
    @Test 
    public void testFindById() throws Exception {
    	assertEquals(fulano.toString(),userAccountDAO.findById(fulano.getId()).toString());
    	assertNotEquals(fulano.toString(),userAccountDAO.findById(ciclano.getId()).toString());
    	assertNotEquals(fulano.toString(),userAccountDAO.findById(beltrano.getId()).toString());
    	
        assertEquals(ciclano.toString(),userAccountDAO.findById(ciclano.getId()).toString());
        assertEquals(beltrano.toString(),userAccountDAO.findById(beltrano.getId()).toString());

        try {
        	userAccountDAO.findById(1001);
        } catch(Exception e) {
        	System.out.println("id_que_nao_existe");
        }
    }

    @Test
    public void testFindByEmail() throws Exception {
    	assertEquals(fulano.toString(),userAccountDAO.findByEmail("fulano@email.com").toString());
        assertEquals(ciclano.toString(),userAccountDAO.findByEmail("ciclano@email.com").toString());
        assertEquals(beltrano.toString(),userAccountDAO.findByEmail("beltrano@email.com").toString());
        
        try {
        	assertNull(userAccountDAO.findByEmail("email_que_nao_existe"));
        } catch(Exception e) {
        	System.out.println("email nao existe");
        }
    }  
    
    @Test
    public void testFindByLogin() throws Exception {
    	assertEquals(fulano.toString(),userAccountDAO.findByLogin("fulano_login").toString());
    	assertNotEquals(fulano.toString(),userAccountDAO.findByLogin("ciclano_login").toString());
    	assertNotEquals(fulano.toString(),userAccountDAO.findByLogin("beltrano_login").toString());
    	
    	assertEquals(ciclano.toString(),userAccountDAO.findByLogin("ciclano_login").toString());
    	assertEquals(beltrano.toString(),userAccountDAO.findByLogin("beltrano_login").toString());
        
        try {
        	userAccountDAO.findByLogin("login_que_nao_existe");
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
    }
    
    @Test
    public void testUpdateEmail() throws Exception {
    	
    	assertEquals(fulano.toString(),userAccountDAO.findByEmail("fulano@email.com").toString());
        assertEquals(ciclano.toString(),userAccountDAO.findByEmail("ciclano@email.com").toString());
        assertEquals(beltrano.toString(),userAccountDAO.findByEmail("beltrano@email.com").toString());
    	
    	fulano.setEmail("novo_fulano@email.com");
    	ciclano.setEmail("novo_ciclano@email.com");
    	beltrano.setEmail("novo_beltrano@email.com");
    	
    	userAccountDAO.update(fulano);
    	userAccountDAO.update(ciclano);
    	userAccountDAO.update(beltrano);
    	
    	assertEquals(fulano.toString(),userAccountDAO.findByEmail("novo_fulano@email.com").toString());
        assertEquals(ciclano.toString(),userAccountDAO.findByEmail("novo_ciclano@email.com").toString());
        assertEquals(beltrano.toString(),userAccountDAO.findByEmail("novo_beltrano@email.com").toString());
        
        try {
        	assertNull(userAccountDAO.findByEmail("fulano@email.com"));
        } catch(Exception e) {
        	System.out.println("email nao existe");
        }
        
        try {
        	assertNull(userAccountDAO.findByEmail("ciclano@email.com"));
        } catch(Exception e) {
        	System.out.println("email nao existe");
        }
        
        try {
        	assertNull(userAccountDAO.findByEmail("beltrano@email.com"));
        } catch(Exception e) {
        	System.out.println("email nao existe");
        }
    	
    }
    
    @Test
    public void testUpdateLogin() throws Exception {
    	
    	assertEquals(fulano.toString(),userAccountDAO.findByLogin("fulano_login").toString());
        assertEquals(ciclano.toString(),userAccountDAO.findByLogin("ciclano_login").toString());
        assertEquals(beltrano.toString(),userAccountDAO.findByLogin("beltrano_login").toString());
    	
    	fulano.setLogin("novo_fulano_login");
    	ciclano.setLogin("novo_ciclano_login");
    	beltrano.setLogin("novo_beltrano_login");
    	
    	userAccountDAO.update(fulano);
    	userAccountDAO.update(ciclano);
    	userAccountDAO.update(beltrano);
    	
    	assertEquals(fulano.toString(),userAccountDAO.findByLogin("novo_fulano_login").toString());
        assertEquals(ciclano.toString(),userAccountDAO.findByLogin("novo_ciclano_login").toString());
        assertEquals(beltrano.toString(),userAccountDAO.findByLogin("novo_beltrano_login").toString());
        
        try {
        	assertNull(userAccountDAO.findByLogin("fulano_login"));
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
        
        try {
        	assertNull(userAccountDAO.findByLogin("ciclano_login"));
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
        
        try {
        	assertNull(userAccountDAO.findByLogin("beltrano_login"));
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
    	
    }
}