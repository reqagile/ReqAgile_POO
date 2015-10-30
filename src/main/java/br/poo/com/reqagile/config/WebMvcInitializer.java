package br.poo.com.reqagile.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
		 
	    @Override
	    protected Class<?>[] getRootConfigClasses() {
	    	return new Class[]{DataBaseConfig.class};
	    }
	  
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	    	return new Class[] { WebMvcConfig.class };
	    }
	  
	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }
}
