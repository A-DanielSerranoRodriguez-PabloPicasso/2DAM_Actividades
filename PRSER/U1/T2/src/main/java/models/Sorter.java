package models;

import java.util.ArrayList;

public class Sorter {
	public static ArrayList<Integer> sorter(ArrayList<Integer> lista) {
		int length = lista.size();
		int pivote = length / 2;
		ArrayList<Integer> mayores = new ArrayList<>(), menores = new ArrayList<>();
		int[] ordList1, ordList2;

		for (int i = 0; i < length; i++) {
			if (lista.get(i) >= lista.get(pivote))
				mayores.add(lista.get(i));
			else
				menores.add(lista.get(i));
		}

		menores = sort(menores);
		mayores = sort(mayores);

		lista.addAll(menores);
		lista.addAll(mayores);

		return lista;
	}

	private static ArrayList<Integer> sort(ArrayList<Integer> lista) {
		lista.sort((o1, o2) -> o1 - o2);
		return lista;
	}

//	public static int[] sorter(int[] numeros, int pasadas) {
//		int posPivote = 0 + pasadas, pivote = numeros[posPivote];
//
//		if (posPivote != numeros.length - 1) {
////			numeros = sorter(numeros, ++pasadas);
//			ProcessBuilder pb = new ProcessBuilder("java", "models.Sorter",
//					"sorter(" + numeros + ", " + ++pasadas + ")");
//			Process p = null;
//			String linea;
//			try {
//				p = pb.start();
//				BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//				while ((linea = br.readLine()) != null)
//					System.out.println(linea);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		for (int i = posPivote; i < numeros.length; i++) {
//			if (numeros[i] < pivote) {
//				numeros[posPivote] = numeros[i];
//				numeros[i] = pivote;
//				posPivote = i;
//			}
//		}
//
//		return numeros;
//	}
}
