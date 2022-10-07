package codex;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import utils.SecretKeyWorker;

public class CifraAES {
	/**
	 * Encrypts a message with a given password
	 * 
	 * @param message String
	 * @param passwd  String
	 * @return Base64 encoded String. Null in case of failure
	 */
	public static String encrypt(String message, String passwd) {
		try {
			// The cipher is initialized in encryption mode, using a SecretKey generated
			// with the password
			SecretKey sKey = SecretKeyWorker.generateKey(passwd);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, sKey);

			// The message is encoded with the cipher, and then encoded in Base64
			return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
