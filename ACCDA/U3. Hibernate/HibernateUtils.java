package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtils {
	private static SessionFactory sf;
	private static Session session;

	private static void setSessionFactory() {
		if (sf == null) {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
			sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
		}
	}

	public SessionFactory getSessionFactory() {
		setSessionFactory();

		return sf;
	}

	public static Session getSession() {
		if (session == null) {
			if (sf == null)
				setSessionFactory();
			session = sf.openSession();
		}

		return session;
	}

	public static void close() {
		closeSession();
		closeSessionFactory();
	}

	public static void closeSession() {
		if (session != null)
			session.close();
	}

	public static void closeSessionFactory() {
		if ((sf != null) && !sf.isClosed())
			sf.close();
	}
	
}
