package org.tutorialspoint;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.tutorialspoint.domain.Tuser1;

public class Tuser1AppendDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory;
		entityManagerFactory = Persistence.createEntityManagerFactory("user");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();

		Tuser1 user = new Tuser1();
		user.setName("Jeffery");
		try {
			tx.begin();
			manager.persist(user);
			manager.getTransaction().commit();
			manager.close();

		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

	}

}
