package com.casestudy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PET")
public class Pet implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int petId;
	
	@Column(name = "petname")
	private String petName;
	
	@Column(name = "petage")
	private int petAge;
	
	@Column(name = "petplace")
	private String petPlace;

	@ManyToOne
	@JoinColumn(name = "petownerid")
	private User user;

	public Pet() {
		super();

	}

	public Pet(int petId, String petName, int petAge, String petPlace) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petAge = petAge;
		this.petPlace = petPlace;
	}

	public Pet(String petName, int petAge, String petPlace) {
		super();
		this.petName = petName;
		this.petAge = petAge;
		this.petPlace = petPlace;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetPlace() {
		return petPlace;
	}

	public void setPetPlace(String petPlace) {
		this.petPlace = petPlace;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
