package mvc.model.dbconnect;

import java.sql.SQLException;
import mvc.model.AccountException;
import mvc.model.UserAccount;

/**
 * Classe que implementa a conexão com a tabela user 
 * do data base
 * 
 * @author Eduardo Scartezini
 *
 */
public class SqlUser implements ConnectionTable<UserAccount> {	
	
	/**
	 * Construtor do SqlUser. 
	 * 
	 * 		Verifica se a conexão com Data Base,
	 * 	caso não esteja conectado ele tenta conectar.
	 * 
	 */
	public SqlUser(){
		int i = 0;
		while(MySql.isConnected() == false && i < 10){
			MySql.connect();
			i++;
		}
	}
	
	
	
	
	@Override
	public void insertRegistry(UserAccount account) throws java.sql.SQLException{
		String query = "INSERT INTO user VALUES "+"(NULL,'"+account.getName()+"','"+account.getLogin()+"','"
													+account.getPassword()+"','"+account.getEmail()+"');";
		
		MySql.stm.executeUpdate(query);
	}
	
	
	
	
	@SuppressWarnings("serial")
	@Override 
	public UserAccount selectRegistry(int iduser) throws SQLException, AccountException {
		String query = "SELECT * FROM user WHERE iduser ="+iduser+";";
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			UserAccount userData = new UserAccount();
			userData.setIdUser(Integer.parseInt(MySql.rs.getString("iduser")));
			userData.setName(MySql.rs.getString("name"));
			userData.setLogin(MySql.rs.getString("login"));
			userData.setPassword(MySql.rs.getString("password"));
			userData.setEmail(MySql.rs.getString("email"));
			return userData;
		}else{
			throw new AccountException("Usuário inexistente."){
			};
		}
		
	}
	
	
	
	@SuppressWarnings("serial")
	@Override
	public UserAccount selectRegistry(String login) throws java.sql.SQLException, AccountException {
		
		String query = "SELECT * FROM user WHERE login ='"+login+"';";
		
		MySql.rs = MySql.stm.executeQuery(query);
		MySql.stm = MySql.conn.createStatement();
		
		if(MySql.rs.next()){
			UserAccount userData = new UserAccount();
			userData.setIdUser(Integer.parseInt(MySql.rs.getString("iduser")));
			userData.setName(MySql.rs.getString("name"));
			userData.setLogin(MySql.rs.getString("login"));
			userData.setPassword(MySql.rs.getString("password"));
			userData.setEmail(MySql.rs.getString("email"));
			return userData;
		}else{
			throw new AccountException("Usuário inexistente."){
			};
		}
	}
	
	
	
	@Override
	public void deleteRegistry(int iduser) throws java.sql.SQLException{
		String query = "DELETE FROM user WHERE iduser = "+iduser+";";
		MySql.stm.executeUpdate(query);
	}

	
	@Override
	public void alterRegistry(UserAccount account) throws java.sql.SQLException{
		
		String query = "UPDATE user SET name =\" " +account.getName()+"\",login = \""+account.getLogin()+
						"\",password =\""+account.getPassword()+"\", email = \""+account.getEmail()+
						"\"WHERE iduser = "+account.getId()+";";

		MySql.stm.executeUpdate(query);
	}


	
}
