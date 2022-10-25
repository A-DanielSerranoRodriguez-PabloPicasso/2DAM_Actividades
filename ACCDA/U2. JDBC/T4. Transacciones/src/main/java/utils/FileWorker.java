package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWorker {
	public static String[] getData(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		ArrayList<String> dataRead = new ArrayList<>();
		String[] data;
		String linea;

		while ((linea = br.readLine()) != null)
			dataRead.add(linea);
		br.close();

		data = new String[dataRead.size()];
		data = (String[]) dataRead.toArray();

		return data;
	}
}
