package mainApp;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.CorreoE;
import models.Profesor;

public class MainApp {

	public static void main(String[] args) {
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
    	SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
    	Session session;
		
		Profesor p = new Profesor(7, "D", "A", "N");
		Set<CorreoE> correos = new HashSet<>();
		correos.add(new CorreoE(3, "a@d", p));
		correos.add(new CorreoE(2, "a@d", p));
		correos.add(new CorreoE(1, "a@d", p));
		
		p.setCorreosE(correos);
		
		session = sf.openSession();
		session.beginTransaction();
		session.save(p);
		session.getTransaction().commit();
		session.close();
	}

}
