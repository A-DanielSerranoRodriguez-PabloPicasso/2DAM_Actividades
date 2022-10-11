package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWorker {
	final private static int processors = Runtime.getRuntime().availableProcessors();
	final private static String dumpFile_Path = "src/main/resources/dump/";

	public static void generateContent(String filePath) {
		try {
			createFiles(filePath);
			writeFiles(filePath);
			getParts(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createFiles(String filePath) throws IOException {
		File file = new File(filePath);
		String fileName = file.getName();
		String[] fParts = { fileName.substring(0, fileName.lastIndexOf(".")),
				fileName.substring(fileName.lastIndexOf(".")) };

		for (int i = 0; i < processors; i++)
			new File(dumpFile_Path + fParts[0] + "_" + i + fParts[1]).createNewFile();
	}

	public static void writeFiles(String filePath) throws IOException {
		File file = new File(filePath);
		String fileName = file.getName();
		String[] fParts = { fileName.substring(0, fileName.lastIndexOf(".")),
				fileName.substring(fileName.lastIndexOf(".")) };
		int parte = getParts(filePath);

		BufferedReader br = new BufferedReader(new FileReader(file));
		for (int i = 0; i < processors; i++) {
			BufferedWriter bw = new BufferedWriter(new FileWriter(dumpFile_Path + fParts[0] + "_" + i + fParts[1]));
			int linea = 0;

			while (linea != parte) {
				bw.write(br.readLine() + "\n");
				linea++;
			}

			bw.close();
		}
		br.close();

	}

	private static int getParts(String filePath) throws IOException {
		String linea;
		int lineas = 0;
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));

		while ((linea = br.readLine()) != null)
			if (!linea.isBlank())
				lineas++;

		br.close();

		return lineas / processors;
	}
}
