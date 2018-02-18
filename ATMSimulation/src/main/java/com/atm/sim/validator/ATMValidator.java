package com.atm.sim.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.atm.sim.model.ATM;

public class ATMValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		  ATM atm = (ATM)obj;
		  if(atm.getError() != null && !atm.getError().isEmpty()){
			  errors.rejectValue("error", "errorMsg",new String[] {Integer.toString(atm.getUserBalance())},"");
		  }
		
	}

}
