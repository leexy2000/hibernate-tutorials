package org.tutorialspoint;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.tutorialspoint.domain.Tuser1;

public class Tuser1QueryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory;
		entityManagerFactory = Persistence.createEntityManagerFactory("user");
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		String query = " from Tuser1";
		try {

			tx.begin();
			List<?> results = manager.createQuery(query).getResultList();
			for (Object obj : results) {
				Tuser1 user = (Tuser1) obj;
				System.out.println(user.getId() + " ---> " + user.getName());
			}
			manager.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
