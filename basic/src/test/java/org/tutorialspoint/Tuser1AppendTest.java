package org.tutorialspoint;

import static org.junit.Assert.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tutorialspoint.domain.Tuser1;
import org.tutorialspoint.util.HibernateHelper;

public class Tuser1AppendTest {

	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;

	@Before
	public void setUp() throws Exception {
		sessionFactory = HibernateHelper.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		session.close();
		sessionFactory.close();
	}

	@Test
	public void testTuser1Append() {
		try {
			Tuser1 user = new Tuser1();
			user.setName("Wang");
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			assertTrue(true);
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		}

	}
}
