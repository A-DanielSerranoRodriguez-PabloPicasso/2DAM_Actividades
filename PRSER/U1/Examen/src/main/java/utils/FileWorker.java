package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
	/**
	 * Lee un archivo y devuelve una lista con los numeros del archivo
	 * 
	 * @param rutaArchivo String
	 * @return List<Double>
	 * @throws IOException
	 */
	public static List<Double> leerArchivo(String rutaArchivo) throws IOException {
		File archivo = new File(rutaArchivo);
		BufferedReader br = null;
		List<Double> lista = new ArrayList<>();
		String linea;

		br = new BufferedReader(new FileReader(archivo));
		while ((linea = br.readLine()) != null)
			lista.add(Double.parseDouble(linea.replace(',', '.')));

		br.close();

		return lista;
	}
}
