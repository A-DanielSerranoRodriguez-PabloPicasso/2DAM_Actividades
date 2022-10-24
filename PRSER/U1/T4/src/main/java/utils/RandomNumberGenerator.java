package utils;

public class RandomNumberGenerator {
	public static void main(String[] args) {
		int max = 999999999, min = 99999;
		for (int i = 0; i < 10000; i++) {
			System.out.println((int)(Math.random() * (max-min)));
		}
	}
}
