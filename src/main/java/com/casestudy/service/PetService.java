package com.casestudy.service;

import java.util.List;

import com.casestudy.model.Pet;

public interface PetService {
	
	public abstract List<Pet> getAllPets();

	public abstract List<Pet> getMyPets(int userId);

	public abstract Pet savePet(Pet pet);

	public abstract Pet buyPet(int petId, int userId);

}
