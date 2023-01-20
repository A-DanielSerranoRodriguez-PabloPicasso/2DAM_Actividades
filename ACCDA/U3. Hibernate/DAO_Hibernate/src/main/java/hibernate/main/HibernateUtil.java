package hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;

	private HibernateUtil() {
	}

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
}
