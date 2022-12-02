package mainApp;

import java.io.IOException;

import models.Persona;
import utils.FileWorker;
import utils.ValidationWorker;

public class MainApp {

	public static void main(String[] args) {
		String file = "src/main/resources/datos.txt";
		Persona p = null;

		try {
			p = FileWorker.readAndCreatePersona(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(ValidationWorker.validarNombreApellidos(p.getNombreApellidos()));
		System.out.println(ValidationWorker.validarFechaNacimiento(p.getFechaNacimiento()));
		System.out.println(ValidationWorker.validarTelefonoFijo(p.getTelefonoFijo()));
		System.out.println(ValidationWorker.validarTelefonoMovil(p.getTelefonoMovil()));
		System.out.println(ValidationWorker.validarNumeroHijos(p.getNumeroHijos()));
		System.out.println(ValidationWorker.validarComunidad(p.getComunidad()));
		System.out.println(ValidationWorker.validarLocalidad(p.getLocalidad()));
		System.out.println(ValidationWorker.validarIntereses(p.getIntereses()));
	}

}
