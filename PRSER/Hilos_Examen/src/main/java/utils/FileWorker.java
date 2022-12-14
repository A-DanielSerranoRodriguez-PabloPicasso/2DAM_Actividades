package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import models.Configuracion;

public class FileWorker {

	public static void procesarArchivo(String archivo, Configuracion config) throws IOException {
		File file = new File(archivo);
		double maximo = Double.MIN_VALUE, minimo = Double.MAX_VALUE, media = 0;
		int cantidadNum = 0;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String lineaVacia;

		while ((lineaVacia = br.readLine()) != null) {
			lineaVacia = lineaVacia.replaceAll(",", ".");
			Double numero = Double.parseDouble(lineaVacia.substring(lineaVacia.lastIndexOf('=') + 1));

			/*
			 * Comprueba que queremos cacular la media.
			 * 
			 * Como la media es necesaria para la desviacion tipica, tambien se incluye
			 */
			if (config.isCalculaMedia() || config.isCalculaDesvicacionTipica()) {
				media += numero;
				cantidadNum++;
			}

			if (config.isCalculaMaximo() && maximo < numero)
				maximo = numero;

			if (config.isCalculaMinimo() && minimo > numero)
				minimo = numero;

		}

		if (config.isCalculaMedia())
			media = media / cantidadNum;

		br.close();

		escribirResultados(archivo, config, media, cantidadNum, maximo, minimo);

	}

	public static void escribirResultados(String archivo, Configuracion config, double media, double desvTip,
			double max, double min) throws IOException {
		String nombre = archivo.replaceAll(".job", ".out").replaceAll(config.getCarpetaEntrada(),
				config.getCarpetaSalida());
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(nombre)));

		if (config.isCalculaMedia())
			bw.write("media=" + media + "\n");

		if (config.isCalculaDesvicacionTipica())
			bw.write("desviacion==" + desvTip + "\n");

		if (config.isCalculaMaximo())
			bw.write("maximo=" + max + "\n");

		if (config.isCalculaMinimo())
			bw.write("minimo=" + min + "\n");

		bw.flush();

		bw.close();

	}

}
