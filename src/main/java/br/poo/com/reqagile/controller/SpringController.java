package br.poo.com.reqagile.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.poo.com.reqagile.dao.UserAccountDao;
import br.poo.com.reqagile.model.UserAccount;

/**
 * @author Wellington Stanley
 *
 */

@Controller
public class SpringController {
/**
 * Requests for HTTP
 * 
 * @param request
 * 			servlet request
 * @param response
 * 			servlet response
 * 
 * @throws ServletException
 * 			if a servlet-specific error occurs
 * 
 * @throws IOException
 * 			if an I/O error occurs
 */
	@Autowired
    private UserAccountDao userDao;
	@RequestMapping("/")
	public ModelAndView index(){
//		System.out.println("Acessando a home.jsp!");
		List<UserAccount> listUsers = userDao.list();
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return new ModelAndView("index");
	}
	
	@RequestMapping("/home")
	public ModelAndView start(){
//		System.out.println("Acessando a home.jsp!");
		List<UserAccount> listUsers = userDao.list();
		/*Nome da view que deseja referenciar*/
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		return new ModelAndView("home");
	}
	
	@RequestMapping("/criar_conta")
	public ModelAndView create(){
		System.out.println("Acessando a home.jsp!");
		return new ModelAndView("criar_conta");
	}
	
	@RequestMapping("/cadastrado")
	public ModelAndView newUser(){
//		System.out.println("Acessando a home.jsp!");
		/*Nome da view que deseja referenciar*/
		ModelAndView model = new ModelAndView("criar_conta");
		model.addObject("user", new UserAccount());
		System.out.println("**********Cadastrado com sucesso!");
		return new ModelAndView("criar_conta");
	}
	
}