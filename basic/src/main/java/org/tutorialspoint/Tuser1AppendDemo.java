package org.tutorialspoint;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.tutorialspoint.domain.Tuser1;
import org.tutorialspoint.util.HibernateHelper;

public class Tuser1AppendDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = null;
		Session session = null;
		Transaction tx = null;
		try {
			factory = HibernateHelper.buildSessionFactory();
			session = factory.openSession();
			Tuser1 user = new Tuser1();
			user.setName("guest");
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			if (session != null)
				session.close();
			factory.close();
		}
	}

}
