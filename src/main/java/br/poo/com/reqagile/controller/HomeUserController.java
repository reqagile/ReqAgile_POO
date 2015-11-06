package br.poo.com.reqagile.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.poo.com.reqagile.dao.UserAccountDao;
import br.poo.com.reqagile.model.UserAccount;
import br.poo.com.reqagile.service.UserAccountService;

/**
 * @author Wellington Stanley
 *
 */

@Controller
public class HomeUserController {
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
	
	@Autowired
	private UserAccountService userService;
	
	
	/**
	 * Metodo responsavel por receber a requisicao para a raiz, ou seja, index ou /
	 * e redirecionar para a home page. Tem como parametro um objeto que representa 
	 * uma view e seus recursos. Neste caso o recurso preenchido eh a lista de usuarios
	 * cadastrados. Esta lista pode ou nao ser exibida em tela.
	*/
	@RequestMapping(value={"/", "/index"},method = RequestMethod.GET)
	public String index(ModelMap mMap){
		System.out.println("Acessando a index.jsp! Redirecionando para a home.jsp");
		List<UserAccount> users = userDao.list();
		mMap.put("userList", users);
/*		for (UserAccount userAccount : users) {
			System.out.println("Nome: " + userAccount.getName() + "Id: " + userAccount.getId());
		}*/
		return "home";
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
	
	@RequestMapping(value="/criar_conta", method= RequestMethod.GET)
	public String newUser(ModelMap mMap){
		mMap.put("user", new UserAccount());
		System.out.println("****Acessando a criarConta, aguardando dados!");
		return "criar_conta";
	}
	
	@RequestMapping(value="/criar_conta", method= RequestMethod.POST)
	public ModelAndView newUser(@ModelAttribute(value="user") UserAccount user){
		ModelAndView map = new ModelAndView("home");
		userService.save(user);
		System.out.println("****Dados aguardados cadastrados!");
		
		return map;
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
/*

	
	@RequestMapping(value="criar_conta", method= RequestMethod.GET)
	public String newUser(ModelMap mMap){
		mMap.put("user", new UserAccount());
		System.out.println("****Acessando a criarConta, aguardando dados!");
		return "criar_conta";
	}
	
	@RequestMapping(value="criar_conta", method= RequestMethod.POST)
	public String newUser(@ModelAttribute(value="user") UserAccount user, ModelMap mMap){
		userService.save(user);
		System.out.println("****Dados aguardandos cadastrados!");
		return "redirect:index.jsp";
	}
	
	@RequestMapping("/newUser")
	public ModelAndView newUser(){
//		System.out.println("Acessando a home.jsp!");
		Nome da view que deseja referenciar
		ModelAndView model = new ModelAndView("criar_conta");
		model.addObject("user", new UserAccount());
		System.out.println("**********Cadastrado com sucesso!");
		return new ModelAndView("criar_conta");
	}
*/
}