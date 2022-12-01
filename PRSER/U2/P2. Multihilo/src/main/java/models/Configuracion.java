package models;

import java.io.File;

public class Configuracion {
	private String dFolder = "input", dOutputFolder = "output";
	private int width = 100, height = 100;
	private File folder, outputFolder;

	/**
	 * Crea una configuracion con los valores introducidos.
	 * 
	 * Si los valores introducidos son "null", se utilizan valores predeterminados.
	 * 
	 * @param pathFolder       String con la ruta de la carpeta donde se introducen
	 *                         las imagenes.
	 * @param pathOutputFolder String con la ruta de la carpeta donde saldran las
	 *                         imagenes procesadas.
	 * @param width            String con el ancho maximo para la imagen.
	 * @param height           String con la altura maxima para la imagen.
	 */
	public Configuracion(String pathFolder, String pathOutputFolder, String width, String height) {
		validateFolder(pathFolder);
		validateOutputFolder(pathOutputFolder);
		validateWidth(width);
		validateHeight(height);
	}

	/**
	 * Comprueba que el valor no es "null" y crea la carpeta.
	 * 
	 * Si es "null", se utiliza una carpeta por defecto en el directorio de trabajo.
	 * 
	 * @param pathFolder String
	 */
	private void validateFolder(String pathFolder) {
		if (pathFolder == null) {
			pathFolder = dFolder;
		}

		folder = new File(pathFolder);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		if (pathFolder.equals(dFolder)) {
			System.err.println("Usando directorio por defecto:\n" + folder.getAbsolutePath() + "\n");
		}
	}

	/**
	 * Comprueba que el valor no es "null" y crea la carpeta.
	 * 
	 * Si es "null", se utiliza una carpeta por defecto en el directorio de trabajo.
	 * 
	 * @param pathFolder String
	 */
	private void validateOutputFolder(String pathFolder) {
		if (pathFolder == null) {
			pathFolder = dOutputFolder;
		}

		outputFolder = new File(pathFolder);

		if (!outputFolder.exists()) {
			outputFolder.mkdirs();
		}

		if (pathFolder.equals(dOutputFolder)) {
			System.err.println("Usando directorio de salida por defecto:\n" + outputFolder.getAbsolutePath() + "\n");
		}
	}

	/**
	 * Comprueba que el valor no es "null".
	 * 
	 * Si es "null", se utiliza un valor por defecto.
	 * 
	 * @param pathFolder String
	 */
	private void validateWidth(String width) {
		if (width != null)
			this.width = Integer.parseInt(width);
		else
			System.err.println("Usando ancho por defecto:\n" + this.width + "\n");
	}

	/**
	 * Comprueba que el valor no es "null".
	 * 
	 * Si es "null", se utiliza un valor por defecto.
	 * 
	 * @param pathFolder String
	 */
	private void validateHeight(String height) {
		if (height != null)
			this.height = Integer.parseInt(height);
		else
			System.err.println("Usando altura por defecto:\n" + this.height + "\n");
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public File getFolder() {
		return folder;
	}

	public File getOutputFolder() {
		return outputFolder;
	}

	public String getFolderPath() {
		return folder.getAbsolutePath();
	}

	public String getOutputFolderPath() {
		return outputFolder.getAbsolutePath();
	}

}
