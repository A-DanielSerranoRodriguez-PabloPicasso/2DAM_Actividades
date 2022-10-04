package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sorter {
	public static int[] sorter(int[] numeros, int pasadas) {
		int posPivote = 0 + pasadas, pivote = numeros[posPivote];

		if (posPivote != numeros.length - 1) {
//			numeros = sorter(numeros, ++pasadas);
			ProcessBuilder pb = new ProcessBuilder("java", "models.Sorter",
					"sorter(" + numeros + ", " + ++pasadas + ")");
			Process p = null;
			String linea;
			try {
				p = pb.start();
				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
				while ((linea = br.readLine()) != null)
					System.out.println(linea);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = posPivote; i < numeros.length; i++) {
			if (numeros[i] < pivote) {
				numeros[posPivote] = numeros[i];
				numeros[i] = pivote;
				posPivote = i;
			}
		}

		return numeros;
	}
}
