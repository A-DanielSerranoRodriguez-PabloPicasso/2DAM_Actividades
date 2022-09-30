package utils;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;

public class Binario {
	private static final String datExt = ".dat", csvExt = ".csv";
	private static final String datFolder = "DAT", csvFolder = "CSV";

	/**
	 * Turns a Binary file with the ".dat" extension into a CSV file
	 * 
	 * @param fichero Absolute path of the file
	 * @return File created or null if "fichero" doesn't exists / has a wrong
	 *         extension
	 */
	public static File fichero_Binario_to_CSV(String fichero) {
		File dat = new File(fichero), gen = null;

		// Check if file exists
		if (dat.exists()) {
			String fName = dat.getName();
			// Check if extension matches
			if (fName.endsWith(datExt)) {
				String ofName = fName.replaceAll(datExt, csvExt);
				String linea, ofPath = dat.getAbsolutePath().replaceAll(datFolder, csvFolder).replaceAll(fName, ofName);
				ObjectInputStream ois = null;
				BufferedWriter bw = null;
				try {
					try {
						// Reader for the file and writer for the new file
						ois = new ObjectInputStream(new FileInputStream(dat));
						gen = new File(ofPath);
						bw = new BufferedWriter(new FileWriter(gen));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}

					try {
						// Reads a line of the file and writes it to the new line
						while ((linea = (String) ois.readObject()) != null) {
							bw.write(linea);
						}
						bw.flush();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (EOFException e) {
					} finally {
						bw.close();
						ois.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					Logger.Log("fichero_Binario_to_CSV", fichero, gen.getAbsolutePath(), true);
				}
				return gen;
			}
		}
		// If extension doesn't match, or file doesn't exists, failure is logged
		Logger.Log("fichero_Binario_to_CSV", fichero, "X", false);
		return gen;
	}

	/**
	 * Turns a Binary file with the ".dat" extension into an ordered CSV file
	 * 
	 * @param fichero Absolute path of the file
	 * @return File created or null if "fichero" doesn't exists / has a wrong
	 *         extension
	 */
	public static File fichero_Binario_to_CSV_ordenado(String fichero) {
		File dat = new File(fichero);

		// Check if file exists
		if (dat.exists()) {
			String fName = dat.getName();
			// Check if extension matches
			if (fName.endsWith(datExt)) {
				// Creates a temporal file, which is a copy of the file
				String tempName = dat.getAbsolutePath().replaceAll(dat.getName(), "temp_" + dat.getName());
				File tempDat = new File(tempName), csv, csvOrd;

				try {
					Files.copy(dat.toPath(), tempDat.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}

				// Turns the file into a CSV file, orders it and returns it
				csv = fichero_Binario_to_CSV(tempDat.getAbsolutePath());
				tempDat.delete();

				csvOrd = CSV.ordenar_Archivo_CSV(csv.getAbsolutePath());
				csvOrd.renameTo(new File(csvOrd.getAbsolutePath().replaceAll("temp_", "")));
				csv.delete();

				Logger.Log("fichero_Binario_to_CSV_ordenado", fichero, csvOrd.getAbsolutePath(), true);
				return csvOrd;
			}
		}
		// If extension doesn't match, or file doesn't exists, failure is logged
		Logger.Log("fichero_Binario_to_CSV_ordenado", fichero, "X", false);
		return null;
	}

	/**
	 * Turns a Binary file with the ".dat" extension into an ordered CSV file, and
	 * then converts it back to a ".dat" Binary file
	 * 
	 * @param fichero Absolute path of the file
	 * @return File created or null if "fichero" doesn't exists / has a wrong
	 *         extension
	 */
	public static File ordenar_Archivo_Binario(String fichero) {
		File dat = new File(fichero);

		// Check if file exists
		if (dat.exists()) {
			String fName = dat.getName();
			// Check if extension matches
			if (fName.endsWith(datExt)) {
				File csvOrd, oDat;
				// Obtains an ordered CSV and turns it into a Binary file and returns it
				csvOrd = fichero_Binario_to_CSV_ordenado(dat.getAbsolutePath());
				csvOrd = new File(csvOrd.getAbsolutePath().replaceAll("temp_", ""));

				oDat = CSV.fichero_CSV_to_Binario(csvOrd.getAbsolutePath());
				csvOrd.delete();

				Logger.Log("ordenar_Archivo_Binario", fichero, oDat.getAbsolutePath(), true);
				return oDat;
			}
		}
		// If extension doesn't match, or file doesn't exists, failure is logged
		Logger.Log("ordenar_Archivo_Binario", fichero, "X", false);
		return null;
	}
}
