package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import mvc.model.AccountException;
import mvc.model.AccountOperations;
import mvc.model.UserAccount;
import mvc.model.dbconnect.MySql;


public class TestUserAccount {
	
	private AccountOperations account = new UserAccount("nome","login","senha","email");
	
	@Before
	public void clearTableUser(){
		String query = "DELETE FROM user WHERE iduser = 1;";
		String queryAU = "ALTER TABLE user AUTO_INCREMENT = 1;";
		try {
			MySql.stm.executeUpdate(query);
			MySql.stm.executeUpdate(queryAU);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void testCreateNewUser() {
		try{
			account.CreateNewUser();
		}catch(AccountException e){
			assertTrue(false);
		}
	}
	
	@Test
	public void testAuthenticateUser(){
		AccountOperations operations = new UserAccount();
		UserAccount user = new UserAccount();
		
		try{
			account.CreateNewUser();
			user = operations.authenticateUser("login", "senha");	
			assertEquals(1, user.getId());
			assertEquals("nome",user.getName());
			assertEquals("login", user.getLogin());
			assertEquals("senha", user.getPassword());
			assertEquals("email", user.getEmail());
			
		}catch(AccountException e){
			assertTrue(false);
		}
	}
	

}
