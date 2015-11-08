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
	UserAccount fulano = new UserAccount("fulano","fulano_login","fulano123","fulano@email.com");
    UserAccount ciclano = new UserAccount("ciclano","ciclano_login","ciclano123","ciclano@email.com");
    UserAccount beltrano = new UserAccount("beltrano","beltrano_login","beltrano123","beltrano@email.com");
    
    @Autowired
    UserAccountDAO userAccountDAO;  

    
   /**
    * Cria os tres usuarios antes de cada um dos testes
    */
    @Before
    @Test
    public void testSave() {
    	userAccountDAO.save(fulano);
    	userAccountDAO.save(ciclano);
    	userAccountDAO.save(beltrano);
    }
    
    /**
     * Deleta os usuarios criados depois de cada um dos testes e entao testa se consegue encontra-los
     * por meio de seus ids
     */
    @After
    @Test
    public void testDelete() throws Exception {
       userAccountDAO.delete(fulano);
       userAccountDAO.delete(ciclano);
       userAccountDAO.delete(beltrano);
       
       try {
       		userAccountDAO.findById(fulano.getId());
       } catch(Exception e) {
       		System.out.println("usuario de id = " + fulano.getId()+ " apagado com sucesso");
       }
       
       try {
      		userAccountDAO.findById(ciclano.getId());
      } catch(Exception e) {
      		System.out.println("usuario de id = " + ciclano.getId()+ " apagado com sucesso");
      }
       
       try {
      		userAccountDAO.findById(beltrano.getId());
      } catch(Exception e) {
      		System.out.println("usuario de id = " + beltrano.getId()+ " apagado com sucesso");
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
        	userAccountDAO.findByEmail("email_que_nao_existe");
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
        	userAccountDAO.findByEmail("fulano@email.com");
        } catch(Exception e) {
        	System.out.println("email nao existe");
        }
        
        try {
        	userAccountDAO.findByEmail("ciclano@email.com");
        } catch(Exception e) {
        	System.out.println("email nao existe");
        }
        
        try {
        	userAccountDAO.findByEmail("beltrano@email.com");
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
        	userAccountDAO.findByLogin("fulano_login");
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
        
        try {
        	userAccountDAO.findByLogin("ciclano_login");
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
        
        try {
        	userAccountDAO.findByLogin("beltrano_login");
        } catch(Exception e) {
        	System.out.println("login nao existe");
        }
    	
    }
}