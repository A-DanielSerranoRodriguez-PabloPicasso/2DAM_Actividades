package mainApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Empleado;

public class MainApp {

	public static void main(String[] args) {
		// 1. Pasa el contenido del fichero a un Array o ArrayList para elementos de la
		// clase Empleado.
		String lugarArchivo = "src/main/resources/Datos.txt";
		ArrayList<Empleado> empleados = new ArrayList<>();
		File file = new File(lugarArchivo);
		int pos = 0;

		/**
		 * Leemos el archivo saltando la primera linea.
		 * 
		 * Despues, lo dividimos en un array, haciendo los cambios de formato
		 * necesarios, y lo guardamos.
		 */
		try {
			String linea = new String();
			FileReader fread = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader bfread = new BufferedReader(fread);

			while ((linea = bfread.readLine()) != null) {
				if (pos == 0)
					pos++;
				else {
					String[] partes;

					linea = linea.replaceAll("\"", "");
					partes = linea.split(",");

					empleados.add(new Empleado(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2])));
				}
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
//			for (int i = 0; i < empleados.size(); i++) {
//				System.out.println(empleados.get(i));
//			}

			toArchivoTexto(empleados);
			toArchivoBinarioInverso(empleados);
			System.out.println("Leyendo empleados de archivo normal");
			leer_Empleados("ej2.txt");
			System.out.println("\n\nLeyendo empleados de archivo binario");
			leer_Empleados_b("ej3.bin");
		}

	}

	// 2. Crea un método toArchivoTexto que almacena todos los Empleados de un Array
	// o ArrayList en un archivo de texto.
	public static boolean toArchivoTexto(ArrayList<Empleado> empleados) {
		String lugarArchivo = "src/main/resources/ej2.txt";
		File archivo = new File(lugarArchivo);

		FileWriter fwrite = null;
		try {
			fwrite = new FileWriter(archivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedWriter bwrite = new BufferedWriter(fwrite);

		try {
			for (int i = 0, s = empleados.size(); i < s; i++) {
				bwrite.write(empleados.get(i).toString() + "\n");
			}
			bwrite.flush();
			bwrite.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 3. Crea un método toArchivoBinarioInverso que almacena todos los Empleados
	// del Array o ArrayList en un archivo binario, de forma inversa, empezando por
	// el último.
	public static boolean toArchivoBinarioInverso(ArrayList<Empleado> empleados) {
		String lugarArchivo = "src/main/resources/ej3.bin";
		FileOutputStream fos = null;
		ObjectOutputStream foos = null;

		try {
			fos = new FileOutputStream(lugarArchivo);
			foos = new ObjectOutputStream(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			for (int i = empleados.size() - 1; i >= 0; i--) {
				foos.writeObject((Empleado) empleados.get(i));
			}
			foos.flush();
			foos.close();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	// 4. Crea un método leer_Empleados(String archivo) que lea empleados de un
	// archivo de texto y los imprima por pantalla.
	public static void leer_Empleados(String archivo) {
		String lugarArchivo = "src/main/resources/" + archivo, linea;
		FileReader fread = null;
		try {
			fread = new FileReader(lugarArchivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bread = new BufferedReader(fread);

		try {
			while ((linea = bread.readLine()) != null) {
				System.out.println(linea);
			}
			bread.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void leer_Empleados_b(String archivo) {
		String lugarArchivo = "src/main/resources/" + archivo;
		Object empleado;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(lugarArchivo);
			ois = new ObjectInputStream(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			while ((empleado = ois.readObject()) != null) {
				System.out.println(empleado.toString());
			}
			ois.close();
		} catch (EOFException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
