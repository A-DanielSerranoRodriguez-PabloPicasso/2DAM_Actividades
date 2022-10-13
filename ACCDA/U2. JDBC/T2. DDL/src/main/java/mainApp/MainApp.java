package mainApp;

import java.sql.SQLException;

import dao.Prueba2DAO;

public class MainApp {

	public static void main(String[] args) {
		try {
			Prueba2DAO pDao = new Prueba2DAO();
			pDao.createAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
