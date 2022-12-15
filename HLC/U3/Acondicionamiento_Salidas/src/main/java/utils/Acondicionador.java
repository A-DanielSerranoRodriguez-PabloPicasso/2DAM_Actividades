package utils;

public class Acondicionador {

	/**
	 * Valida que existan caracteres peligrosos en el elemento HTML
	 * 
	 * @param cadena String
	 * @return verdadero si tiene elementos peligrosos - falso si no
	 */
	private static boolean validaElementoHtml(String cadena) {
		String regex = ".*[&<>]+.*";
		return cadena.matches(regex);
	}

	/**
	 * Formatea la cadena para poder ser utilizada como elemento HTML
	 * 
	 * @param cadena String
	 * @return String formateado
	 */
	public static String acondicionaElementoHtml(String cadena) {
		if (validaElementoHtml(cadena))
			return cadena.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;");
		return cadena;
	}

	/**
	 * Valida que existan caracteres peligrosos en el elemento HTML
	 * 
	 * @param cadena String
	 * @return verdadero si tiene elementos peligrosos - falso si no
	 */
	private static boolean validaAtributoHtml(String cadena) {
		String regex = ".*[&<\"']+.*";
		return cadena.matches(regex);
	}

	/**
	 * Formatea la cadena para poder ser utilizada como atributo HTML
	 * 
	 * @param cadena String
	 * @return String formateado
	 */
	public static String acondicionaAtributoHtml(String cadena) {
		if (validaAtributoHtml(cadena))
			return cadena.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll("\"", "&#34;").replaceAll("'",
					"&#39;");
		return cadena;
	}

	/**
	 * Valida que existan caracteres peligrosos en el CSS
	 * 
	 * @param cadena String
	 * @return verdadero si tiene elementos peligrosos - falso si no
	 */
	private static boolean validaCss(String cadena) {
		String regex = ".*[\"'\\<&()/>]+.*";
		return cadena.matches(regex);
	}

	/**
	 * Formatea la cadena para poder ser utilizada como contenido CSS
	 * 
	 * @param cadena String
	 * @return String formateado
	 */
	public static String acondicionaContenidoCss(String cadena) {
		if (validaCss(cadena)) {
			String nuevaCadena = "";

			for (int i = 0; i < cadena.length(); i++) {
				String caracterActual = cadena.charAt(i) + "", caracterSiguiente = cadena.charAt(i) + "";

				if (!buenCaracter(caracterActual) || caracterActual.equals("\\")) {
					if (i < cadena.length() - 1)
						caracterSiguiente = cadena.charAt(i + 1) + "";
					nuevaCadena += stringToHexCss(caracterActual, caracterSiguiente);
				} else {
					nuevaCadena += caracterActual;
				}

			}
			return nuevaCadena;
		}
		return cadena;
	}

	/**
	 * Convierte un caracter en su contraparte hexadecimal y lo formatea para una
	 * salida correcta para CSS
	 * 
	 * @param caracter          String con el caracter
	 * @param siguienteCaracter String con el siguiente caracter
	 * @return String transformado
	 */
	private static String stringToHexCss(String caracter, String siguienteCaracter) {
		byte[] bytes = caracter.getBytes();

		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append("\\");
			result.append(String.format("%02x", b));
		}

		if (siguienteCaracter.matches("[0-9]"))
			result.append(" ");

		return result.toString();
	}

	/**
	 * Comrpueba si el caracter esta permitido en el CSS
	 * 
	 * @param caracter String
	 * @return verdadero o falso
	 */
	private static boolean buenCaracter(String caracter) {
		String regex = "[^\"'\\<&()/>]";
		return caracter.matches(regex);
	}

	/**
	 * Valida que existan caracteres peligrosos en la URL
	 * 
	 * @param cadena String
	 * @return verdadero si tiene elementos peligrosos - falso si no
	 */
	private static boolean validaUrl(String cadena) {
		String regex = ".*[^-.0-9a-zA-Z_~@]+.*";
		return cadena.matches(regex);
	}

	/**
	 * Formatea la cadena para poder ser utilizada como valor de una URL
	 * 
	 * @param cadena String
	 * @return String formateado
	 */
	public static String acondicionaUrl(String cadena) {
		if (validaUrl(cadena)) {
			String nuevaCadena = "";

			for (int i = 0; i < cadena.length(); i++) {
				String caracter = cadena.charAt(i) + "";

				if (caracter.matches("[^-.0-9a-zA-Z_~@]"))
					nuevaCadena += stringToHexUrl(caracter);
				else
					nuevaCadena += caracter;
			}

			return nuevaCadena;
		}
		return cadena;
	}

	/**
	 * Convierte un caracter en su contraparte hexadecimal y lo formatea para una
	 * salida correcta para URL
	 * 
	 * @param caracter String con el caracter
	 * @return String transformado
	 */
	private static String stringToHexUrl(String caracter) {
		byte[] bytes = caracter.getBytes();

		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append("%");
			result.append(String.format("%02x", b).toUpperCase());
		}

		return result.toString();
	}

	/**
	 * Valida que existan caracteres peligrosos en el SQL
	 * 
	 * @param cadena String
	 * @return verdadero si tiene elementos peligrosos - falso si no
	 */
	private static boolean validaSql(String cadena) {
		String regex = ".*[\"'\\%_]+.*";
		return cadena.matches(regex);
	}

	/**
	 * Formatea la cadena para poder ser utilizada como contenido de una sentencia
	 * SQL
	 * 
	 * @param cadena String
	 * @return String formateado
	 */
	public static String acondicionaLiteralSql(String cadena) {
		if (validaSql(cadena)) {
			String nuevaCadena = "";

			for (int i = 0; i < cadena.length(); i++) {
				char caracter = cadena.charAt(i);

				if (caracter == '"')
					nuevaCadena += "\\\"";
				else if (caracter == '\'')
					nuevaCadena += "\\'";
				else if (caracter == '\\')
					nuevaCadena += "\\\\";
				else if (caracter == '%')
					nuevaCadena += "\\%";
				else if (caracter == '_')
					nuevaCadena += "\\_";
				else
					nuevaCadena += caracter + "";
			}

			return nuevaCadena;
		}
		return cadena;
	}

}
