package mainApp;

import codex.CifraAES;
import codex.DescifraAES;

public class MainApp {

	public static void main(String[] args) {
		String textoCifrado = CifraAES.cifrar(args[0], args[1]);
		System.out.println(textoCifrado);

		String textoDescifrado = DescifraAES.descifrar(textoCifrado, args[1]);
		System.out.println(textoDescifrado);
	}
}
