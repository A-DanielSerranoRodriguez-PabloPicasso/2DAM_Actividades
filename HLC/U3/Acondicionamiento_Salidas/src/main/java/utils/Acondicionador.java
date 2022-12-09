package utils;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Acondicionador {

	public static String acondicionaElementoHTML(String cadena) {
		return cadena.replaceAll("&", "&amp").replaceAll("<", "&lt").replaceAll(">", "&gt");
	}

	public static String acondicionaAtributoHTML(String cadena) {
		return acondicionaElementoHTML(cadena).replaceAll("\"", "&#34").replaceAll("'", "&#39");
	}

	public static String acondicionaContenidoCSS(String cadena) {
		String cambiante = cadena;

		cambiante = cambiante.replaceAll("\"", "\22 ");
		cambiante = cambiante.replaceAll("'", "\27 ");
		cambiante = cambiante.replaceAll("/", "\2F ");
		cambiante = cambiante.replaceAll("\\", "\5C ");
		cambiante = cambiante.replaceAll("<", "\3C ");
		cambiante = cambiante.replaceAll(">", "\3E ");
		cambiante = cambiante.replaceAll("&", "\26 ");
		cambiante = cambiante.replaceAll("(", "\28 ");
		cambiante = cambiante.replaceAll(")", "\29 ");

		return cambiante;
	}

	public static String acondicionaUrl(String cadena) {
		String[] partes = cadena.split("[?]q=");
		partes[0] += "?q=";
		int startPoint = cadena.lastIndexOf("[?]q=") + 3;
		
				partes[1] =URLEncoder.encode(partes[1], StandardCharsets.UTF_8);
//		return partes[0] + "?q=" + URLEncoder.encode(partes[1], StandardCharsets.UTF_8);
		return partes[0] + partes[1];
	}

	public static String acondicionaLiteralSQL(String cadena) {
		return "";
	}

}
