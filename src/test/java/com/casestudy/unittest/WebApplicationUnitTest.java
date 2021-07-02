package com.casestudy.unittest;

import static org.junit.Assert.fail;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.mockito.Mockito.mock;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.casestudy.controller.MainController;
import com.casestudy.dao.UserDAO;
import com.casestudy.model.User;
import com.casestudy.service.PetService;
import com.casestudy.service.UserService;
import com.casestudy.service.UserServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
public class WebApplicationUnitTest {
@InjectMocks
private MockMvc mockMvc;

 @Mock
UserService userService;
//@Mock
//PetService bankDAO;
@Before
public void setup() throws Exception {
this.userService = mock(UserService.class);
//this.bankDAO=mock(PetService.class);
MainController mc = new MainController();
mc.login();
//mc.index();
//mc.logout(null);
this.mockMvc = MockMvcBuilders.standaloneSetup(mc).build();

 }
@Test
public void login() throws Exception {
//public void verifyHomeRequest() throws Exception {
this.mockMvc.perform(get("/login")).andDo(print()).andExpect(view().name("loginPage"));
//}
//fail();
}
@Test
public void index() throws Exception {
//public void verifyHomeRequest() throws Exception {
this.mockMvc.perform(get("/")).andDo(print()).andExpect(view().name("indexPage"));
//}
//fail();
}
@Test
public void home() throws Exception {
//public void verifyHomeRequest() throws Exception {
this.mockMvc.perform(get("/addPet")).andDo(print()).andExpect(view().name("addPetPage"));
//}
//fail();
}

@Test
public void registration() throws Exception {
//public void verifyHomeRequest() throws Exception {
this.mockMvc.perform(get("/registration")).andDo(print()).andExpect(view().name("registrationPage"));
//}
//fail();
}
//@Test
//public void logout() throws Exception {
//public void verifyHomeRequest() throws Exception {
//this.mockMvc.perform(get("/home")).andDo(print()).andExpect(view().name("homePage"));
//}
//fail();
}