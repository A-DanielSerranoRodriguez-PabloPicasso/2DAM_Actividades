package hlc.ud04.appsec.sampleapp.auth;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;

public class AutenticadorHotp implements Autenticador {

	@Override
	public Desafio iniciaAutenticacion(String identificador) {
		return new DesafioHotp(identificador);
	}

	@Override
	public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
		if (esRespuestaCorrecta(desafio, respuesta)) {
			DesafioHotp des = (DesafioHotp) desafio;
			String id = des.getIdentificador();
			return new Usuario(Integer.parseInt(id));
		} else {
			return null;
		}
	}

	private boolean esRespuestaCorrecta(Desafio desafio, RespuestaDesafio respuesta) {
		DesafioHotp desafioHopt = (DesafioHotp) desafio;
		RespuestaDesafioHopt resp = (RespuestaDesafioHopt) respuesta;

		System.out.println(desafioHopt.getClave());

		if (desafioHopt.getClave().equals(resp.getSolucion()))
			return true;

		return false;
	}

}
