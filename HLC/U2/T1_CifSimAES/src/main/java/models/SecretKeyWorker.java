package models;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyWorker {
	public static SecretKey keyGenerator(String passwd) throws NoSuchAlgorithmException {
		String algorithm = "AES";

		KeyGenerator kGen = KeyGenerator.getInstance(algorithm);
		SecureRandom sr = new SecureRandom();
		sr.setSeed(passwd.getBytes());
		kGen.init(256, sr);

		return kGen.generateKey();
	}
}
