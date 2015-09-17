package mvc.model.connectDB;

import java.sql.SQLException;

/**
 * Classe que implementa a conexão com a tabela user 
 * do data base
 * 
 * @author Eduardo Scartezini
 *
 */
public class SqlUser implements ConnectionUser {	
	
	/**
	 * Construtor do SqlUser. 
	 * 
	 * 		Se não estiver conectado ao DataBase ele conecta.
	 */
	public SqlUser(){
		int i = 0;
		while(MySql.isConnected() == false && i < 10){
			MySql.connect();
			i++;
		}
	}
	@Override
	public boolean insertRegisty(String name, String login, String password, String email) {
		String query = "IMSERT INTO user VALUES "+"(NULL,'"+name+"','"+login+"','"+password+"','"+email+"');";
		try{
			MySql.stm.executeUpdate(query);
			return true;
		}catch(SQLException e){
			return false;
		}
	}
	
	
	@Override 
	public String[] selectRegisty(int iduser) {
		String query = "SELECT FROM user WHERE iduser ="+iduser+";";
		String registy[] = new String[5];
		try {
			MySql.stm.executeUpdate(query);
			if(MySql.rs.next()){
				registy[0] = MySql.rs.getString("iduser");
				registy[1] = MySql.rs.getString("name");
				registy[2] = MySql.rs.getString("login");
				registy[3] = MySql.rs.getString("password");
				registy[4] = MySql.rs.getString("email");
				return registy;
			}else{
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	public String[] selectRegisty(String login) {
		String query = "SELECT FROM user WHERE login ='"+login+"';";
		String registy[] = new String[5];
		try {
			MySql.stm.executeUpdate(query);
			if(MySql.rs.next()){
				registy[0] = MySql.rs.getString("iduser");
				registy[1] = MySql.rs.getString("name");
				registy[2] = MySql.rs.getString("login");
				registy[3] = MySql.rs.getString("password");
				registy[4] = MySql.rs.getString("email");
				return registy;
			}else{
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	

	@Override
	public boolean deleteRegisty(int iduser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean alterRegisty(int iduser) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
