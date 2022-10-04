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
import javax.crypto.spec.SecretKeySpec;

public class CifraAES {
	private static String codedMessage = null;
	private static String key = null;

	public static String cifra(String mensaje, String passwd) {
		String algorithm = "AES";
		try {
			KeyGenerator kGen = KeyGenerator.getInstance(algorithm);
			SecureRandom sr = new SecureRandom();
			sr.nextBytes(passwd.getBytes());
			kGen.init(256, sr);
			SecretKey sKey = kGen.generateKey();
			byte[] rawKey = sKey.getEncoded();
			key = Base64.getEncoder().encodeToString(rawKey);
			System.out.println(key);
			SecretKeySpec sKeySpec = new SecretKeySpec(rawKey, algorithm);
			Cipher cipher = Cipher.getInstance(algorithm);
			cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
			codedMessage = Base64.getEncoder().encodeToString(cipher.doFinal(mensaje.getBytes()));
			System.out.println("Mensaje encriptado: " + codedMessage);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
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

	public static String getKey() {
		return key;
	}

	public static void destroyKey() {
		key = null;
	}
}
