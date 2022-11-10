package mainApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import utils.FileWorker;
import utils.MathWorker;

public class DesviacionTipicaApp {

	public static void main(String[] args) {
		/*
		 * args[0] = Ruta de archivo a leer : serie2.txt
		 */
		int procesadores = Runtime.getRuntime().availableProcessors();
		Process[] procesos = new Process[procesadores];
		List<Double> numeros = null;
		String listaParcial = "";
		double media, resultado = 0;
		int longitud, parcial;
		ProcessBuilder pb = new ProcessBuilder("java", "mainApp.SlaveApp");
		BufferedReader br;

		if (args.length == 0) {
			System.err.println("Introduzca un fichero a leer");
		} else {
			try {
				numeros = FileWorker.leerArchivo(args[0]);
			} catch (IOException e) {
				System.err.println("Error leyendo el archivo");
			}

			media = MathWorker.calcularMedia(numeros);
			longitud = numeros.size();
			parcial = longitud / procesadores;

			pb.command().add(Double.toString(media));

			/*
			 * Recorremos los procesadores disponibles.
			 * 
			 * Si estamos en el ultimo, leemos la lista hasta el final. Si no, leemos la
			 * lista hasta el limite para realizar una division equitativa de numeros.
			 * 
			 * Añadimos el argumento al ProcessBuilder, reseteamos la lista y eliminamos el
			 * argumento para tenerlo listo para el proximo ciclo.
			 */
			for (int i = 1; i <= procesadores; i++) {
				if (i == procesadores) {
					for (int j = parcial * (i - 1); j < numeros.size(); j++) {
						listaParcial += numeros.get(j) + " ";
					}
					pb.command().add(listaParcial);
					try {
						procesos[i - 1] = pb.start();
					} catch (IOException e) {
						System.err.println("Error creando proceso");
						e.printStackTrace();
					}
					pb.command().remove(pb.command().size() - 1);
				} else {
					for (int j = 0 + (parcial * (i - 1)); j < parcial * i; j++) {
						listaParcial += numeros.get(j) + " ";
					}
					pb.command().add(listaParcial);
					listaParcial = "";
					try {
						procesos[i - 1] = pb.start();
					} catch (IOException e) {
						System.err.println("Error creando proceso");
						e.printStackTrace();
					}
					pb.command().remove(pb.command().size() - 1);
				}
			}

			for (int i = 0; i < procesos.length; i++) {
				br = procesos[i].inputReader();

				try {
					resultado += Double.parseDouble(br.readLine());
				} catch (NumberFormatException | IOException e) {
					e.printStackTrace();
				}
			}

			resultado = (double) resultado / longitud;

			resultado = Math.sqrt(resultado);

			System.out.println(resultado);
		}
	}

}
