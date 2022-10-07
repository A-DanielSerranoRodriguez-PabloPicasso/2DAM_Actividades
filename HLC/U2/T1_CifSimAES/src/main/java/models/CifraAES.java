package models;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class CifraAES {
	private static String codedMessage = null;

	public static String cifra(String mensaje, String passwd) {
		try {
			codedMessage = encrypt(mensaje, passwd);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}

		return codedMessage;
	}

	public static String getCodedMessage() {
		return codedMessage;
	}

	public static void destroyCodedMessage() {
		codedMessage = null;
	}
	
	private static String encrypt(String message, String passwd) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		String algorithm = "AES";
		
		SecretKey sKey = SecretKeyWorker.keyGenerator(passwd);
		Cipher cipher = Cipher.getInstance(algorithm);
		cipher.init(Cipher.ENCRYPT_MODE, sKey);
		
		return Base64.getEncoder().encodeToString(cipher.doFinal(message.getBytes()));
	}
}
