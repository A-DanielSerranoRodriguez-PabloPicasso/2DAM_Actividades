package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class HM_Archivo {
	protected static int hacerMedia(String file) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("java", "-cp", "./bin", "models.HM_Archivo", file);
		long startTime = System.currentTimeMillis();
		Process p = pb.start();
		BufferedReader br = new BufferedReader(p.inputReader());
		System.out.println("Duracion proceso: " + (double) (System.currentTimeMillis() - startTime) / 100);
		return Integer.parseInt(br.readLine());
	}

	public static void main(String[] args) {
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
	}
}
