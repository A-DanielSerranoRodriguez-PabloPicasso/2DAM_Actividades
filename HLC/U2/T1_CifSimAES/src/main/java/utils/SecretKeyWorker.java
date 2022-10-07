package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * Class in charge of working with SecretKey objects
 * 
 * @author Daniel Serrano Rodriguez
 *
 */
public class SecretKeyWorker {
	/**
	 * Creates a secret key with the given seed. The key generated is always the
	 * same, given the same password.
	 * 
	 * @param seed String
	 * @return SecretKey object
	 * @throws NoSuchAlgorithmException
	 */
	public static SecretKey generateKey(String seed) throws NoSuchAlgorithmException {
		KeyGenerator kGen = KeyGenerator.getInstance("AES");
		// The "SHA1PRNG" algorithm is used for the SecureRandom. This is because if
		// someone where to execute it in a machine without Windows, the program would
		// be unusable as currently coded
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		// The seed is set using a String
		sr.setSeed(seed.getBytes());
		// Key is generated with 256 bits and the SecureRandom
		kGen.init(256, sr);
		return kGen.generateKey();
	}
}
