package models;

import java.io.File;

public class Configuracion {
	private String dFolder = "input", dOutputFolder = "output";
	private int width = 100, height = 100;
	private File folder, outputFolder;

	public Configuracion(String pathFolder, String pathOutputFolder, String width, String height) {
		generateFolder(pathFolder);
		generateOutputFolder(pathOutputFolder);
		validateWidth(width);
		validateHeight(height);
	}

	private void generateFolder(String pathFolder) {
		if (pathFolder == null) {
			pathFolder = dFolder;
		}

		folder = new File(pathFolder);

		if (!folder.exists()) {
			folder.mkdirs();
		}
	}

	private void generateOutputFolder(String pathFolder) {
		if (pathFolder == null) {
			pathFolder = dOutputFolder;
		}

		outputFolder = new File(pathFolder);

		if (!outputFolder.exists()) {
			outputFolder.mkdirs();
		}
	}

	private void validateWidth(String width) {
		if (width != null)
			this.width = Integer.parseInt(width);
	}

	private void validateHeight(String height) {
		if (height != null)
			this.height = Integer.parseInt(height);
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
