package utils;

public class IVWorker {
	/**
	 * Generates a basic IV for encryption
	 * 
	 * @return byte[12]
	 */
	public static byte[] getIV() {
		byte[] iv = new byte[12];
		for (int i = 0; i < iv.length; i++)
			iv[i] = (byte) i;
		return iv;
	}
}
