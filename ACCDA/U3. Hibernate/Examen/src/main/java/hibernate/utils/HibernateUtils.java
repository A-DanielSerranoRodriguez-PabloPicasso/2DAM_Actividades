package hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY;
	private static Session SESSION;

	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("[ERROR] Configuración de Hibernate - " + e);
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	public static Session getSession() {
		if (SESSION != null)
			return SESSION;

		SESSION = SESSION_FACTORY.openSession();
		return SESSION;
	}
}
