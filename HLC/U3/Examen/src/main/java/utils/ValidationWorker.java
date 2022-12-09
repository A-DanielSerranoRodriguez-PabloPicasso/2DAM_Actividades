package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ValidationWorker {
	private List<String> errores;
	private BloqueDatos bdef;

	public ValidationWorker(String ruta) {
		errores = new ArrayList<>();
		bdef = new BloqueDatosEnFichero(ruta);
	}

	public List<String> getErrores() {
		return errores;
	}

	public void muestraErrores() {
		for (String error : errores) {
			System.out.println(error);
		}
	}

	private String obligatorio() {
		return ", campo obligatorio.";
	}

	private String error(String campo) {
		return "Error en " + campo;
	}

	/**
	 * Comprueba si el texto introducido coincide con la expresion regular
	 * proporcionada
	 * 
	 * @param text  String - Texto a comprobar
	 * @param regex String - Expresion regular
	 * @return true - false
	 */
	private boolean matches(String text, String regex) {
		return text.matches(regex);
	}

	private boolean blank(String text) {
		return text.isBlank();
	}

	private boolean validate(String text, String regex) {
		if (!blank(text))
			return matches(text, regex);

		return false;
	}

	public void validaReferencia() {
		String campo = "referencia";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = "[3-6][4-7][0-9]{11}";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", valor no valido");
		}
	}

	public void validaNombre() {
		String campo = "nombre";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = ".{1,200}";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", demasiado largo");
		}
	}

	public void validaPrecio() {
		String campo = "precio";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = "[0-9]+([.][0-9]{2})?";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", valor erroneo");
		}
	}

	public void validaMarca() {
		String campo = "marca";
		String regex = ".{1,100}";
		String valor = bdef.getDato(campo);
		if (!validate(valor, regex))
			errores.add(error(campo) + ", demasiado largo");

	}

	public void validaPuntuacion() {
		String campo = "puntuacion";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = "([0-4]([.][0-9])?|5([.][0])?)";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", valor no valido");
		}
	}

	public void validaFechaInicio() {
		String campo = "fecha_inicio_venta";
		String valor = bdef.getDato(campo);

		DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		date.setLenient(false);

		try {
			date.parse(valor);
		} catch (ParseException e) {
			errores.add(error(campo) + ", fecha no valida");
		}
	}

	public void validaDominio() {
		String campo = "dominio";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = "^((?!-))(xn--)?[a-z0-9][a-z0-9-_]{0,63}[a-z0-9]{0,63}\\.(xn--)?([a-z0-9\\-]{1,63}|[a-z0-9-]{1,63}\\.[a-z]{2,63})$";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", dominio no valido");
		}
	}

	public void validaUrl() {
		String campo = "url";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = "((http|https)://)(www.)?[a-zA-Z0-9@:%._\\+~#?&//=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%._\\+~#?&//=]*)";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", url no valida");
		}
	}

	public void validaCorreoPedidos() {
		String campo = "correo_pedidos";
		String valor = bdef.getDato(campo);
		if (valor == null)
			errores.add(error(campo) + obligatorio());
		else {
			String regex = "^(.+)@(\\S+)$";
			if (!validate(valor, regex))
				errores.add(error(campo) + ", correo no valido");
		}
	}

	public void validaPuntosFuertes() {
		String campo = "puntos_fuertes";
		String valor = bdef.getDato(campo);

		String regex = "([Precio]?[Tecnologia]?[Durabilidad]?[Disponibilidad]?[Marca]?[Sostenible]?[Calidad]?[Tamaño]?,+){0,5}";
		if (!validate(valor, regex))
			errores.add(error(campo) + ", puntos fuertes no validos");
	}

	public void validaPuntosDebiles() {
		String campo = "puntos_debiles";
		String valor = bdef.getDato(campo);

		String regex = "([Precio]?[Tecnologia]?[Durabilidad]?[Disponibilidad]?[Marca]?[Sostenible]?[Calidad]?[Tamaño]?,+){0,5}";
		if (!validate(valor, regex))
			errores.add(error(campo) + ", puntos debiles no valido");
	}
}
