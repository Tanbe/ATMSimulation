package com.atm.sim.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.atm.sim.Application;
import com.atm.sim.model.ATM;
import com.atm.sim.service.ATMService;
import com.atm.sim.utils.PropertyTestConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;



@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = Application.class)
@TestPropertySource("classpath:application.properties")
//@WebAppConfiguration
//@WebMvcTest(ATMController.class)
public class ATMControllerTest {
	
	@InjectMocks
	private ATMController controller;
	
	//@Autowired
    private MockMvc mockMvc;
	
	//@Autowired 
	//private WebApplicationContext ctx;
	
	 private ATM atm;
	
	 @Mock 
	 private ATMService atmService;
	 
	 @Autowired 
	 private ObjectMapper objectMapper;
	 
	@Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        //this.mockMvc =  MockMvcBuilders.webAppContextSetup(ctx).build();
		 atm = new ATM();
		 atm.setCurrent20Note(atmService.getInitialilzeTwentyNoteCount());
		 atm.setCurrent50Note(atmService.getInitialilzeFiftyNoteCount());
		 atm.setUser20Note(0);
		 atm.setUser50Note(0);
		 atm.setNumbers("200");
    }
	
	@Test
	public void testInitialize() throws Exception{
		 mockMvc.perform(MockMvcRequestBuilders.get("/initialize.html"))
	       .andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testTransfer() throws Exception{
		final String atmJson = objectMapper.writeValueAsString(atm);
		mockMvc
        .perform(MockMvcRequestBuilders.post("/transfer.html").content(atmJson).contentType(MediaType.parseMediaType("application/xml;charset=UTF-8")))
        .andExpect(MockMvcResultMatchers.status().isIAmATeapot());
	}

}
