package psp.ud03.practica02.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtils {
	public static byte[] readNBytes(File archivo) throws FileNotFoundException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(archivo));
		return null;
	}
}
