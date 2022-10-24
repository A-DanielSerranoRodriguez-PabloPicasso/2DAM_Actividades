package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapicuaDetector {

	public static void main(String[] args) {
		boolean capicua = true;
		BufferedReader sibr = new BufferedReader(new InputStreamReader(System.in));
		String linea;

		try {
			while ((linea = sibr.readLine()) != null) {
				for (int i = 0, l = linea.length(); i < l; i++) {
					if (linea.charAt(i) != linea.charAt(l - 1 - i))
						capicua = false;
				}

				if (capicua)
					System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
