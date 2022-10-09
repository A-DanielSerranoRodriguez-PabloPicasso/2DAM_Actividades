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

//		try {
//			BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/datos.txt")));
//			while((linea = br.readLine()) != null && !linea.isBlank()) {
//				testeo.add(Integer.parseInt(linea));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		testeo.add(6);
		testeo.add(3);
		testeo.add(27);
		testeo.add(8);
		testeo.add(7);

		System.out.println("\n\n");
		int[] lista = new int[testeo.size()];
		for (int i = 0; i < lista.length; i++) {
			lista[i] = testeo.get(i);
		}
		String eo = null;
		String[] array = { testeo.toString() };
		Sorter.main(array);
//		for (Integer num : testeo) {
//			System.out.println(num);
//		}
		System.out.println(eo);
	}
}
