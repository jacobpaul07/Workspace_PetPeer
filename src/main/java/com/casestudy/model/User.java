package com.casestudy.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name = "USERNAME")
	private String userName;
	
	@Column(name = "USERPASSWORD")
	private String userPassword;
	
	@Transient
	private String confirmUserPassword;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Pet> pets;

	public User() {
		super();

	}

	public User(int userId, String userName, String userPassword, String confirmUserPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.confirmUserPassword = confirmUserPassword;
	}

	public User(String userName, String userPasswd, String confirmUserPasswd) {
		super();
		this.userName = userName;
		this.userPassword = userPasswd;
		this.confirmUserPassword = confirmUserPasswd;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getConfirmUserPassword() {
		return confirmUserPassword;
	}

	public void setConfirmUserPassword(String confirmUserPasswd) {
		this.confirmUserPassword = confirmUserPasswd;
	}

}
