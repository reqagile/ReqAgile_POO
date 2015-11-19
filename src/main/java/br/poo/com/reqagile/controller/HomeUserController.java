package br.poo.com.reqagile.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.poo.com.reqagile.dao.UserAccountDAO;
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
    private UserAccountDAO userDao;
	
	@Autowired
	private UserAccountService userService;
	
	
	/**
	 * Metodo responsavel por receber a requisicao inicial e tratar a inicializacao
	 * das views. O valor inicial de mapeamento eh a raiz, ou seja, index ou /
	 * 
	*/
	@RequestMapping(value={"/", "/index"},method = RequestMethod.GET)
	public ModelAndView index(){
		System.out.println("Acessando a index.jsp! Redirecionando para a home.jsp");
/*		for (UserAccount userAccount : users) {
			System.out.println("Nome: " + userAccount.getName() + "Id: " + userAccount.getId());
		}*/
		return start();
	}

	
	/**
	 * Metodo responsavel por responder requisicoes enviando uma model home page,
	 * que eh a index ou /. Neste caso o recurso preenchido eh a lista de usuarios
	 * cadastrados. Esta lista pode ou nao ser exibida em tela.
	*/
	@RequestMapping("/home")
	public ModelAndView start(){
//		System.out.println("Acessando a home.jsp!");
		List<UserAccount> listUsers = userDao.list();
		UserAccount user = new UserAccount();
		/*Nome da view que deseja referenciar*/
		ModelAndView model = new ModelAndView("home");
		model.addObject("userList", listUsers);
		model.addObject("userLogin",user);
		return model;
	}
	
	/**
	 * Metodo responsavel por receber a requisicao GET para a pagina jsp criarconta
	 * e redirecionar para esta page. Tem como parametro um objeto que representa 
	 * uma view e seus recursos. Neste caso o recurso eh o objeto usuario
	 * a ser cadastrado. Retorna o nome da jsp a ser exibida.
	*/
	@RequestMapping(value="/criar_conta", method= RequestMethod.GET)
	public String newUser(ModelMap mMap){
		mMap.put("user", new UserAccount());
		System.out.println("****Acessando a criarConta, aguardando dados!");
		return "criar_conta";
	}
	
	/**
	 * Metodo responsavel por receber a requisicao POST da pagina criar_conta.jsp
	 * e redirecionar para a home. Tem como parametro um objeto que representa 
	 * o usuario preenchido e que sera persistido no banco.
	 * Retorna para a home page atraves do metodo start().
	*/
	@RequestMapping(value="/criar_conta", method= RequestMethod.POST)
	public ModelAndView newUser(@ModelAttribute(value="user") UserAccount user){
//		ModelAndView map = new ModelAndView("");
		userService.save(user);
		System.out.println("****Dados aguardados cadastrados!");
		
		return start();
	}
	
	@RequestMapping(value="/autenticar", method= RequestMethod.POST)
	public String autenticar(@ModelAttribute("userLogin") UserAccount userLogin){
		System.out.println("****Acessando o Banco, aguardando dados!");
		System.out.println(userLogin.getLogin());
		UserAccount user = userService.findByLogin(userLogin.getLogin());
		System.out.println("****Autenticando usuario, aguardando resultado!");
		if(user != null){
			if(user.authenticateUser(userLogin.getPassword())){
				System.out.println("****Usuario Autenticado com sucesso!");
				return "help";
			}
		}else
			System.out.println("****Usuario nao Autenticado com sucesso!");
			return "home";
	}
	
	/**
	 * Metodo responsavel por receber uma requisicao para 
	*/
	@RequestMapping("/cadastrado")
	public ModelAndView newUser(){
//		System.out.println("Acessando a home.jsp!");
		/*Nome da view que deseja referenciar*/
		ModelAndView model = new ModelAndView("criar_conta");
		model.addObject("user", new UserAccount());
		System.out.println("**********Cadastrado com sucesso!");
		return new ModelAndView("criar_conta");
	}

	
	@RequestMapping(value="help", method= RequestMethod.GET)
	public String help(){
//		mMap.put("user", new UserAccount());
		System.out.println("****Acessando a Help.jsp!");
		return "help";
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