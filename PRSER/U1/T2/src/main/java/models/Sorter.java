package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Sorter {
//	public static ArrayList<Integer> sorter(ArrayList<Integer> lista) {
//		if (lista.size() > 1) {
//			ArrayList<Integer> primero = new ArrayList<>(), segundo = new ArrayList<>(), resultado = new ArrayList<>();
//			int pivote = lista.get(0);
//			
//			for (int i = 1; i < lista.size(); i++) {
//				int num = lista.get(i);
//				if (num < pivote)
//					primero.add(num);
//				else
//					segundo.add(num);
//			}
//			primero.add(pivote);
//
//			if (primero.size() > 1) {
//				primero = sorter(primero);
//			}
//
//			if (segundo.size() > 1) {
//				segundo = sorter(segundo);
//			}
//
//			resultado.addAll(primero);
//			resultado.addAll(segundo);
//			return resultado;
//		}
//		return null;
//	}

	public static String sorter(ArrayList<Integer> lista) {
		if (lista.size() > 1) {
			ArrayList<Integer> primero = new ArrayList<>(), segundo = new ArrayList<>(), resultado = new ArrayList<>();
			int pivote = lista.get(0);
			String prim, seg;

			for (int i = 1; i < lista.size(); i++) {
				int num = lista.get(i);
				if (num < pivote)
					primero.add(num);
				else
					segundo.add(num);
			}
			primero.add(pivote);

			if (primero.size() > 1) {
				ProcessBuilder pb = new ProcessBuilder("java", "models.Sorter", "sorter", primero.toString());
				try {
					Process p = pb.start();
					BufferedReader br = p.inputReader();
					String linea;
					while ((linea = br.readLine()) != null)
						System.out.println(linea);
				} catch (IOException e) {
					e.printStackTrace();
				}
				prim = sorter(primero);
			}

			if (segundo.size() > 1) {
				ProcessBuilder pb = new ProcessBuilder("java", "models.Sorter");
				try {
					Process p = pb.start();
					BufferedReader br = p.inputReader(), br2 = p.errorReader();
					String linea;
					while ((linea = br2.readLine()) != null)
						System.out.println(linea);
					while ((linea = br.readLine()) != null)
						System.out.println(linea);
				} catch (IOException e) {
					e.printStackTrace();
				}
				seg = sorter(segundo);
			}

			resultado.addAll(primero);
			resultado.addAll(segundo);
			return resultado.toString();
		}
		return null;
	}
}
