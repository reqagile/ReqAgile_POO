package br.poo.com.reqagile.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "USUARIO")
public class UserAccount implements Serializable{

		private static final long serialVersionUID = 319574572298813534L;

		private Integer id;
		private String name;
		private String login;
		private String password;
		private String confirmPassword;
		private String email;
		private boolean enable;


		@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "userID", unique = true, nullable = false)
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
		
		@Transient
		public String getConfirmPassword() {
			return confirmPassword;
		}
		
		public void setConfirmPassword(String confirmPassword) {
			this.confirmPassword = confirmPassword;
		}
		
		@Column(name="ativo")
		public boolean isEnable() {
			return enable;
		}
		
		public void setEnable(boolean enable) {
			this.enable = enable;
		}
		
		@Override
		public String toString() {
			return "User name= " + name + ", idUser= " + id
					+ ", loginUser= " + login + "emailUser= " + email;
		}
		
        @Override
        public int hashCode() {
              final int prime = 31;
              int result = 1;
              result = prime * result + ((id == null) ? 0 : id.hashCode());
              return result;
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
		public boolean authenticateUser(String password) {
			if(!password.equals(null) && password.equals(this.password)){
				return true;
			}else
				return false;
		}

}
