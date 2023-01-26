package hlc.ud04.appsec.sampleapp.auth.HOTP;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;

public class AutenticadorHOTP implements Autenticador {

	@Override
	public Desafio iniciaAutenticacion(String identificador) {
		return new DesafioHOTP(identificador);
	}

	@Override
	public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
		if (esRespuestaCorrecta(desafio, respuesta)) {
			DesafioHOTP des = (DesafioHOTP) desafio;
			int id = des.getId();
			return new Usuario(id);
		} else {
			return null;
		}
	}

	private boolean esRespuestaCorrecta(Desafio desafio, RespuestaDesafio respuesta) {
		DesafioHOTP desafioHopt = (DesafioHOTP) desafio;
		RespuestaDesafioHOTP resp = (RespuestaDesafioHOTP) respuesta;

		if (desafioHopt.getClave().equals(resp.getSolucion()))
			return true;

		return false;
	}

}
