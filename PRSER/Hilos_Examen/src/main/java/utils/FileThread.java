package utils;

import java.io.IOException;

import models.Configuracion;

public class FileThread extends Thread {

	private String archivoRuta;
	private Configuracion config;

	public FileThread(String archivo, Configuracion config) {
		archivoRuta = archivo;
		this.config = config;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		try {
			FileWorker.procesarArchivo(archivoRuta, config);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
