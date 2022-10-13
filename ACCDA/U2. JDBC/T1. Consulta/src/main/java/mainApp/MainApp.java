package mainApp;

import java.io.IOException;
import java.sql.SQLException;

import dao.Dao;

public class MainApp {

	public static void main(String[] args) {
		try {
			Dao dao = new Dao();
			dao.getData("clientes");
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}
	}

}
