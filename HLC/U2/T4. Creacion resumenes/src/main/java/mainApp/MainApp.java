package mainApp;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MainApp {

	public static void main(String[] args) {
		/*
		 * args[0] = Archivo del que conseguir el resumen
		 * 
		 * args[1] = Algoritmo. SHA (SHA-256) o MD5 (MD5)
		 */
		String resumen = null;

		if (args.length == 1) {
			resumen = resumenSHA(args[0]);
		} else if (args.length == 0)
			System.err.println(
					"Introduce un archivo como parametro. Opcionalmente, añade un algoritmo para el resumen [SHA/MD5]");
		else {
			switch (args[1]) {
			case "SHA":
				resumen = resumenSHA(args[0]);
				break;

			case "MD5":
				resumen = resumenMD5(args[0]);
				break;

			default:
				System.err.println("Algoritmo incorrecto seleccionado");
			}
		}

		System.out.println(resumen);
	}

	/**
	 * Obtiene el resumen de un archio, utilizando SHA_256.
	 * 
	 * @param rutaArchivo - String con la ruta del archivo
	 * @return String - null en caso de error
	 */
	private static String resumenSHA(String rutaArchivo) {
		// Creamos un MessageDigest para poder obtener el resumen del archivo.
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA256");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Algoritmo para MessageDigest incorrecto.");
			e.printStackTrace();
		}

		try {
			return resumenFactory(md, rutaArchivo);
		} catch (IOException e) {
			System.err.println("Error con el archivo.");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el resumen de un archivo, utilizando MD5.
	 * 
	 * @param rutaArchivo - String con la ruta del archivo.
	 * @return String - null en caso de error.
	 */
	private static String resumenMD5(String rutaArchivo) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Algoritmo para MessageDigest incorrecto.");
			e.printStackTrace();
		}

		try {
			return resumenFactory(md, rutaArchivo);
		} catch (IOException e) {
			System.err.println("Error con el archivo.");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Obtiene el resumen de un MessageDigest
	 * 
	 * @param md          - MessageDigest
	 * @param rutaArchivo - String con la ruta del archivo
	 * @return String
	 * @throws IOException - En caso de haber algun error trabajando con el archivo
	 *                     especificado.
	 */
	private static String resumenFactory(MessageDigest md, String rutaArchivo) throws IOException {
		/*
		 * DigestInputStream actualiza el MessageDigest pasado por parametro cada vez
		 * que leemos.
		 */
		DigestInputStream dis = new DigestInputStream(new FileInputStream(rutaArchivo), md);
		byte[] archivoDigest;
		StringBuilder sb;
		int digestLenght;
		String resumen;

		dis.readAllBytes();
		dis.close();

		/*
		 * El resultado de ".digest()" es un byte[] que representa valores
		 * hexadecimales.
		 * 
		 * Se tiene que ordenar, y lo convertimos en un String.
		 * 
		 * Como paso final, se codifican en Base64 por si hay algun caracter especial.
		 */
		archivoDigest = md.digest();
		digestLenght = archivoDigest.length;
		sb = new StringBuilder(digestLenght);

		/**
		 * Recorremos "archivoDigest" y transformamos el byte a String con un formato
		 * especifico. Si este byte solo tiene 1 unidad de tamaño, añadimos un 0 a
		 * nuestro StringBuilder.
		 */
		for (int i = 0; i < digestLenght; i++) {
			String hex = Integer.toHexString(0xff & archivoDigest[i]);
			if (hex.length() == 1)
				sb.append('0');
			sb.append(hex);
		}

		resumen = Base64.getEncoder().encodeToString(sb.toString().getBytes());

		return resumen;
	}

}
