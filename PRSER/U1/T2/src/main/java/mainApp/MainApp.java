package mainApp;

import models.Sorter;

public class MainApp {

	public static void main(String[] args) {
		int[] testeo = { 1, 3, 8, 99, 4, 2 };
		Sorter.sorter(testeo, 0);
		for (int i = 0; i < testeo.length; i++) {
			System.out.println(testeo[i]);
		}
	}
}
