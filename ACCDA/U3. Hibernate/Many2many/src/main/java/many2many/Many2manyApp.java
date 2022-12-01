package many2many;

import org.hibernate.Session;

import dao.HibernateDAO;
import models.Modulo;
import models.Profesor;

public class Many2manyApp {
	public static void main(String[] args) {
		HibernateDAO hDao = new HibernateDAO();
		Session session = hDao.getSession();

		Profesor p1 = new Profesor(11, "Isabel", "Fuertes", "Gascón");
		Profesor p2 = new Profesor(12, "Jose", "Valenciano", "Gimeno");

		Modulo m1 = new Modulo(1, "Sistemas Operativos en Red");
		Modulo m2 = new Modulo(2, "Entornos de desarrollo");
		Modulo m3 = new Modulo(3, "Sistemas Informáticos");
		
		p1.addModulo(m1);
		p1.addModulo(m2);
		p2.addModulo(m3);
		
		m1.addProfesor(p1);
		m2.addProfesor(p1);
		m3.addProfesor(p2);
		
		session.beginTransaction();
		
		session.save(p1);
		session.save(p2);
		
		session.getTransaction().commit();
		session.close();
	}
}
