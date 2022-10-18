package models;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

import utils.FileWorker;
import utils.IVWorker;
import utils.SecretKeyWorker;

public class CifraFicheroAES {
	/*
	 * Immutable variables
	 */
	private final static String pathEncrypted = "src/main/resources/encrypted/";

	/**
	 * Encrypts a file using a password, given the file path. Outputs to another
	 * file in a specific folder.
	 * 
	 * @param pathFicheroIn String
	 * @param ficheroOut    String
	 * @param passwd        String
	 */
	public static void cifrarFichero(String pathFicheroIn, String ficheroOut, String passwd) {
		File file = new File(pathFicheroIn), outFile = new File(pathEncrypted + ficheroOut);
		byte[] iv = IVWorker.getIV(), fileData = null, encrypted = null;
		SecretKey skey = null;
		Cipher cipher = null;
		// The GCMParameterSpec is initialized at 128 bytes and with the IV
		GCMParameterSpec gcmspec = new GCMParameterSpec(128, iv);

		// The SecretKey is obtained
		try {
			skey = SecretKeyWorker.getSecretKey(passwd, iv);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			System.out.println("SecretKey no generada correctamente");
		}

		// The cipher is instantiated with AES, GCM and the option for NoPadding
		try {
			cipher = Cipher.getInstance("AES/GCM/NoPadding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
			System.out.println("Parametros de Cipher incorrectos");
		}

		/*
		 * The cipher is initialized in encryption mode, using the SecretKey and the
		 * GCMParameterSpec
		 */
		try {
			cipher.init(Cipher.ENCRYPT_MODE, skey, gcmspec);
		} catch (InvalidKeyException | InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			System.out.println("Parametros de inicializacion de Cipher incorrectos");
		}

		// The bytes of the file are obtained
		try {
			fileData = FileWorker.getBytes(file);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Obtencion de bytes[] de archivo incorrecto");
		}

		// The data is encrypted
		try {
			encrypted = cipher.doFinal(fileData);
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			System.out.println("Encriptacion final erronea");
		}

		// The encrypted data is written in the other file
		try {
			FileWorker.writeBytes(outFile, encrypted);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Escritura de datos encriptados a archivo incorrecta");
		}
	}
}
