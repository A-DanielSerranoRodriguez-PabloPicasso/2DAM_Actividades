package utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FileWorker extends Thread {
	private String rutaImagen;
	private int ancho, alto;
	private File outputFolder;

	/**
	 * Hilo que crea una copia redimensionada de una imagen "jpg" en un directorio y
	 * destruye la original.
	 * 
	 * Destruye los archivos independientemente del tipo que sean.
	 * 
	 * @param rutaImagen   String
	 * @param ancho        int
	 * @param alto         int
	 * @param outputFolder File
	 */
	public FileWorker(String rutaImagen, int ancho, int alto, File outputFolder) {
		this.rutaImagen = rutaImagen;
		this.ancho = ancho;
		this.alto = alto;
		this.outputFolder = outputFolder;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		File archivo = new File(rutaImagen);
		if (archivo.exists() && archivo.getName().matches(".*.jpg")) {
			try {
				ImageWorker.resizeImage(archivo.getName(), ImageIO.read(archivo), ancho, alto, outputFolder);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		archivo.delete();
	}

}
