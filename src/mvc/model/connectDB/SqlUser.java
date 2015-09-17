package mvc.model.connectDB;


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
	public void insertRegisty(String name, String login, String password, String email) throws java.sql.SQLException{
		String query = "IMSERT INTO user VALUES "+"(NULL,'"+name+"','"+login+"','"+password+"','"+email+"');";
		MySql.stm.executeUpdate(query);
	}
	
	
	@Override 
	public String[] selectRegisty(int iduser) throws java.sql.SQLException{
		String query = "SELECT FROM user WHERE iduser ="+iduser+";";
		String registy[] = new String[5];
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
	}
	
	@Override
	public String[] selectRegisty(String login) throws java.sql.SQLException{
		String query = "SELECT FROM user WHERE login ='"+login+"';";
		String registy[] = new String[5];
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
	}
	
	

	@Override
	public void deleteRegisty(int iduser) throws java.sql.SQLException{
		String query = "DELETE FROM user WHERE iduser = "+iduser+";";
		MySql.stm.executeUpdate(query);
	}

	@Override
	public void alterRegisty(int iduser,  String attribute, String value) throws java.sql.SQLException{
		String query = "UPDATE user SET "+attribute+"= \""+value+"\" WHERE iduser = "+iduser+";";
		MySql.stm.executeUpdate(query);
	}
	
}
