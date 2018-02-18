
package com.atm.sim.service;

import com.atm.sim.model.ATM;

public interface ATMService {
	
	public void setApplicationName(String name);
	public String getApplicationName();
	public int getInitialilzeFiftyNoteCount();
	public int getInitialilzeTwentyNoteCount();
	public void setInitialilzeFiftyNoteCount(int count);
	public void setInitialilzeTwentyNoteCount(int count);
	public ATM calculateDispense(ATM atm) throws Exception;
    
}
