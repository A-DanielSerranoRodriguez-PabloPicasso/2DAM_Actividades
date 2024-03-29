package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.Sorter;

public class MainApp {

	public static void main(String[] args) {
		ArrayList<Integer> testeo = new ArrayList<>();
		String linea;
		int d = 0;

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/datos.txt")));
			while ((linea = br.readLine()) != null && !linea.isBlank() && d < 100) {
				testeo.add(Integer.parseInt(linea));
				d++;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n\n");
		String[] lista = new String[testeo.size()];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = testeo.get(i).toString();
		}

		Sorter.main(lista);
	}
}
