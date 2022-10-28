package mainApp;

import java.security.NoSuchAlgorithmException;

import utils.KeyPairWorker;

public class MainApp {

	public static void main(String[] args) {
		try {
			KeyPairWorker.generateKeys("123456");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}