package mainApp;

public class SlaveApp {
	/**
	 * Calcula la suma de los cuadrados de la resta entre los numeros y la media
	 * 
	 * @param args String[]
	 */
	public static void main(String[] args) {
		/*
		 * args[0] = media recibida
		 * 
		 * args[1] = numeros a leer
		 * 
		 * Devolvemos la suma de los cuadrados de la resta entre el numero n de la lisa
		 * y la media:
		 * 
		 * (1 - media)cuadrado + (8.324 - media)cuadrado
		 */

		double media = Double.parseDouble(args[0]), resultado = 0;
		String[] numeros = args[1].trim().split(" ");

		for (int i = 0; i < numeros.length; i++) {
			resultado += Math.pow((Double.parseDouble(numeros[i]) - media), 2);
		}

		System.out.println(resultado);
	}
}
