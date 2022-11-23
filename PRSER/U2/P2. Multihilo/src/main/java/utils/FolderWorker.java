package utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FolderWorker extends Thread {

	private String rutaArchivo;

	public FolderWorker(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	@Override
	public void run() {
		File archivo = new File(rutaArchivo);
		if(archivo.exists()) {
			try {
				ImageWorker.resizeImage(ImageIO.read(archivo),1000,1000);
			} catch (IOException e) {
				e.printStackTrace();
			}
			archivo.delete();
		}
	}

}
