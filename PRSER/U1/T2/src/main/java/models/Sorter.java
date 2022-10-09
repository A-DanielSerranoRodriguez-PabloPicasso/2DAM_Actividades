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

	public static void main(String[] args) {
		// TODO replantear, args tiene todos los nuemros como tal, no un String que
		// parece un array. Mi puta vida loco, pero creo que puede funcionar
		String numeros = args[0], finales = "";

		for (int i = 1; i < numeros.length() - 1; i++) {
			finales += numeros.charAt(i);
		}

		String[] allNume = finales.split(",");
		if (allNume.length > 1) {
			ArrayList<Integer> primero = new ArrayList<>(), segundo = new ArrayList<>(), resultado = new ArrayList<>();
			int pivote = Integer.parseInt(allNume[0].strip());
			String prim, seg;

			for (int i = 1; i < allNume.length; i++) {
				int num = Integer.parseInt(allNume[i].strip());
				if (num < pivote)
					primero.add(num);
				else
					segundo.add(num);
			}
			primero.add(pivote);

			if (primero.size() > 1) {
				ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./bin", "models.Sorter", primero.toString());
				try {
					Process p = pb.start();
					BufferedReader br = p.inputReader();
					String linea;
				} catch (IOException e) {
					e.printStackTrace();
				}
//				prim = main(primero.toString());
			}

			if (segundo.size() > 1) {
				ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./bin", "models.Sorter", segundo.toString());
				try {
					Process p = pb.start();
					BufferedReader br = p.inputReader(), br2 = p.errorReader();
					String linea;
				} catch (IOException e) {
					e.printStackTrace();
				}
//				seg = sorter(segundo);
			}

			resultado.addAll(primero);
			resultado.addAll(segundo);
			for (Integer num : resultado) {
				System.out.println(num);
			}
		}
	}
}
