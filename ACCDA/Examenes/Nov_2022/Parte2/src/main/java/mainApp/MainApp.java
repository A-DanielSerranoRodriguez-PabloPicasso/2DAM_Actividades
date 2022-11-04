package mainApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.NeptunoDAO;
import utils.FileWorker;

public class MainApp {

	public static void main(String[] args) {
		int idCat = 7;
		String nombreFichero = "datos.txt";

		try {
			almacenarProductosEnFichero(idCat, nombreFichero);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		FileWorker.fichero_a_tablas(nombreFichero);
	}

	public static void almacenarProductosEnFichero(int idCat, String nombreFichero) throws SQLException {
		NeptunoDAO nDao = new NeptunoDAO();

		FileWorker.escribeCategoria(nombreFichero, nDao.getCategorias(idCat));

		ArrayList<Integer> idProvs = new ArrayList<>();
		ResultSet productos = nDao.getProductos(idCat);
		productos.next();
		while (!productos.isAfterLast()) {
			idProvs.add(productos.getInt(3));
			productos.next();
		}
		idProvs.sort((o1, o2) -> o1 - o2);

		FileWorker.escribeProveedores(nombreFichero, nDao.getProveedores(idProvs));
		FileWorker.escribeProductos(nombreFichero, nDao.getProductos(idCat));
	}

}
