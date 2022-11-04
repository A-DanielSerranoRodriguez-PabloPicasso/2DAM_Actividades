package mainApp;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.Neptuno2DAO;
import model.Categoria;

public class MainApp {

	/**
	 * Inserta 20 categorias en la base de datos y actualiza sus valores.
	 * 
	 * Se utiliza un procesamiento por lotes de 5.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/**
		 * Utilizamos un DAO para la base de datos bd_neptuno2.
		 * 
		 * Utilizamos 2 ArrayList<Categoria>, uno tiene las categorias a almacenar y el
		 * otro tiene las categorias con los nuevos valores.
		 * 
		 * Utilizamos un limite explicito para tener un mejor control de los valores y
		 * la cantidad de categorias.
		 */
		Neptuno2DAO nDao = null;
		ArrayList<Categoria> categorias = new ArrayList<>();
		ArrayList<Categoria> cambios = new ArrayList<>();
		int limit = 20;

		for (int i = 1; i <= limit; i++) {
			categorias.add(new Categoria("Categoria" + i, "Descripcion" + i));
			cambios.add(new Categoria("Categoria" + (i + limit), "Descripcion" + (i + limit)));
		}

		try {
			nDao = new Neptuno2DAO();
			nDao.insertCategoriaBatch(categorias);

			nDao.updateCategoriaBatch(categorias, cambios, true, true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
