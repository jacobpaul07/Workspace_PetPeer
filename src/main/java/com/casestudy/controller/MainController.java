package com.casestudy.controller;

import java.util.List;

/**
  
  Case Study: Pet Peers 
  
  Technology: Spring MVC, Spring, JSP (HTML, CSS, JS etc.), Hibernate ORM, Log4j 2
  
  Description: The task is develop a 'Pet Peers' a web based application, which provide features such as  storing & retrieving pet information, listing available pets and view details for a specific pet. It also allows a user to login/register, buy pets and view the pets owned by him. 
   
  The following are the User Stories for the Pet Peers application.
         1.	User Registration - New users can register themselves by entering a unique user name and password.
         2.	User Login - Users should be able to login into the application by entering a correct user name and password
         3.	Home / View List of all Pets - This functionality lists all pets and also indicates whether a Pet is "Sold Out" or available for purchase. 
         	If available, it provides a link to buy that Pet.
         4.	Add a Pet - A user can enter a new Pet to the list (anyone can buy this pet).
         5.	Buy a Pet - If a User likes an available Pet, she / he can buy the same by clicking on the "Buy" button.
         6.	List of owned Pets - A logged in user can view the list of Pets owned by him/her by clicking on "My Pets" button.
         7.	User Logout - A user can logout of the application by clicking on "Logout" button. After logout, user can access the application functionalities only after logging in again.
         8. Please show both success and failure message for each scenarios in the relevant pages. 
		
	You are provided with a partially implemented eclipse Maven web application project template, herewith you are expected to create the necessary objects and components in the given project template. 
	DB details are available in the PetConfig.java under "DAO" package.  

    Rules:
              
         1. Do not modify the Package, Class, its Methods name or signature
         
         2. Do not alter the request mapping URI and JSP names. 
         
         3. Remove the dummy view/code block and replace with your code solution as per functionality
         
         4. Follow Java coding conventions, best practices for better assessment feedback
         
         5. Write as many unit test cases in WebApplicationUnitTest.java for better test pass % and code coverage.
         
         6. Save your changes (Ctrl + S) regularly, as automatic check-in happens for every 30 minutes, for final submission refer Step 7a or 7b.
         
         7. After completion of the use case development, please submit the code using one of below options
			a. Goto Git Staging window (in Eclipse -> Goto Window Menu -> Show View -> Others -> filter for Git Staging -> Click Open), add the necessary files to "Staged Changes" from "Unstaged Changes", enter the commit message 
			   then click "Commit and Push", click "Preview", click "Push" and finally click "Close" button
							or
			b. Goto Project Explorer (in Eclipse), right click on the UseCaseSubmission.bat and select open (Click Cancel if Editors available window pops up)		
         
         8. After code submission please allow 2 minutes for coding analysis process to complete. 				
	
	Deviating above rules will impact the assessment feedback.
	  	
	Quick Troubleshooting Tips:
			
		1. If you receive the Windows Defender Firewall windows couple of times initially, please click "Allow Access".  
		
		2. If you receive the DB error "You must configure either the server or JDBC driver", run the "SET GLOBAL time_zone = '+0:00'" in the MySQL Windows Client or MySQL Workbench (username: root, password: root)
		
		3. If you receive the timeout on launching(Run on Server) the project in Tomcat, please increase the timeout 
		   (in Eclipse -> Goto Window Menu -> Show View -> Others -> Type "Server" in the filter and select "Servers" -> Click open -> Double click on "Tomcat 9.0 Server at localhost" -> Timeout section --> Increase the "Start(in seconds):" and "Stop(in seconds):" value.  )
		4. For the error message "We couldn't connect to the gateway because of an error. If this keeps happening, ask your admin or tech support for help", please refresh the page or goto the url https://rdweb.wvd.microsoft.com/webclient/index.html in the browser and relogin again. If still the error persists, please contact the SME/Trainer.

        5. For the error message "We couldn't connect because there are currently no available resources. Try again later or if this keeps happening, ask your admin or tech support for help.", please refresh the page or goto the url https://rdweb.wvd.microsoft.com/webclient/index.html in the browser and relogin again. If still the error persists, please contact the SME/Trainer.
		
		6. For the error message "We are working on refreshing your token, please try again after a short while or refresh your page.", please refresh the page or goto the url https://rdweb.wvd.microsoft.com/webclient/index.html in the browser and relogin again. If still the error persists, please contact the SME/Trainer.

 */

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.casestudy.model.Pet;
import com.casestudy.model.User;
import com.casestudy.service.PetService;
import com.casestudy.service.UserService;

@RestController
public class MainController {

	// Use below logger object to print the messages w.r.t level DEBUG or above
	public static final Logger logger = LogManager.getLogger(MainController.class);

	@Autowired
	UserService userService;

	@Autowired
	PetService petService;

	User users;

