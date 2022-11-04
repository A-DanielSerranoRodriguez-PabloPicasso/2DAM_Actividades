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
			try {
				resumen = resumenSHA(args[0]);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println(resumen);
		} else if (args.length == 0)
			System.out.println(
					"Introduce un archivo como parametro. Opcionalmente, añade un algoritmo para el resumen [SHA/MD5]");
		else {
			switch (args[1]) {
			case "SHA":
				try {
					resumen = resumenSHA(args[0]);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			case "MD5":
				try {
					resumen = resumenMD5(args[0]);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;

			default:
				System.err.println("Algoritmo incorrecto seleccionado");
			}

			System.out.println(resumen);
		}
	}

	private static String resumenSHA(String rutaArchivo) throws NoSuchAlgorithmException, IOException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		DigestInputStream dis = new DigestInputStream(new FileInputStream(rutaArchivo), md);

		while (dis.read() != -1)
			; // Se lee el archivo hasta el final

		md = dis.getMessageDigest();
		
		dis.close();

		return Base64.getEncoder().encodeToString(md.digest());
	}

	private static String resumenMD5(String rutaArchivo) throws NoSuchAlgorithmException, IOException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		DigestInputStream dis = new DigestInputStream(new FileInputStream(rutaArchivo), md);
		byte[] buffer = new byte[1024];
		int nread;

		while ((nread = dis.read()) != -1)
			md.update(buffer, 0, nread);

		dis.close();

		return Base64.getEncoder().encodeToString(md.digest());
	}
}
