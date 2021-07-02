package com.casestudy.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casestudy.controller.MainController;
import com.casestudy.model.Pet;
import com.casestudy.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	public static final Logger logger = LogManager.getLogger(MainController.class);
	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * User Registration : add the details and return the retrieved object
	 * 
	 * Rule: Do not modify methods name or signature
	 * 
	 * Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */
	public User saveUser(User user) {
		// Instead of below dummy code block replace your solution
		

		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			session.save(user);
			logger.info("User saved successfully");

			// commit transaction
			transaction.commit();
			logger.info("transaction committed");
		} catch (Exception e) {
			logger.info("Error occured during SaveUser");
			e.printStackTrace();

		}
		return user;
	}

	/*
	 * User Login: validate the user details and return the retrieved object/null
	 * 
	 * Rule: Do not modify methods name or signature
	 * 
	 * Name:Nivedha V V
	 * 
	 * Email:nivedha.vv@hcl.com
	 * 
	 */

	public User authenticateUser(String name, String password) {
//		// Instead of below dummy code block replace your solution

		Transaction transaction = null;
		User user = null;
		try (Session session = sessionFactory.openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			logger.info("transaction started");
			// get an user object
			user = (User) session.createQuery("FROM User U WHERE U.userName = ?1").setParameter(1, name)
					.getSingleResult();
			if (user != null && user.getUserPassword().equals(password)) {
				logger.info("Credentials validated");
				return user;
			}
			// commit transaction
			transaction.commit();
			logger.info("transaction committed");
		} catch (Exception e) {
			logger.info("Error occured during authentication");
			e.printStackTrace();

		}

		return null;

	}

	/*
	 * DO NOT ALTER/DELETE below method
	 */
	public void setSessionFactory(SessionFactory mockedSessionFactory) {
		this.sessionFactory = mockedSessionFactory;
	}

}