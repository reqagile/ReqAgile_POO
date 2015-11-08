package br.poo.com.reqagile.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import br.poo.com.reqagile.config.DataBaseConfigTest;
import br.poo.com.reqagile.dao.UserAccountDAO;
import br.poo.com.reqagile.model.UserAccount;
import br.poo.com.reqagile.service.UserAccountService;

/**
 * 
 * @author Ana
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes=DataBaseConfigTest.class)
public class HomeUserControllerTest {
	@Mock
	private UserAccountService userAccountService;
	@Mock
	private UserAccountDAO userDAO;
	
	@InjectMocks
	private HomeUserController homeUserController;
	private MockMvc mockMvc;
	
	
	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
 
		MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeUserController)
                  				.setViewResolvers(viewResolver)
                  				.build();
	}
	
	@Test
	public void testIndex() throws Exception {
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("home"));
		
		mockMvc.perform(get("/index"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("userList"))
			.andExpect(view().name("home"));
		
	}
	
	@Test
	public void testStart() throws Exception {		
		mockMvc.perform(get("/home"))
			.andExpect(status().isOk())
			.andExpect(view().name("home"));
	}
	
	@Test
	public void testNewUserGET() throws Exception {
		
		mockMvc.perform(get("/criar_conta"))
			.andExpect(status().isOk())
			.andExpect(view().name("criar_conta"));
		
		mockMvc.perform(get("/cadastrado"))
			.andExpect(status().isOk())
			.andExpect(view().name("criar_conta"));

	}
	
	@Test
	public void testNewUserPOST() throws Exception {
		mockMvc.perform(post("/criar_conta")
						.param("id","1")
						.param("name", "Joao")
						.param("login", "joao")
						.param("password","123")
						.param("email", "joao@email.com")
						.sessionAttr("user",new UserAccount()))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("user"))
			.andExpect(model().attribute("user",hasProperty("id",is(1))))
			.andExpect(model().attribute("user",hasProperty("name",is("Joao"))))
			.andExpect(model().attribute("user",hasProperty("login",is("joao"))))
			.andExpect(model().attribute("user",hasProperty("password",is("123"))))
			.andExpect(model().attribute("user",hasProperty("email",is("joao@email.com"))))
			.andExpect(view().name("home"));
	}	
	
	@Test
	public void testHelp() throws Exception {
		mockMvc.perform(get("/help"))
			.andExpect(status().isOk())
			.andExpect(view().name("help"));
	}
}
