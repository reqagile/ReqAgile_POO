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
	public boolean InsertRegisty(String name,String login,String password,String email);

	

	/**
	 * Selecionar um registro pelo id
	 *  do usuario
	 *  
	 *  @param iduser
	 *  @return
	 */
	public String SelectRegisty(int iduser);
	
	/**
	 * Selecionar um registro pelo login do usuario
	 * 
	 * @param login
	 * @return
	 */
	public String SelectRegisty(String login);
	
	
	/**
	 * 	Deleta algum registro da tabela 
	 * user	
	 * @return	boolean
	 * 		retorna se foi deletado corretamente
	 */
	public boolean DeleteRegisty(int iduser);
	
	/**
	 * 	Altera algum registro da tabela user
	 * @return boolean
	 * 		retorna se foi alterado corretamente
	 */
	public boolean AlterRegisty(int iduser);

}
