package mvc.model.connectDB;


/**
 * Classe que implementa a conexão com a tabela user 
 * do data base
 * 
 * @author Eduardo Scartezini
 *
 */
public class SqlUser implements ConnectionUser {

	@Override
	public boolean InsertRegisty(String name, String login, String password, String email) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	@Override
	public String SelectRegisty(int iduser) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String SelectRegisty(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	@Override
	public boolean DeleteRegisty(int iduser) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean AlterRegisty(int iduser) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
