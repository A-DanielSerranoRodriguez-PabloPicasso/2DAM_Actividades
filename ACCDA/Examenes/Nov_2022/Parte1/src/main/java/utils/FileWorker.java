package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.Superusuario;

public class FileWorker {
	/**
	 * Lee un fichero y devuelve una lista de superusuarios con su contenido.
	 * 
	 * @param archivo File
	 * @return ArrayList<Superusuario>
	 * @throws IOException
	 */
	public static ArrayList<Superusuario> getUsuarios(File archivo) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		String linea = null;
		ArrayList<Superusuario> superusers = new ArrayList<>();

		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split(",");
			superusers.add(new Superusuario(partes[1], partes[0]));
		}

		br.close();
		return superusers;
	}
}
