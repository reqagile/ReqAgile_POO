package mvc.model.connectDB;


/**
 * Interface que define como sera dada
 * a conexão com a tabela de usuarios.
 * 
 * Com essa interface eu posso criar diferentes 
 * implementações para diferentes modes do banco de dados
 * 
 * @author Eduardo Scartezini
 *
 */
public interface ConnectionUser {
	/**
	 * 	Insere um registro na tabela user
	 * 
	 * @return boolean
	 * 		retorna se foi inserido corretamente;
	 */
	public boolean insertRegisty(String name,String login,String password,String email);

	
 
	/**
	 * Selecionar um registro pelo id
	 *  do usuario
	 *  
	 * @param iduser
	 * @return String[]
	 *  	Retorna um array com todos os atributos do registro
	 *  	0 - iduser;
	 *  	1 - name;
	 *  	2 - login;
	 *  	3 - passwor;
	 *  	4 - email;
	 *  	
	 */
	public String[] selectRegisty(int iduser);
	
	/**
	 * Selecionar um registro pelo login do usuario
	 * 
	 * @param login
	 * @return String[]
	 *
	 *  	Retorna um array com todos os atributos do registro
	 *  	0 - iduser;
	 *  	1 - name;
	 *  	2 - login;
	 *  	3 - passwor;
	 *  	4 - email;
	 */
	public String[] selectRegisty(String login);
	
	
	/**
	 * 	Deleta algum registro da tabela 
	 * user	
	 * @return	boolean
	 * 		retorna se foi deletado corretamente
	 */
	public boolean deleteRegisty(int iduser);
	
	/**
	 * 	Altera algum registro da tabela user
	 * @return boolean
	 * 		retorna se foi alterado corretamente
	 */
	public boolean alterRegisty(int iduser);

}
