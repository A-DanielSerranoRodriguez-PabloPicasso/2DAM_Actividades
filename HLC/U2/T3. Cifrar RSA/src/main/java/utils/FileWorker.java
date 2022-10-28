package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyPair;

public class FileWorker {
	enum KEY_TYPE {
		PUBLIC, PRIVATE
	}

	public static void generateFiles() throws IOException {
		File publicKey = new File("src/main/resources/Keys/public.key");
		File privateKey = new File("src/main/resources/Keys/private.key");

		if (!publicKey.exists())
			publicKey.createNewFile();

		if (!privateKey.exists())
			privateKey.createNewFile();
	}

	public static void writeFile(KEY_TYPE tipo, File archivo) throws IOException {
		ObjectOutputStream oos = null;
		KeyPair keys = KeyPairWorker.keys;

		switch (tipo) {
		case PUBLIC:
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(keys.getPublic());
			break;

		case PRIVATE:
			oos = new ObjectOutputStream(new FileOutputStream(archivo));
			oos.writeObject(KeyPairWorker.keys.getPrivate());
			break;

		default:
			throw new IllegalArgumentException("Unexpected value: " + tipo);
		}

		oos.close();
	}
}
