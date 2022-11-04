package mainApp;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import dao.NeptunoDAO;
import utils.FileWorker;

public class mainApp {
	/**
	 * Lugar donde esta ubicado el archivo al que acceder para obtener los usuarios.
	 */
	private static final String PATH = "src/main/resources/files/";

	public static void main(String[] args) {
		String nombreArchivo = "Alumnado_nuevo.txt";

		crearTablaSuperusuarios(nombreArchivo);
	}

	/**
	 * Crea una tabla en la base de datos bd_neptuno, y le inserta valores obtenidos
	 * de leer un archivo.
	 * 
	 * @param nombreArchivo String
	 */
	private static void crearTablaSuperusuarios(String nombreArchivo) {
		NeptunoDAO nDao = null;
		File archivo = new File(PATH + nombreArchivo);

		try {
			nDao = new NeptunoDAO();
			nDao.createSuperuserTable();
			nDao.insertSuperusers(FileWorker.getUsuarios(archivo));
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

	}
}
