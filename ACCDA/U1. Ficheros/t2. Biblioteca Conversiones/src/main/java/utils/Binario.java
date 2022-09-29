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
	public static File fichero_Binario_to_CSV(String fichero) {
		File dat = new File(fichero), gen = null;

		if (dat.exists()) {
			String fName = dat.getName();
			int fLenght = dat.getName().length();

			if (fName.charAt(fLenght - 4) == '.') {
				String ofName = fName.substring(0, fLenght - 4), fExtension = fName.substring(fLenght - 3);

				if (fExtension.equals("dat")) {
					String linea, ofExtension = ".csv",
							ofPath = dat.getAbsolutePath().replaceAll(fName, "").replaceAll("DAT", "CSV") + ofName
									+ ofExtension;
					ObjectInputStream ois = null;
					BufferedWriter bw = null;
					try {
						try {
							ois = new ObjectInputStream(new FileInputStream(dat));
							gen = new File(ofPath);
							bw = new BufferedWriter(new FileWriter(gen));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

						try {
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
		}
		Logger.Log("fichero_Binario_to_CSV", fichero, "X", false);
		return gen;
	}

	public static File fichero_Binario_to_CSV_ordenado(String fichero) {
		File dat = new File(fichero), tempDat, csv, csvOrd = null;
		String fName = dat.getName();

		if (dat.exists()) {
			if (fName.substring(fName.lastIndexOf(".") + 1).equals("dat")) {
				String tempName = dat.getAbsolutePath().replaceAll(dat.getName(), "temp_" + dat.getName());
				tempDat = new File(tempName);

				try {
					Files.copy(dat.toPath(), tempDat.toPath());
				} catch (IOException e) {
					e.printStackTrace();
				}

				csv = fichero_Binario_to_CSV(tempDat.getAbsolutePath());
				tempDat.delete();

				csvOrd = CSV.ordenar_Archivo_CSV(csv.getAbsolutePath());
				csvOrd.renameTo(new File(csvOrd.getAbsolutePath().replaceAll("temp_", "")));
				csv.delete();

				Logger.Log("fichero_Binario_to_CSV_ordenado", fichero, csvOrd.getAbsolutePath(), true);
				return csvOrd;
			}
		}
		Logger.Log("fichero_Binario_to_CSV_ordenado", fichero, "X", false);
		return csvOrd;
	}

	public static File ordenar_Archivo_Binario(String fichero) {
		File dat = new File(fichero), csvOrd, oDat = null;
		String fName = dat.getName();

		if (dat.exists()) {
			if (fName.substring(fName.lastIndexOf(".") + 1).equals("dat")) {
				csvOrd = fichero_Binario_to_CSV_ordenado(dat.getAbsolutePath());
				csvOrd = new File(csvOrd.getAbsolutePath().replaceAll("temp_", ""));

				oDat = CSV.fichero_CSV_to_Binario(csvOrd.getAbsolutePath());
				csvOrd.delete();

				Logger.Log("ordenar_Archivo_Binario", fichero, oDat.getAbsolutePath(), true);
				return oDat;
			}
		}
		Logger.Log("ordenar_Archivo_Binario", fichero, "X", false);
		return oDat;
	}
}
