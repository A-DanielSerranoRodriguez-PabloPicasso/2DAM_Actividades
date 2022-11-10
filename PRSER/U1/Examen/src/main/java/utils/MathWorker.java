package utils;

import java.util.List;

public class MathWorker {
	/**
	 * Realiza la media de los numeros pasados
	 * 
	 * @param lista List<Double>
	 * @return double
	 */
	public static double calcularMedia(List<Double> lista) {
		double resultado = 0;

		for (Double numero : lista) {
			resultado += numero;
		}

		resultado = (double) resultado / lista.size();

		return resultado;
	}
}
