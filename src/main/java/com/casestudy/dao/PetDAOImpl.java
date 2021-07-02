package com.casestudy.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import com.casestudy.controller.MainController;
import com.casestudy.model.Pet;
import com.casestudy.model.User;

@Repository
public class PetDAOImpl implements PetDAO {
	public static final Logger logger = LogManager.getLogger(MainController.class);
	@Autowired
	SessionFactory sessionFactory;

	/*
	 * Home - List of all Pets - This functionality get all pets
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

		Transaction transaction = null;
		Pet pet = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			@SuppressWarnings("unchecked")
//			logger.info("Getting the list of pets");
			List<Pet> pets = (List<Pet>) session.createQuery("FROM Pet").list();
			if (pets != null) {
				logger.info("Pet list is displayed");
				return pets;
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();

		}
		return null;
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

		Transaction transaction = null;
		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			logger.info("Pet is saved successfully");
			session.save(pet);

			// commit transaction
			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();

		}
		return pet;
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
		

		Transaction transaction = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();

			@SuppressWarnings("unchecked")
			List<Pet> pets = (List<Pet>) session.createQuery("FROM Pet p where petownerid= :userid")
					.setParameter("userid", userId).list();

			if (pets != null) {
				logger.info("Pet added by the user is displayed in mypet page");
				return pets;

			}
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			logger.error("error occured while redirecting to mypet page");
			e.printStackTrace();

		}
		return null;

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

		

		Pet pet = null;
		Transaction transaction = null;

		try (Session session = sessionFactory.openSession()) {
			transaction = session.beginTransaction();
			logger.info("Transaction started ");

			String s = Integer.toString(userId);
			String i = Integer.toString(petId);
			String str = "UPDATE pet SET petownerid= :userid WHERE  petId= :petid";
			session.createNativeQuery(str).setParameter("userid", s).setParameter("petid", i).executeUpdate();

			// commit transaction
			transaction.commit();
			logger.info("transcaction is committed");
			return pet;

		}

		catch (Exception e) {
			logger.info("error occured while buying a pet");
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