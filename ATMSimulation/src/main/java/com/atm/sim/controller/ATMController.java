package com.atm.sim.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.atm.sim.model.ATM;
import com.atm.sim.service.ATMService;
import com.atm.sim.validator.ATMValidator;

@Controller
//@RequestMapping(value="/ATMSimulation")
public class ATMController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(ATMController.class);
	 @Autowired
	 private ATMService atmService;
	 
	 @RequestMapping(value = "/initialize.html", method = RequestMethod.GET)
	    public String initialize(@ModelAttribute("atm") ATM atm,Model model, BindingResult bindingResult,HttpServletRequest request) {
		 LOGGER.info("initialize method");
		 atm.setCurrent20Note(atmService.getInitialilzeTwentyNoteCount());
		 atm.setCurrent50Note(atmService.getInitialilzeFiftyNoteCount());
		 atm.setUser20Note(0);
		 atm.setUser50Note(0);
		 model.addAttribute("atm", atm); 
		 model.addAttribute("applicationName", atmService.getApplicationName());
		 return "welcome";
	    }
	 
	 @RequestMapping(value = "/balance.html", method = RequestMethod.GET)
	    public String balance(@ModelAttribute("atm") ATM atm,Model model,HttpServletRequest request) {
		 LOGGER.info("balance method");
		 ATM atm2 =  (ATM)request.getSession().getAttribute("atm");
		 if(atm2 != null) {
			 model.addAttribute("atm", atm2); 
		 } else{
			 model.addAttribute("atm", atm); 
		 }
		 
		 model.addAttribute("applicationName", atmService.getApplicationName());
		 return "welcome";
	    }
	 
	 @RequestMapping(value = "/transfer.html", method = RequestMethod.POST)
	    public String transferAmount(@ModelAttribute( "atm" )ATM atm,Model model,RedirectAttributes attr, BindingResult bindingResult,HttpServletRequest request) {
		 try{
		 
			 LOGGER.info("transferAmount method");
			 LOGGER.info("transferAmount : "+request.getParameter("numbers").toString());
			 String currecyText = request.getParameter("numbers").toString();
			 if(currecyText != null && !currecyText.isEmpty()){
				 String newCurrecyText = currecyText.replaceAll("[^\\d.]+", "");
				 atm.setUserBalance(Integer.parseInt(newCurrecyText));
				 atm = atmService.calculateDispense(atm);

				 ATMValidator atmValidator = new ATMValidator();
				 atmValidator.validate(atm, bindingResult);
				 if(!bindingResult.hasErrors()){
					 atm.setCurrent20Note(atm.getCurrent20Note() - atm.getCalculated20Note());
					 atm.setCurrent50Note(atm.getCurrent50Note() - atm.getCalculated50Note());
					 atm.setUser20Note(atm.getCalculated20Note());
					 atm.setUser50Note(atm.getCalculated50Note());
					 attr.addFlashAttribute("atm",atm);
					 request.getSession(false).setAttribute("atm",atm);
					 return "redirect:/balance.html";
				 }
			 }
		 }catch(Exception ex){
			  Errors errors = (Errors) bindingResult;
	          errors.rejectValue("exception", "", ex.getMessage());
		 }
		 
		 model.addAttribute("applicationName", atmService.getApplicationName());
		 return "welcome";
	
		 
	    }
	 
	 @RequestMapping("/")
	   public String init() {
		 	LOGGER.info("init method");
			return "redirect:/initialize.html";
	   }
}
