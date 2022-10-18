package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class Sorter {
//	public static ArrayList<Integer> sortier(ArrayList<Integer> lista) {
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
		for (int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
		int[] nums = new int[args.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(args[i]);
		}
		System.out.println();
		System.out.println(sorter(nums));
	}

	public static String sorter(int[] nums) {
		String uno = "", dos = "";

		if (nums.length > 1) {
			int pivote = nums[0];
			ArrayList<Integer> menores = new ArrayList<>(), mayores = new ArrayList<>();

			for (int i = 1; i < nums.length; i++) {
				int num = nums[i];
				if (num < pivote)
					menores.add(num);
				else
					mayores.add(num);
			}

			menores.add(pivote);

			if (menores.size() >= 1) {
				String[] argumentos = new String[menores.size() + 4];
				argumentos[0] = "java";
				argumentos[1] = "-cp";
				argumentos[2] = "./bin";
				argumentos[3] = "models.Sorter";
				for (int i = 4; i < argumentos.length; i++) {
					argumentos[i] = menores.get(i - 4).toString();
				}
				ProcessBuilder pb = new ProcessBuilder(argumentos);
				try {
					String linea;
					Process p = pb.start();
					BufferedReader br = p.inputReader();
					while ((linea = br.readLine()) != null)
						uno = linea;
					p.destroy();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			if (mayores.size() >= 1) {
				String[] argumentos = new String[mayores.size() + 4];
				argumentos[0] = "java";
				argumentos[1] = "-cp";
				argumentos[2] = "./bin";
				argumentos[3] = "models.Sorter";
				for (int i = 4; i < argumentos.length; i++) {
					argumentos[i] = mayores.get(i - 4).toString();
				}
				ProcessBuilder pb = new ProcessBuilder(argumentos);
				try {
					String linea;
					Process p = pb.start();
					BufferedReader br = p.inputReader();
					while ((linea = br.readLine()) != null)
						dos = linea;
					p.destroy();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			return uno + " " + dos;
		}

		return nums[0] + "";
	}
}
