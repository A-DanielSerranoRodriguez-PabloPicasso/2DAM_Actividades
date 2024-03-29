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
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class DescifraRSAApp {

	// IMPORTANTE: Cambiar el directorio de trabajo a "bin" para que funcione
	public static void main(String[] args) {
		// args[0] = Mensaje en Base64 a descifrar:
		// "ifNDayZOiGBy3B9ygjrpsOB46zKICG+E137wLXBUl/RPVpRMISKYOmRYKEizNyjmwUTY9mRJU3mlUyr4f11GRcXxlhOEFpDsfG4ioRZ3Ee45NAqMBuftj5wnxuwWITP2DUw9BFZCRul43NB9XgRwGPRaAzMzuYYniEOTgJowEkfOf9oc9yev4cg2EXCluZAg1CGpUWmcLU6joiw8IPPIbBL3CholXXPVD0N2iFciK9ZCPL3XL9yZyC/52CnNLj8YgdepYd1GrRozmZ1f1Pqs1gHZFhlKBOoaOoVslXIAWDctmiKC526nE2ZnTWj2fvzSc3RqdpFxJ/ILzXbLFO0Tkw=="
		// args[1] = KeyStore: "Keys/claves"
		// args[2] = Key: "clave"
		// args[3] = Contraseña: "123456"

		byte[] mensajeCifrado = Base64.getDecoder().decode(args[0]);
		String mensaje = null;
		FileInputStream fis = null;
		KeyStore kstore = null;
		Key clavePrivada = null;

		try {
			fis = new FileInputStream(new File(args[1]));
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el KeyStore: " + args[1]);
			e.printStackTrace();
		}

		try {
			kstore = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e) {
			System.out.println("Error al inicializar el KeyStore");
			e.printStackTrace();
		}

		try {
			kstore.load(fis, args[3].toCharArray());
		} catch (NoSuchAlgorithmException | CertificateException | IOException e) {
			System.out.println("Error al cargar el KeyStore: " + args[1]);
			e.printStackTrace();
		}

		try {
			clavePrivada = kstore.getKey(args[2], args[3].toCharArray());
		} catch (UnrecoverableKeyException | KeyStoreException | NoSuchAlgorithmException e) {
			System.out.println("Error al cargar la clave privada");
			e.printStackTrace();
		}

		if (clavePrivada instanceof PrivateKey) {
			Cipher cipher = null;
			try {
				cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
				System.out.println("Error al instanciar el Cipher");
				e.printStackTrace();
			}

			try {
				cipher.init(Cipher.DECRYPT_MODE, clavePrivada);
			} catch (InvalidKeyException e) {
				System.out.println("Error inicializando el Cipher");
				e.printStackTrace();
			}

			try {
				mensaje = new String(cipher.doFinal(mensajeCifrado));
			} catch (IllegalBlockSizeException | BadPaddingException e) {
				System.out.println("Error desencriptando el mensaje");
				e.printStackTrace();
			}
			System.out.println(mensaje);
		}

	}

}
