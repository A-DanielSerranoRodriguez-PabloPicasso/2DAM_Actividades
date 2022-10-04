package models;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class DescifraAES {
	private static String decodedMessage = null;

	public static String descifra(String codedMessage, String secretKey) {
		String algorithm = "AES";

		Key key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), algorithm);
		try {
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decodeTo64 = Base64.getDecoder().decode(codedMessage);
			byte[] decodeToString = cipher.doFinal(decodeTo64);
			decodedMessage = new String(decodeToString);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}

		return decodedMessage;
	}

	public static String getDecodedMessage() {
		return decodedMessage;
	}

	public static void destroyDecodedMessage() {
		decodedMessage = null;
	}
}
