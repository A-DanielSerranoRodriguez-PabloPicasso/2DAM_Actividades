package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HM_Archivo {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		BufferedReader br = null;
		int sum = 0, total = 0;
		String aux;

		try {
			br = new BufferedReader(new FileReader(new File(args[0])));
			while ((aux = br.readLine()) != null)
				if (!aux.isBlank()) {
					sum += Integer.parseInt(aux);
					total++;
				}
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println(sum / total);
		System.out.println("Duracion proceso media archivo: " + (double) (System.currentTimeMillis() - startTime) / 100);
	}
}
