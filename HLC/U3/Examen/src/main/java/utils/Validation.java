package utils;

import java.util.ArrayList;
import java.util.List;

public class Validation {
	private List<String> errores;
	private String[] camposObligatorios = { "referencia", "nombre", "precio", "puntuacion", "dominio", "url",
			"correo_pedidos" };

	public Validation() {
		errores = new ArrayList<>();
	}

	public List<String> getErrores() {
		return errores;
	}
	
	

}
