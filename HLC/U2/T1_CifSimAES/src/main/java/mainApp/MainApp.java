package mainApp;

import models.CifraAES;
import models.DescifraAES;

public class MainApp {

	public static void main(String[] args) {
		CifraAES.cifra(args[0], args[1]);
		System.out.println("Mensaje: " + DescifraAES.descifra(CifraAES.getCodedMessage(), "arriba"));
	}

}
