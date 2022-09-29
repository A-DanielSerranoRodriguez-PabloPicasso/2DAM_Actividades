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
	public static File fichero_CSV_to_Binario(String fichero) {
		File csv = new File(fichero), gen = null;

		if (csv.exists()) {
			String fName = csv.getName();
			int fLenght = csv.getName().length();

			if (fName.charAt(fLenght - 4) == '.') {
				String ofName = fName.substring(0, fLenght - 4), fExtension = fName.substring(fLenght - 3);

				if (fExtension.equals("csv")) {
					String linea, ofExtension = ".dat";
					BufferedReader br = null;
					ObjectOutputStream oos = null;
					try {
						try {
							gen = new File(csv.getAbsolutePath().replaceAll(fName, ofName + ofExtension));
							br = new BufferedReader(new FileReader(csv));
							oos = new ObjectOutputStream(new FileOutputStream(gen));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}

						try {
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
					}
				}
			}
		}
		return gen;
	}

	public static File ordenar_Archivo_CSV(String fichero) {
		File csv = new File(fichero), gen = null;

		if (csv.exists()) {
			String fName = csv.getName();
			int fLenght = csv.getName().length();

			if (fName.charAt(fLenght - 4) == '.') {
				String ofName = fName.substring(0, fLenght - 4), fExtension = fName.substring(fLenght - 3);

				if (fExtension.equals("csv")) {
					ArrayList<String> lineas = new ArrayList<>();
					String linea, categ = "";
					int pos = 0;
					BufferedReader br = null;

					try {
						try {
							br = new BufferedReader(new FileReader(csv));

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
						lineas.sort((o1, o2) -> o1.compareTo(o2));
					}

					BufferedWriter bw = null;

					try {
						try {
							gen = new File(csv.getAbsolutePath().replaceAll(fName, ofName + "_ord." + fExtension));
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
					}
				}
			}
		}
		return gen;
	}
}
