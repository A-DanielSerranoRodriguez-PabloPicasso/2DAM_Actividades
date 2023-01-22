package psp.ud03.practica02.utils;

import java.util.Arrays;

public class ArrayUtils {

	/**
	 * Trunca un array de byte, eliminando los datos innecesarios.
	 * 
	 * @param original byte[]
	 * @return byte[]
	 */
	public static byte[] truncar(byte[] original) {
		byte[] result = null;
		int originalSize = original.length;

		for (int i = originalSize - 1; i > 0; i--) {
			if (original[i] != 0) {
				result = Arrays.copyOf(original, ++i);
				i = 0;
			}
		}

		return result;
	}

}
