package br.poo.com.reqagile.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class UserAccount {
		
		private Integer id;
		private String name;
		private String login;
		private String password;
		private String email;

		public UserAccount() {
			
		}
		
		public UserAccount(String name, String login, String password, String email) {
			this.name = name;
			this.login = login;
			this.password = password;
			this.email = email;
		}

		@Id
		@GeneratedValue
		@Column(name = "idUser", unique = true, nullable = false)
		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}
		
		@Column(name = "login", unique = true, nullable = false)
		public String getLogin() {
			return login;
		}
		
		public void setLogin(String login) {
			this.login = login;
		}
		
		@Column(name = "senha", unique = true, nullable = false, length = 20)
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		
		@Column(name = "nome", unique = true, nullable = false)
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		@Column(name = "email", unique = true, nullable = false)
		public String getEmail() {
			return email;
		}
		
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			return "User name= " + name + ", idUser= " + id
					+ ", loginUser= " + login + "emailUser= " + email;
		}

		/**
		 * Verifica se o usuário informado existe e se a sua senha coincide com a
		 * senha informada pelo usuário. No caso de sucesso, retorna a conta do usuário.
		 * Caso contrário, retorna um objeto UserAccount nulo.
		 * @param login
		 * 			Nome de usuário
		 * @param password
		 * 			Senha
		 * @throws AccountException
		 * 			No caso de erro na interface com o banco de dados, lança a exceção.
		 */
/*		public static UserAccount authenticateUser(String login, String password) throws AccountException {
			try {
				UserAccount	user = UserAccount.Search(login);
				if((user != null) && user.getPassword().equals(password)) {
					return user;
				}else {
					return null;
				}
			}catch(SQLException e) {
				throw new AccountException("Erro no acesso ao banco de dados!");
			}
		}
*/
		
}
