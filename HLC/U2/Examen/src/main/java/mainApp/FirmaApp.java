package mainApp;

import utils.CriptografiaWorker;

public class FirmaApp {

	public static void main(String[] args) {
		/*
		 * args[0] = Ruta de archivo
		 * 
		 * args[1] = Contraseña del keystore
		 */

		if (args.length != 2) {
			System.err.println("Faltan parámetros");
			System.out.println("USO:");
			System.out.println("\tFirmaApp archivo password");
			System.out.println("\t\tarchivo - Archivo del que se quiere obtener la firma");
			System.out.println("\t\tpassword - Password para desbloquear la clave privada");
		} else
			System.out.println(new String(
					CriptografiaWorker.cifrarBytesRSA(CriptografiaWorker.getResumenArchivo(args[0]), args[1])));
	}

}
