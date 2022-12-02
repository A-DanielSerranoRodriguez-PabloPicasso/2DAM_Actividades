package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import models.Persona;

public class FileWorker {

	public static Persona readAndCreatePersona(String filePath) throws IOException {
		return createPersona(readFile(filePath));
	}

	public static Persona createPersona(HashMap<String, String> atributos) {
		return new Persona(atributos.get("nombreApellidos"), atributos.get("fechaNacimiento"),
				atributos.get("telefonoFijo"), atributos.get("telefonoMovil"), atributos.get("numeroHijos"),
				atributos.get("comunidad"), atributos.get("localidad"), atributos.get("intereses"));
	}

	public static HashMap<String, String> readFile(String filePath) throws IOException {
		File file = new File(filePath);
		HashMap<String, String> lineas = new HashMap<String, String>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String linea;

		while ((linea = br.readLine()) != null) {
			String[] partes = linea.split("=");
			lineas.put(partes[0], partes[1]);
		}

		br.close();

		return lineas;
	}

}
