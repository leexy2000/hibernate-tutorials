package org.tutorialspoint;

import static org.junit.Assert.*;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.tutorialspoint.domain.Tuser1;
import org.tutorialspoint.util.HibernateHelper;

public class Tuser1QueryTest {

	SessionFactory sessionFactory = null;
	Session session = null;

	@Before
	public void setUp() throws Exception {
		sessionFactory = HibernateHelper.buildSessionFactory();
		session = sessionFactory.openSession();
	}

	@After
	public void tearDown() throws Exception {
		if (sessionFactory != null)
			sessionFactory.close();
	}

	@Test
	public void testTuser1Query() {
		String query = " from Tuser1";
		try {
			List<?> results = session.createQuery(query).list();
			for (Object obj : results) {
				Tuser1 user = (Tuser1) obj;
				System.out.println(user.getId() + " ---> " + user.getName());
			}
			session.close();
			assertTrue(true);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}
