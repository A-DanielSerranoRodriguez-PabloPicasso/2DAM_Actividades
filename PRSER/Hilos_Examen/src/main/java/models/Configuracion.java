package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {
	private String carpetaEntrada, carpetaSalida;
	private boolean calculaMedia, calculaDesvicacionTipica, calculaMaximo, calculaMinimo;
	private Properties propiedades;

	public Configuracion(String rutaConfig) {
		carpetaEntrada = "./input";
		carpetaSalida = "./output";
		calculaMedia = true;
		calculaDesvicacionTipica = false;
		calculaMaximo = true;
		calculaMinimo = false;
		propiedades = new Properties();

		readProperties(rutaConfig);
		setConfig();
	}

	public String getCarpetaEntrada() {
		return carpetaEntrada;
	}

	public String getCarpetaSalida() {
		return carpetaSalida;
	}

	public boolean isCalculaMedia() {
		return calculaMedia;
	}

	public boolean isCalculaDesvicacionTipica() {
		return calculaDesvicacionTipica;
	}

	public boolean isCalculaMaximo() {
		return calculaMaximo;
	}

	public boolean isCalculaMinimo() {
		return calculaMinimo;
	}

	private void readProperties(String rutaConfig) {
		try {
			propiedades.load(new BufferedReader(new FileReader(new File(rutaConfig))));
		} catch (IOException e) {
		}
	}

	private void setConfig() {
		File carpeta;
		String carpEntrada, carpSalida, calcMedia, calcDesvTip, calcMax, calcMin;

		carpEntrada = propiedades.getProperty("carpetaEntrada");
		if (carpEntrada != null)
			carpetaEntrada = carpEntrada;

		carpeta = new File(carpetaEntrada);
		if (!carpeta.exists())
			carpeta.mkdirs();

		carpSalida = propiedades.getProperty("carpetaSalida");
		if (carpSalida != null)
			carpetaSalida = carpSalida;

		carpeta = new File(carpetaSalida);
		if (!carpeta.exists())
			carpeta.mkdirs();

		calcMedia = propiedades.getProperty("calculaMedia");
		if (calcMedia != null) {
			switch (calcMedia) {
			case "true":
				calculaMedia = true;
				break;

			case "false":
				calculaMedia = false;
				break;
			}
		}

		calcDesvTip = propiedades.getProperty("calculaDesvicacionTipica");
		if (calcDesvTip != null) {
			switch (calcDesvTip) {
			case "true":
				calculaDesvicacionTipica = true;
				break;

			case "false":
				calculaDesvicacionTipica = false;
				break;
			}
		}

		calcMax = propiedades.getProperty("calculaMaximo");
		if (calcMax != null) {
			switch (calcMax) {
			case "true":
				calculaMaximo = true;
				break;

			case "false":
				calculaMaximo = false;
				break;
			}
		}

		calcMin = propiedades.getProperty("calculaMinimo");
		if (calcMin != null) {
			switch (calcMin) {
			case "true":
				calculaMinimo = true;
				break;

			case "false":
				calculaMinimo = false;
				break;
			}
		}
	}

}
