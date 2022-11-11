package mainApp;

import java.sql.SQLException;

import dao.Neptuno2DAO;

public class MainApp {

	public static void main(String[] args) {
		Neptuno2DAO n2dao;

		try {
			n2dao = new Neptuno2DAO();
			n2dao.updateDescCategoria(1, "Nueva descripcion");

			// Esto es lo que falla, error de out parameter
			System.out.println(n2dao.getCategoria(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
