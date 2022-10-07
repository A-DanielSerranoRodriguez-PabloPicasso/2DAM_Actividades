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

public class DescifraAES {
	/**
	 * Decrypts a message using a given password
	 * 
	 * @param message Base64 encrypted String
	 * @param passwd  String
	 * @return String. Null in case of failure
	 */
	public static String descifrar(String codedMessage, String password) {
		try {
			// The cipher is initialized in decryption mode, using a SecretKey generated
			// with the password
			SecretKey sKey = SecretKeyWorker.generateKey(password);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, sKey);

			// The message is decoded from Base64, and then decoded with the cipher
			return new String(cipher.doFinal(Base64.getDecoder().decode(codedMessage)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		return null;
	}
}
