package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import models.Configuracion;
import utils.WatchServiceUtil;

public class Dispatcher {

	public static void main(String[] args) {
		/*
		 * Se carga el archivo de propiedades del directorio de trabajo.
		 * 
		 * Se meten esas propiedades en una clase para administrarlas.
		 * 
		 * Se monitoriza la carpeta con esas propiedades.
		 */
		Properties prop = new Properties();
		try {
			prop.load(new BufferedReader(new FileReader(new File("config.properties"))));
		} catch (IOException e) {
			System.err.println("No hay archivo de configuracion.\nUsando valores por defecto\n");
		}

		Configuracion config = new Configuracion(prop.getProperty("inputFolder"), prop.getProperty("outputFolder"),
				prop.getProperty("maxWidth"), prop.getProperty("maxHeight"));

		WatchServiceUtil.monitorizarCarpeta(config);
	}

}
