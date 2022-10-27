package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileWorker {
	/**
	 * Reads a file with a specific format and obtains its data
	 * 
	 * @param filePath String
	 * @return ArrayList<String[]>
	 * @throws IOException - if an error occurs with the file
	 */
	public static ArrayList<String[]> getData(String filePath) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		ArrayList<String> dataRead = new ArrayList<>();
		ArrayList<String[]> data = new ArrayList<>();
		Object[] dataRaw;
		String linea;

		while ((linea = br.readLine()) != null)
			dataRead.add(linea);
		br.close();

		dataRaw = new Object[dataRead.size()];

		dataRaw = dataRead.toArray();
		for (int i = 0; i < dataRaw.length; i++) {
			data.add(((String) dataRaw[i]).split(";"));
		}

		return data;
	}
}
