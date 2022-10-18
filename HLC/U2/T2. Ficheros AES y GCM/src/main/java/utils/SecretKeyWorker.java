package utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class SecretKeyWorker {
	/**
	 * Creates a secret key from a password and iv
	 * 
	 * @param passwd String
	 * @param iv     byte[12]
	 * @return SecretKeySpec (SecretKey)
	 * @throws NoSuchAlgorithmException - if the algorithm doesn't exists for
	 *                                  SecretKeyFactory
	 * @throws InvalidKeySpecException  - if the KeySpec used is invalid for
	 *                                  SecretKeyFactory
	 */
	public static SecretKey getSecretKey(String passwd, byte[] iv)
			throws NoSuchAlgorithmException, InvalidKeySpecException {
		// Encryption is made with 128 bytes because GCM doesn't support 256
		KeySpec kspec = new PBEKeySpec(passwd.toCharArray(), iv, 12, 128);
		SecretKeyFactory skfact = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] key = skfact.generateSecret(kspec).getEncoded();
		return new SecretKeySpec(key, "AES");
	}
}
