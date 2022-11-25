package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
	/**
	 * Reads the file and returns a list with the lines
	 * @return List<String>
	 * @throws IOException
	 */
	public static List<String> leerArchivo() throws IOException{
		List<String> lineas = new ArrayList<>();
		BufferedReader br;
		String linea;
		
		br = new BufferedReader(new FileReader(new File("src/main/resources/alumnado.txt")));
		
		while((linea = br.readLine())!= null) {
			lineas.add(linea);
		}
		
		br.close();
		
		return lineas;
	}

}
