package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateDAO {
	SessionFactory sf;
	
	public HibernateDAO() {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
	}
	
	public Session getSession() {
		return sf.openSession();
	}
}
