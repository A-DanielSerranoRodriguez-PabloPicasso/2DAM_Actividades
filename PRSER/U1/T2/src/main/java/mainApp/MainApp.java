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

		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/datos.txt")));
			while((linea = br.readLine()) != null && !linea.isBlank()) {
				testeo.add(Integer.parseInt(linea));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Sorter.sorter(testeo);
		for (Integer num : testeo) {
			System.out.println(num);
		}

	}
}
