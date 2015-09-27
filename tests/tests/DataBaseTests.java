package tests;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import mvc.model.dbconnect.MySql;
import mvc.model.dbconnect.SqlUser;

public class DataBaseTests {
	
	private String[] expecteds = new String[5];
	

	
	@Test
	public void testConnected(){
		assertTrue(MySql.connect());
	}
		
	
	
	private SqlUser user = new SqlUser();
	
	
	@Before
	public void clearAutoIncrment() throws SQLException{
		String query = "ALTER TABLE user AUTO_INCREMENT = 1";
		MySql.stm.executeUpdate(query);
	}
	
	//TODO: Reescrever os métodos de teste utilizando a nova assinatura dos métodos (recebendo UserAccount)
	@Test
	public void testInsertRegistry(){
		try{
			user.insertRegistry("Test", "Test1", "Test123", "Test@test.com");
		}catch(SQLException e){
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	@Test
	public void testSelectRegistryID(){
		try{		
			expecteds = user.selectRegistry(1);
			
			assertEquals(expecteds[1], "Test");
			assertEquals(expecteds[2], "Test1");
			assertEquals(expecteds[3], "Test123");
			assertEquals(expecteds[4], "Test@test.com");
			
			
		}catch(SQLException e){
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	@Test
	public void testSelectRegistryLG(){
		try{
			expecteds = user.selectRegistry("Test1");
			
			assertEquals(expecteds[1], "Test");
			assertEquals(expecteds[2], "Test1");
			assertEquals(expecteds[3], "Test123");
			assertEquals(expecteds[4], "Test@test.com");
			
		}catch(SQLException e){
			assertTrue(false);
		}
		assertTrue(true);
	}
	
	
	@Test
	public void testDeleteRegistry(){
		try{
			user.deleteRegistry(1);
		}catch(SQLException e){
			assertTrue(false);
		}
		assertTrue(true);
	}
	

	

	
}
