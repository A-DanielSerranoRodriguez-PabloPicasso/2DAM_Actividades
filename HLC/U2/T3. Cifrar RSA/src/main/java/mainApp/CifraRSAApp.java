package mainApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class CifraRSAApp {

	// IMPORTANTE: Cambiar el directorio de trabajo a "bin" para que funcione
	public static void main(String[] args) {
		// args[0] = Mensaje a crifrar: "Hola buenas tardes"
		// args[1] = KeyStore: "Keys/claves"
		// args[2] = Key: "clave"
		// args[3] = Contraseña: "123456"

		byte[] mensaje = args[0].getBytes();
		String mensajeCifrado = null;
		FileInputStream fis = null;
		KeyStore kstore = null;
		Key clavePrivada = null;
		PublicKey clavePublica = null;
		Cipher cipher = null;

		try {
			kstore = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e) {
			System.out.println("No existe la instancia del KeyStore");
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(new File(args[1]));
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el KeyStore: " + args[1]);
			e.printStackTrace();
		}

		try {
			kstore.load(fis, args[3].toCharArray());
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			System.out.println("Error al cargar KeyStore: " + args[1]);
			e.printStackTrace();
		}

		try {
			clavePrivada = kstore.getKey(args[2], args[3].toCharArray());
		} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
			System.out.println("Error al cargar la clave privada");
			e.printStackTrace();
		}

		if (clavePrivada instanceof PrivateKey)
			try {
				Certificate cert = kstore.getCertificate(args[2]);
				clavePublica = cert.getPublicKey();
			} catch (KeyStoreException e) {
				System.out.println("Error al cargar la clave publica");
				e.printStackTrace();
			}

		try {
			cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			System.out.println("Error al instanciar el Cipher");
			e.printStackTrace();
		}

		try {
			cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
		} catch (InvalidKeyException e) {
			System.out.println("Error inicializando el Cipher");
			e.printStackTrace();
		}

		try {
			mensajeCifrado = Base64.getEncoder().encodeToString(cipher.doFinal(mensaje));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}

		System.out.println(mensajeCifrado);
	}

}
