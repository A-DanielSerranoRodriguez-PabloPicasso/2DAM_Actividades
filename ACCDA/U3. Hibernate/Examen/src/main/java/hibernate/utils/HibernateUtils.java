package hibernate.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final SessionFactory SESSION_FACTORY;
	private static Session SESSION;

	/**
	 * Crea un SessionFactory en cuanto se inicia el programa.
	 */
	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			System.err.println("[ERROR] Configuración de Hibernate - " + e);
			throw new ExceptionInInitializerError();
		}
	}

	/**
	 * Devuelve el SessionFactory.
	 * 
	 * @return SessionFactory.
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

	/**
	 * Dependiendo del estado, crea o devuelve un Session. Si el Session no se ha
	 * inicialiado antes, lo crea.
	 * 
	 * @return Session
	 */
	public static Session getSession() {
		if (SESSION != null)
			return SESSION;

		SESSION = SESSION_FACTORY.openSession();
		return SESSION;
	}
}
