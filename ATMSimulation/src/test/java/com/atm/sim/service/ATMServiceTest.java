package com.atm.sim.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.atm.sim.Application;
import com.atm.sim.model.ATM;
import com.atm.sim.utils.PropertyTestConfiguration;


//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
//@SpringBootTest
@ContextConfiguration(classes = Application.class)
@TestPropertySource("classpath:application.properties")
//@ComponentScan(basePackages = { "com.atm.sim" })
//@Configuration
//@Import({PropertyTestConfiguration.class})
//@ContextConfiguration(locations = {"classpath:application.properties"})
//@PropertySource("classpath:application.properties")
public class ATMServiceTest {
	
	//@Mock
	@Autowired
	private ATMService atmService;
	
	private ATM atm;
	
    @Before
	public void setUp(){
		  atm = new ATM();
		  atm.setCurrent20Note(atmService.getInitialilzeTwentyNoteCount());
		  atm.setCurrent50Note(atmService.getInitialilzeFiftyNoteCount());
		  atm.setUser20Note(0);
		  atm.setUser50Note(0);
    }
    
    @Test(expected = Exception.class)
    public void CalculateDispense()throws Exception{
    	atm.setUserBalance(200);
    	atm = atmService.calculateDispense(atm);
    	assertEquals(atm.getError(),null);
    }
    

}
