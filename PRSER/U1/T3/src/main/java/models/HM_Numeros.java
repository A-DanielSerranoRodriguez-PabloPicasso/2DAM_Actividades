package models;

public class HM_Numeros {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int num = 0, total = args.length;
		for (int i = 0; i < total; i++) {
			num += Integer.parseInt(args[i]);
		}
		System.out.println(num / total);
		System.out.println("Duracion proceso: " + (double) (System.currentTimeMillis() - startTime) / 100);
	}
}
