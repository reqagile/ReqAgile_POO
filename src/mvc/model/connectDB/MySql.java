package mvc.model.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Classe responsavel para conectar ao 
 * mysql
 * 
 * **Lembrar de trocar a password **
 * 
 * @author Eduardo Scartezini
 *
 */
public abstract class MySql{
	
	public static Statement stm=null;
	public static ResultSet rs=null;
	public static Connection conn=null;
	 
	/**
	 * 	Metodo usado para conctar com o banco de dados
	 * 
	 * @throws Exception
	 * @return boolean
	 * 		Se a conectado corretamente ao BD
	 */
	public static boolean connect(){
		
		String driver="com.mysql.jdbc.Driver";
		String server="jdbc:mysql://localhost:3306/reqagile";
		String user="root";
		String password="ReqAgilePOO";
		
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(server,user,password);
			stm = conn.createStatement();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	
	
	
	/**
	 * 	Verifica se o banco de dados esta conectado corretamente
	 * com o mysql;
	 * 
	 * @return boolean
	 */
	public static boolean isConnected(){
		if(conn!=null){
			return true;
		}
		else{
			return false;
			
		}
	}
}
