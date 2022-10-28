package utils;

import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyPairWorker {
	public static KeyPair keys;

	public static void generateKeys(String passwd) throws NoSuchAlgorithmException {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(passwd.getBytes());

		kpg.initialize(1024, sr);

		keys = kpg.generateKeyPair();
		try {
			FileWorker.generateFiles();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
