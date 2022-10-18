package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWorker {
	/**
	 * Reads the bytes of the file and returns them
	 * 
	 * @param file File
	 * @return byte[]
	 * @throws IOException - if file doesn't exists, can't be read or reader fails
	 *                     to close
	 */
	public static byte[] getBytes(File file) throws IOException {
		byte[] fileData = new byte[(int) file.length()];
		FileInputStream fis = new FileInputStream(file);
		fis.read(fileData);
		fis.close();
		return fileData;
	}

	/**
	 * Writes bytes to a file
	 * 
	 * @param file File
	 * @param data byte[]
	 * @throws IOException - if file can't be written or writer fails to close
	 */
	public static void writeBytes(File file, byte[] data) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(data);
		fos.close();
	}
}
