package com.atm.sim.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.atm.sim.service.ATMService;

public class ATMServlet extends HttpServlet implements javax.servlet.Servlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 private static final Logger LOGGER = LoggerFactory.getLogger(ATMServlet.class);
	 
	 private ApplicationContext appContext;
	 
	 public ATMServlet(ApplicationContext appContext){
		 this.appContext = appContext;
	 }
	 
	 //@Autowired
	 //private ATMService atmService;
	 
	public void init() throws ServletException {
		 LOGGER.info("start ATMServlet");
		 /*
		  String[] beans = appContext.getBeanDefinitionNames();
	        Arrays.sort(beans);
	        for (String bean : beans)
	        {
	            System.out.println(bean + " of Type :: " + appContext.getBean(bean).getClass());
	        }
	     */
	     ATMService atmService = (ATMService)appContext.getBean("ATMServiceImpl");
		 //ATMService atmService = new ATMServiceImpl();
		 atmService.setApplicationName("ATM SIMULATION");
	}

	/*    
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		LOGGER.info("doGet ATMServlet");
	}
	
	public void destroy() {
		LOGGER.info("destroy ATMServlet");
		
	}
	*/

}
