package hibernate.main;

import org.hibernate.Session;

public class Main {
	public static void main(String[] args) {
		final Session sesion= HibernateUtil.getSessionFactory().openSession();
	}
}