	/*
	 * Index/Landing page for the Pet Peers Web Application
	 */
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("indexPage");
	}

	/*
	 * User Login - Users should be able to login into the application by entering a
	 * correct user name and password.
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Nivedha V V	
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	@GetMapping("/login")
	public ModelAndView login() {
		logger.info("Successfull Log In");
		return new ModelAndView("loginPage", "user", new User());

	}

	/*
	 * User Login - Users should be able to login into the application by entering a
	 * correct user name and password
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	@PostMapping("/authenticateUser")
	public ModelAndView authenticateUser(HttpServletRequest request, @ModelAttribute("user") User user) {
		// Instead of below dummy view replace your solution
		String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");

		users = userService.authenticateUser(username, password);

		request.getSession().setAttribute("user", users);

		if (users != null) {

			List<Pet> petList = petService.getAllPets();
			return new ModelAndView("homePage", "pets", petList);

		} else {
			logger.error("Invalid credentials");
			return new ModelAndView("loginPage", "errorMsg", "Please Enter Valid Credentials");
		}

	}

	/*
	 * User Registration - New users can register themselves by entering a unique
	 * user name and password.
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */

	@GetMapping("/registration")
	public ModelAndView register() {
		
		logger.info("Entered into the registration Page");
		return new ModelAndView("registrationPage", "user", new User());
	}

	/*
	 * User Registration - New users can register themselves by entering a unique
	 * user name and password.
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */

	@PostMapping("/save")
	public ModelAndView saveUser(@ModelAttribute("user") User user) {
		// Instead of below dummy view replace your solution
		User savedUser;
		savedUser = userService.saveUser(user);
		if (savedUser != null) {
			logger.info("You are Successfully Registered. Please Login Now");
			return new ModelAndView("loginPage", "successMsg", "You are Successfully Registered. Please Login Now");
		} else {
			logger.error("Invalid Credintials");
			return new ModelAndView("registrationPage", "errorMsg", "Invalid credentials");
		}
	}

	/*
	 * Home - View List of all Pets - This functionality lists all pets and also
	 * indicates whether a Pet is "Sold Out" or available for purchase. If
	 * available, it provides a link to buy that Pet.
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */

	@GetMapping("/home")
	public ModelAndView home() {
		// Instead of below dummy view replace your solution

		List<Pet> petList = petService.getAllPets();
		return new ModelAndView("homePage", "pets", petList);
	}


	
	/*
	 * Buy a Pet - If a User likes an available Pet, she / he can buy the same by
	 * clicking on the "Buy" button.
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com
	 * 
	 */


	@GetMapping("/buyPet")
	public ModelAndView buyPet(HttpServletRequest request) {
		// Instead of below dummy view replace your solution
		String id = request.getParameter("petId");
		int petId = Integer.parseInt(id);

		//Getting user from session
		users = (User) request.getSession().getAttribute("user");

		//retrieving userid from user
		int userId = users.getUserId();
		Pet pet = petService.buyPet(petId, userId);
		return new ModelAndView("redirect:/myPets", "pets", pet);
	}

	/*
	 * Add a Pet - A user can enter a new Pet to the list (anyone can buy this pet).
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	@GetMapping("/addPet")
	public ModelAndView addPet() {
		// Instead of below dummy view replace your solution
		logger.info("Entered into Add pet Page");
		return new ModelAndView("addPetPage", "pet", new Pet());
	}

	/*
	 * Add a Pet - A user can enter a new Pet to the list (anyone can buy this pet).
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com
	 * 
	 */
	@PostMapping("/savePet")
	public ModelAndView savePet(@ModelAttribute("pet") Pet pet) {
		// Instead of below dummy view replace your solution
		logger.info("Pet has saved");
		petService.savePet(pet);
		List<Pet> petList = petService.getAllPets();
		return new ModelAndView("homePage", "pets", petList);
	}

	/*
	 * List of owned Pets - A logged in user can view the list of Pets owned by
	 * him/her by clicking on "My Pets" button.
	 * 
	 * Please show success or failure message in the browser
	 * 
	 * Candidate Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com
	 * 
	 */
	@GetMapping("/myPets")
	public ModelAndView petList(HttpServletRequest request) {
		// Instead of below dummy view replace your solution

		users = (User) request.getSession().getAttribute("user");

		int userId = users.getUserId();

		logger.info("using session user ID is " + userId);
		List<Pet> myPets = petService.getMyPets(userId);
		return new ModelAndView("myPetsPage", "myPets", myPets);
	}

	/*
	 * User Logout - A user can logout of the application by clicking on "Logout"
	 * button. After logout, user can access the application functionalities only
	 * after logging in again.
	 * 
	 * Candidate Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		// Add your code logic as per logout functionality
		logger.info("You have Logged out");
		HttpSession session = request.getSession();
		session.invalidate();
		return new ModelAndView("loginPage", "user", new User());
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public MainController(UserService userService) {
		this.userService = userService;
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public MainController(PetService petService) {
		this.petService = petService;
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public MainController(UserService userService, PetService petService) {
		this.userService = userService;
		this.petService = petService;
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public MainController() {
		// Default Constructor
		// To address org.springframework.beans.BeanInstantiationException: Failed to
		// instantiate problem
		// hence do not modify/remove this method
		logger.debug("Pet Peers Web Application Initialized.....");
	}

}
