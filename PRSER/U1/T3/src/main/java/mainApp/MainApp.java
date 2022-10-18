package mainApp;

import java.io.BufferedReader;
import java.io.IOException;

import utils.FileWorker;

public class MainApp {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int processors = Runtime.getRuntime().availableProcessors();
		Process[] procesos = new Process[processors];
		String datosPath = "datos.txt";
		String dumpFiles_Path = "dump/";
		String[] nums = new String[processors];

		FileWorker.generateContent(datosPath);

		ProcessBuilder pb = new ProcessBuilder("java", "models.HM_Archivo", "placeholder");

		for (int i = 0; i < processors; i++) {
			pb.command().remove(2);
			pb.command().add(dumpFiles_Path + "datos_" + i + ".txt");
			try {
				procesos[i] = pb.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < nums.length; i++) {
			BufferedReader br = new BufferedReader(procesos[i].inputReader());
			try {
				nums[i] = br.readLine();
				System.out.println(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		pb.command().remove(2);
		pb.command().remove(1);
		pb.command().add("models.HM_Numeros");
		for (int i = 0; i < nums.length; i++) {
			pb.command().add(nums[i]);
		}

		Process fin;
		BufferedReader br = null;
		try {
			fin = pb.start();
			br = new BufferedReader(fin.inputReader());
			System.out.println("Media: " + br.readLine());
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		FileWorker.deleteFiles();

		System.out.println("Se ha tardado " + (double) (System.currentTimeMillis() - startTime) / 1000 + " segundos");
	}
}
