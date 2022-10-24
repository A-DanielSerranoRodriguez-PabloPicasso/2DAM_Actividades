package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberWorker {

	public static void main(String[] args) {
		BufferedReader sibr = new BufferedReader(new InputStreamReader(System.in));
		String linea;
		
		try {
			while ((linea = sibr.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
