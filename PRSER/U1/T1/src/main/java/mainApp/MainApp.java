package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ruta;

		System.out.print("Introduce la ruta para leer: ");
		ruta = sc.nextLine();
		if(ruta.isBlank()) {
			ruta = "src/main/java/mainApp";
		}

		File directorio = new File(ruta);
		// Guardamos la lista de archivos en un array
		String[] arch = directorio.list();

		// Recorremos el array y creamos un archivo con la ruta y el nombre del archivo
		for (int i = 0; i < arch.length; i++) {
			File temp = new File(ruta + "\\" + arch[i]);

			// Si el archivo es un fichero, leemos cuantas lineas tiene
			if (temp.isFile()) {
				try {
					ProcessBuilder pb = new ProcessBuilder("find", "/v", "/C", "\"\"", temp.getAbsolutePath());
					Process p = pb.start();
					// Para leer el contenido, encadenamos los InputStreams
					InputStream is = p.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					String linea;

					while ((linea = br.readLine()) != null) {
						if (!linea.isBlank()) {
							// Profe
//							int numero = Integer.parseInt(linea.substring(linea.lastIndexOf(": ") + 2));
//							System.out.println(numero);

							// Yo
							String[] partes = linea.split(":");
							System.out.println(partes[partes.length - 1].trim());
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		sc.close();
	}
}
