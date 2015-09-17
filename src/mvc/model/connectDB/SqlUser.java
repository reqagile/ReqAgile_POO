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
		while(MySql.isConnect() == false && i < 10){
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
	//Comoe retornar um vetor de string?
	//TODO retornar um vetor de string com todas informações do registro; 
	public String selectRegisty(int iduser) {
		String query = "SELECT FROM user WHERE iduser ="+iduser+";";
		try {
			MySql.stm.executeUpdate(query);
			if(MySql.rs.next()){
				return MySql.rs.getString("name");
			}else{
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
	
	@Override
	//TODO retornar um vetor de string com todas informações do registro; 
	public String selectRegisty(String login) {
		String query = "SELECT FROM user WHERE login ='"+login+"';";
		try {
			MySql.stm.executeUpdate(query);
			if(MySql.rs.next()){
				return MySql.rs.getString("name");
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
