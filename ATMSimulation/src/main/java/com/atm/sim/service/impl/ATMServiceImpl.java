package com.atm.sim.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.atm.sim.controller.ATMController;
import com.atm.sim.model.ATM;
import com.atm.sim.service.ATMService;

@Service
public class ATMServiceImpl implements ATMService {
	
	 private static final Logger LOGGER = LoggerFactory.getLogger(ATMServiceImpl.class);
	
	 private String test;
	 private String applicationName;
	    
	 @Value( "${twentynote.count}" )
	 private int twentyNoteCount;
	    
	 @Value( "${fiftynote.count}" )
	 private int fiftyNoteCount;
	    
	 public void setTest(String test){
	    this.test = test;
	 }
	 public String getTest(){
	     return this.test;
	 }

	@Override
	public int getInitialilzeFiftyNoteCount() {
		return fiftyNoteCount;
	}

	@Override
	public int getInitialilzeTwentyNoteCount() {
		return twentyNoteCount;
	}
	@Override
	public void setInitialilzeFiftyNoteCount(int count) {
		this.fiftyNoteCount = count;
		
	}
	@Override
	public void setInitialilzeTwentyNoteCount(int count) {
		this.twentyNoteCount = count;
		
	}
	@Override
	public void setApplicationName(String name) {
		this.applicationName = name;
		
	}
	@Override
	public String getApplicationName() {
		return this.applicationName;
	}
	@Override
	public ATM calculateDispense(ATM atm) throws Exception {
	     int bankBalance = (atm.getCurrent50Note()*50) + (atm.getCurrent20Note()*20);
	     if(bankBalance >= atm.getUserBalance()){
	    	  dispense(atm,atm.getUserBalance(),50,atm.getCurrent50Note());
	    	  if(atm.getError() != null && !atm.getError().isEmpty()){
	    		  atm.setCalculated20Note(0);
	    		  atm.setCalculated50Note(0);
	    	  }
	     }else{
	    	 atm.setError("error");
	     }
		return atm;
	}
	
	private void dispense(ATM atm,int current,int note,int bankNote) throws Exception{
		switch(note) {
        case 50 :
      		int number50 = current/50;
  			if(number50 >= atm.getCurrent50Note()) number50 = atm.getCurrent50Note();
  			atm.setCalculated50Note(number50);
  			int change = current - number50*50;
  			dispense(atm,change,20,atm.getCurrent20Note());
      	  break;
        default :
      	  int checked = (current)%20;
			if(checked == 0){
				int number20 = current/20;
				atm.setCalculated20Note(number20);
				if(number20 > atm.getCurrent20Note())atm.setError("error");
			}else{
				atm.setError("error");
			}
            break;
	  }
	}
	

}
