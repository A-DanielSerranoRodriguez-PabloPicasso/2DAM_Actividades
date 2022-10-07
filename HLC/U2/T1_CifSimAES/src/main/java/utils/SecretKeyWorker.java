package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class SecretKeyWorker {
	public static SecretKey generateKey(String seed) throws NoSuchAlgorithmException {
		KeyGenerator kGen = KeyGenerator.getInstance("AES");
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		sr.setSeed(seed.getBytes());
		kGen.init(256, sr);
		return kGen.generateKey();
	}
}
