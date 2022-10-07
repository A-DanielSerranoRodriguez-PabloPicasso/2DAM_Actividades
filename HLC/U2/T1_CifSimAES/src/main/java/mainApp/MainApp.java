package mainApp;

import codex.CifraAES;
import codex.DescifraAES;

public class MainApp {

	public static void main(String[] args) {
		String textoCifrado = CifraAES.encrypt(args[0], args[1]);
		System.out.println(textoCifrado);

		String textoDescifrado = DescifraAES.decrypt(textoCifrado, args[1]);
		System.out.println(textoDescifrado);
	}
}
