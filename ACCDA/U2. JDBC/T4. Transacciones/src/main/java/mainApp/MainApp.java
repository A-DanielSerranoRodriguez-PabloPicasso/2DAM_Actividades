package mainApp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.GeneralDAO;
import utils.FileWorker;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<String[]> datos = null;
		try {
			// Data is retrieved from the file
			datos = FileWorker.getData("src/main/resources/datos.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			GeneralDAO gDao = new GeneralDAO();
			// Data is inserted
			gDao.insertData(datos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
