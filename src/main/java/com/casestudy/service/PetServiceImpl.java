package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.dao.PetDAO;
import com.casestudy.dao.PetDAOImpl;
import com.casestudy.dao.UserDAO;
import com.casestudy.model.Pet;

@Service
@Transactional
public class PetServiceImpl implements PetService {

	@Autowired
	PetDAO petDao;

	@Autowired
	UserDAO userDao;

	/*
	 * Home - List of all Pets - This functionality is to get all the pets
	 * 
	 * Rule: Do not modify Methods name or signature
	 * 
	 * Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com
	 * 
	 */
	public List<Pet> getAllPets() {
		// Instead of below dummy code block replace your solution
	
		List<Pet> pets;
		pets=petDao.getAllPets();
		return pets;
		
		
	}

	/*
	 * List of owned Pets - For the logged in user get the list of Pets owned by
	 * him/her
	 * 
	 * Rule: Do not modify Methods name or signature
	 * 
	 * Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com	
	 *  
	 */
	public List<Pet> getMyPets(int userId) {
		// Instead of below dummy code block replace your solution
		
		List<Pet> pets;
		pets=petDao.getMyPets(userId);
		return pets;
		
	}

	/*
	 * Save Pet - add the pet details and return the save pet entity back
	 * 
	 * Rule: Do not modify Methods name or signature
	 * 
	 * Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com
	 * 
	 */
	public Pet savePet(Pet pet) {
		// Instead of below dummy code block replace your solution
		
		petDao.savePet(pet);
		return pet;
	}

	/*
	 * Buy Pet - Associate the pet to the user entity and return the object
	 * 
	 * Rule: Do not modify Methods name or signature
	 * 
	 * Name:Thammu Sudheer
	 * 
	 * Email:thammu.sudheer@hcl.com
	 * 
	 */
	public Pet buyPet(int petId, int userId) {
		// Instead of below dummy code block replace your solution
		
		return petDao.buyPet(petId, userId);
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public void setPetDao(PetDAOImpl petDao) {
		this.petDao = petDao;
	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public PetServiceImpl(UserDAO userDao, PetDAO petDao) {
		super();
		this.userDao = userDao;
		this.petDao = petDao;
	}
}
