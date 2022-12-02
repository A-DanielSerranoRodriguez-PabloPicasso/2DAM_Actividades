package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidationWorker {

	public static boolean validarNombreApellidos(String nombreApellidos) {
		String regex = "([A-Z][a-z]{1,}\s?){2,}";
		return nombreApellidos.matches(regex);
	}

	public static boolean validarFechaNacimiento(String fechaNacimiento) {
		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		date.setLenient(false);

		try {
			date.parse(fechaNacimiento);
		} catch (ParseException e) {
//			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static boolean validarTelefonoFijo(String telefonoFijo) {
		String regex = "[0-9]{9}";
		return telefonoFijo.matches(regex);
	}

	public static boolean validarTelefonoMovil(String telefonoMovil) {
		String regexNational = "[0-9]{9}", regexInternat = "[+][0-9]{2}\s[0-9]{9}";
		return telefonoMovil.matches(regexInternat) ? true : telefonoMovil.matches(regexNational);
	}

	public static boolean validarNumeroHijos(String numeroHijos) {
		String regex = "[0-9]{1,2}";
		return numeroHijos.matches(regex);
	}

	public static boolean validarComunidad(String comunidad) {
		String regex = "([A-Z][a-z]{1,}\s?){1,}";
		return comunidad.matches(regex);
	}

	public static boolean validarLocalidad(String localidad) {
		String regex = "([A-Z][a-z]{1,}\s?){1,}";
		return localidad.matches(regex);
	}

	public static boolean validarIntereses(String intereses) {
		String regex = "([A-Z]?[a-z\s]{1,}\s?,?){1,5}";
		return intereses.matches(regex);
	}
}
