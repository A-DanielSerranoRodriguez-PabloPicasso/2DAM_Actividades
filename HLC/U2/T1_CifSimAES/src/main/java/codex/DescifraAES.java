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
	public static String descifrar(String codedMessage, String password) {
		try {
			SecretKey sKey = SecretKeyWorker.generateKey(password);
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, sKey);

			return new String(cipher.doFinal(Base64.getDecoder().decode(codedMessage)));
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
