package models;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class DescifraAES {
	private static String decodedMessage = null;

	public static String descifra(String codedMessage, String passwd) {
//		String algorithm = "AES";
//		
//
//		Key key = new SecretKeySpec(Base64.getDecoder().decode(secretKey), algorithm);
//		try {
//			Cipher cipher = Cipher.getInstance(algorithm);
//			cipher.init(Cipher.DECRYPT_MODE, key);
//			byte[] decodeTo64 = Base64.getDecoder().decode(codedMessage);
//			byte[] decodeToString = cipher.doFinal(decodeTo64);
//			decodedMessage = new String(decodeToString);
//		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
//			e.printStackTrace();
//		} catch (InvalidKeyException e) {
//			e.printStackTrace();
//		} catch (IllegalBlockSizeException e) {
//			e.printStackTrace();
//		} catch (BadPaddingException e) {
//			e.printStackTrace();
//		}
		try {
			decodedMessage = desencrypt(codedMessage, passwd);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
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

	private static String desencrypt(String message, String passwd) throws IllegalBlockSizeException,
			BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		String algorithm = "AES";

		SecretKey sKey = SecretKeyWorker.keyGenerator(passwd);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.DECRYPT_MODE, sKey);

		byte[] from64 = Base64.getDecoder().decode(message);
		byte[] toString = cipher.doFinal(from64);

		return new String(toString);
	}
}
