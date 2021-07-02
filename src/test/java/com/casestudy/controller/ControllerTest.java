package com.casestudy.controller;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

public class ControllerTest {

	@Autowired
	private MainController controller;
	

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testControllerisNotNull() throws Exception
	{
		//MvcResult mvcResult = this.mvc.perform(get("/registration")).andExpect("")
	}
}
