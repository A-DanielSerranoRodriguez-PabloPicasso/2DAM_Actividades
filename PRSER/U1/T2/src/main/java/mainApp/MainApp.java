package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		BufferedReader br = null;
		String linea;
		try {
			br = new BufferedReader(new FileReader(new File("src/main/resources/datos.txt")));
			while ((linea = br.readLine()) != null) {
				if (!linea.isBlank())
					numeros.add(Integer.parseInt(linea));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		numeros.sort((o1, o2) -> o1 - o2);
	}

}
