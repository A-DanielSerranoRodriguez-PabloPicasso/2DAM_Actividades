package mainApp;

import models.CifraFicheroAES;
import models.DescifraFicheroAES;

public class MainApp {

	public static void main(String[] args) {
		CifraFicheroAES.cifrarFichero("src/main/resources/decrypted/datos.txt", "encrypted.bin", "hola");
		DescifraFicheroAES.descifrarFichero("src/main/resources/encrypted/encrypted.bin", "decrypted.txt", "hola");
	}

}