package br.poo.com.reqagile.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/*
 * O nome do metodo configureGlobal nao eh importante. Contudo, eh importante configurar 
AuthenticationManagerBuilder na class anotada com @EnableWebSecurity, 
@EnableGlobalMethodSecurity ou @EnableGlobalAuthentication. Senao tera resultados imprevisiveis.
*/

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource dataSource;
	
	@Override
	    protected void configure(HttpSecurity http) throws Exception {
		
/*		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").and().formLogin()
				.loginPage("/login").failureUrl("/login?error").usernameParameter("username")
				.passwordParameter("password").and().logout().logoutSuccessUrl("/login?logout").and()
				.exceptionHandling().accessDeniedPage("/403").and().csrf();*/
		
		http.authorizeRequests().antMatchers("/", "/index").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/").permitAll().and().logout().permitAll();
	    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(
			"select login,password, ativo from USUARIO where login=?")
		.authoritiesByUsernameQuery(
			"select userID, role from USUARIO_ROLES where userID=?");
//		auth.inMemoryAuthentication().withUser("login").password("password").roles("USER");
	}
}
