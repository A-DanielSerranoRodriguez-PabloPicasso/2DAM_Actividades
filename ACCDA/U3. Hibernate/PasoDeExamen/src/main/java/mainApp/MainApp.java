package mainApp;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import dao.HibernateDAO;
import models.SuperUsuario;
import utils.FileWorker;

public class MainApp {

	public static void main(String args[]) {
		HibernateDAO hDao = new HibernateDAO();
		Session session = hDao.getSession();
		List<String> usuarios = null;
		
		session.beginTransaction();

		try {
			usuarios = FileWorker.leerArchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String usuario : usuarios) {
			String[] nombreApell = usuario.split(",");
			session.save(new SuperUsuario(nombreApell[0].trim(), nombreApell[1].trim()));
		}

		session.getTransaction().commit();

		session.close();
	}

}
