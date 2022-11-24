package mainApp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class MainApp {
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
	SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
	Session session;
	
	public void mainApp(String args[]) {
		
	}

}
