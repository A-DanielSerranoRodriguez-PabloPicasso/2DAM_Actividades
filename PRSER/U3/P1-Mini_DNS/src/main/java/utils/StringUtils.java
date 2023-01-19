package utils;

import java.nio.charset.StandardCharsets;

public class StringUtils {

	/**
	 * Devuelve un String con formato UTF8, usando un array de byte.
	 * 
	 * @param bytes byte[]
	 * @return String
	 */
	public static String standardUtf8(byte[] bytes) {
		String result = new String(bytes, StandardCharsets.UTF_8);

		return result;
	}

}
