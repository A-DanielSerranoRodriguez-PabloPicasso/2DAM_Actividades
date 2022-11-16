package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CriptografiaWorker {
	/**
	 * IMPORTANTE: CAMBIAR EL DIRECTORIO DE TRABAJO A "bin" SI SE ESTÁ USANDO UN IDE
	 */
	private final static String keyStoreRuta = "keys/claves.keystore", pkAlias = "default";

	/**
	 * Obtiene un MessageDigest con el algoritmo indicado.
	 * 
	 * @param algoritmo String
	 * @return MessageDigest
	 * @throws NoSuchAlgorithmException - if the algorithm doesn't exists
	 */
	private static MessageDigest getMessageDigest(String algoritmo) throws NoSuchAlgorithmException {
		return MessageDigest.getInstance(algoritmo);
	}

	/**
	 * Obtiene un archivo dado su ruta
	 * 
	 * @param archivoRuta String
	 * @return File
	 */
	private static File getArchivo(String archivoRuta) {
		return new File(archivoRuta);
	}

	/**
	 * Obtiene el resumen de un archivo dado su ruta
	 * 
	 * @param archivoRuta String
	 * @return byte[]
	 */
	public static byte[] getResumenArchivo(String archivoRuta) {
		File archivo = getArchivo(archivoRuta);
		MessageDigest md = null;
		DigestInputStream dos;
		byte[] resumen;

		try {
			md = getMessageDigest("SHA256");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Error algoritmo MessageDigest: getResumenArchivo");
		}

		try {
			dos = new DigestInputStream(new FileInputStream(archivo), md);
			dos.readAllBytes();
			dos.close();
		} catch (IOException e) {
			System.err.println("Error operacion digest archivo: getResumenArchivo");
		}

		resumen = md.digest();

		return resumen;
	}

	/**
	 * Cifra bytes usando el algoritmo RSA y una contraseña
	 * 
	 * @param bytes          byte[]
	 * @param keyStorePasswd String
	 * @return byte[]
	 */
	public static byte[] cifrarBytesRSA(byte[] bytes, String keyStorePasswd) {
		byte[] resultado = null;
		FileInputStream fis = null;
		KeyStore keyStore = null;
		Key clavePrivada = null;
		Cipher cipher = null;

		try {
			fis = new FileInputStream(getArchivo(keyStoreRuta));
		} catch (FileNotFoundException e1) {
			System.err.println("Error abriendo archivo: cifrarBytesRSA");
		}

		try {
			keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
			keyStore.load(fis, keyStorePasswd.toCharArray());
		} catch (KeyStoreException e) {
			System.err.println("Error instancia KeyStore: cifrarBytesRSA");
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			System.err.println("Error cargando KeyStore: cifrarBytesRSA");
		}

		try {
			clavePrivada = keyStore.getKey(pkAlias, keyStorePasswd.toCharArray());
		} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
			System.err.println("Error obteniendo clave privada: cifrarBytesRSA");
		}

		try {
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, clavePrivada);
			resultado = cipher.doFinal(bytes);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.err.println("Error instanciado Cipher: cifrarBytesRSA");
		} catch (InvalidKeyException e) {
			System.err.println("Error inicializando Cipher: cifrarBytesRSA");
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			System.err.println("Error encriptando con Cipher: cifrarBytesRSA");
		}

		return Base64.getEncoder().encode(resultado);
	}

}
