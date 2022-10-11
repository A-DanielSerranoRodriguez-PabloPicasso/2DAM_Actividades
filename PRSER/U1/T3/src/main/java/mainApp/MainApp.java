package mainApp;

import java.io.IOException;

import models.HacerMedia_Archivo;
import models.HacerMedia_Numeros;
import utils.FileWorker;

public class MainApp {

	public static void main(String[] args) {
		int processors = Runtime.getRuntime().availableProcessors();
		String datosPath = "src/main/resources/datos.txt";
		String dumpFiles_Path = "src/main/resources/dump/";
		int[] nums = new int[processors];
		
		FileWorker.generateContent(datosPath);

		for (int i = 0; i < processors; i++)
			try {
				nums[i] = HacerMedia_Archivo.hacerMedia(dumpFiles_Path + "datos_" + i + ".txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

		try {
			System.out.println(HacerMedia_Numeros.hacerMedia(nums));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
