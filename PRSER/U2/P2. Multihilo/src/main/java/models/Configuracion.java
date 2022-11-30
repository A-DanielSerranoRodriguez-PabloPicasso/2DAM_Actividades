package models;

public class Configuracion {
	private String dFolder = "input", dOutputFolder = "output";
	private int dWidth = 100, dHeight = 100;

	public Configuracion(String folder, String outputFolder, int width, int height) {
		dFolder = validateFolder(folder);
		dOutputFolder = outputFolder;
		dWidth = width;
		dHeight = height;
	}
	
	private String validateFolder(String folder) {
		return "";
	}

}
