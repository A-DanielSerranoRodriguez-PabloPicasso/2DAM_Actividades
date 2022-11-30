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
		Properties props = new Properties();
		try {
			props.load(new BufferedReader(new FileReader(new File("config.properties"))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Configuracion config = new Configuracion(props.getProperty("inputFolder"), props.getProperty("outputFolder"),
				props.getProperty("maxWidth"), props.getProperty("maxHeight"));
		
		WatchServiceUtil.monitorizarCarpeta(config);
	}

}
