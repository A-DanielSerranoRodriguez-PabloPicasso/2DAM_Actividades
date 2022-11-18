package mainApp;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import models.Correo;
import models.Profesor;

public class MainApp {
	public static void main(String[] args) {
		Profesor prof = new Profesor(7, "Sara", "Barrera", "Salas");
		Set<Correo> corrEl = new HashSet<>();
		corrEl.add(new Correo(prof, 3, "amogus@here.com"));
		corrEl.add(new Correo(prof, 2, "amogus@here.com"));
		corrEl.add(new Correo(prof, 1, "amogus@here.com"));

		prof.setCorreos(corrEl);

		// SessionFactory. Generador de sesiones
		StandardServiceRegistry sr = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		Session ses = sf.openSession();

		ses.beginTransaction();

		ses.persist(prof);

		ses.getTransaction().commit();
		ses.close();

	}
}
