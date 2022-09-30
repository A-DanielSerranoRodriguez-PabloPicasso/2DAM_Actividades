package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CSV {
	private static final String datExt = ".dat", csvExt = ".csv";
	private static final String datFolder = "DAT", csvFolder = "CSV";

	/**
	 * Turns a CSV file to a Binary file with the ".dat" extension
	 * 
	 * @param fichero Absolute path of the file
	 * @return File created or null if "fichero" doesn't exists / has a wrong
	 *         extension
	 */
	public static File fichero_CSV_to_Binario(String fichero) {
		File csv = new File(fichero), gen = null;

		// Check file exists
		if (csv.exists()) {
			String fName = csv.getName();
			// Check if the extension matches
			if (fName.endsWith(csvExt)) {
				String ofName = fName.replaceAll(csvExt, datExt);
				String linea,
						// Creates the path for the new file, removing the name, changing the folder
						// to the correct one and adding the new name with the correct extension
						ofPath = csv.getAbsolutePath().replaceAll(csvFolder, datFolder).replaceAll(fName, ofName);
				BufferedReader br = null;
				ObjectOutputStream oos = null;
				try {
					try {
						// Reader for the file and writer for the new file
						gen = new File(ofPath);
						br = new BufferedReader(new FileReader(csv));
						oos = new ObjectOutputStream(new FileOutputStream(gen));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					try {
						// Reads the file and writes the lines to the new file
						while ((linea = br.readLine()) != null) {
							oos.writeObject((String) linea + "\n");
						}
						oos.flush();
					} finally {
						oos.close();
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					Logger.Log("fichero_CSV_to_Binario", fichero, gen.getAbsolutePath(), true);
				}
				return gen;
			}
		}
		// If extension doesn't match, or file doesn't exists, failure is logged
		Logger.Log("fichero_CSV_to_Binario", fichero, "X", false);
		return gen;
	}

	/**
	 * Orders a CSV file
	 * 
	 * @param fichero Absolute path of the file
	 * @return File created or null if "fichero" doesn't exists / has a wrong
	 *         extension
	 */
	public static File ordenar_Archivo_CSV(String fichero) {
		File csv = new File(fichero), gen = null;

		// Check file exists
		if (csv.exists()) {
			String fName = csv.getName();
			// Check if the extension matches
			if (fName.endsWith(csvExt)) {
				// Creates the new name, obtaining the original name and appending the new text
				String ofName = fName.substring(0, fName.lastIndexOf(".")) + "_ord" + csvExt;
				ArrayList<String> lineas = new ArrayList<>();
				String linea, categ = "";
				BufferedReader br = null;
				int pos = 0;

				try {
					try {
						// Reader for the file
						br = new BufferedReader(new FileReader(csv));

						// We save the lines, the first one in its own String.
						while ((linea = br.readLine()) != null) {
							if (pos == 0) {
								categ = linea;
								pos++;
							} else
								lineas.add(linea);
						}
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} finally {
						br.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					// We order the list
					lineas.sort((o1, o2) -> o1.compareTo(o2));
				}

				BufferedWriter bw = null;

				try {
					try {
						// Writer for the new file
						gen = new File(csv.getAbsolutePath().replaceAll(fName, ofName));
						bw = new BufferedWriter(new FileWriter(gen));

						bw.write(categ + "\n");
						for (String l : lineas) {
							bw.write(l + "\n");
						}

						bw.flush();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} finally {
						bw.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					Logger.Log("ordenar_Archivo_CSV", fichero, gen.getAbsolutePath(), true);
				}
				return gen;
			}
		}
		// If extension doesn't match, or file doesn't exists, failure is logged
		Logger.Log("ordenar_Archivo_CSV", fichero, "X", false);
		return gen;
	}
}
