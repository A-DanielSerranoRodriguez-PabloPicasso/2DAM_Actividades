package hlc.ud04.appsec.sampleapp.passwd.auth;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;

public class AutenticadorPasswd implements Autenticador {

	@Override
	public Desafio iniciaAutenticacion(String identificador) {
		return new DesafioPasswd(identificador);
	}

	@Override
	public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
		if (esRespuestaCorrecta(desafio, respuesta)) {
			DesafioPasswd des = (DesafioPasswd) desafio;
			int id = des.getId();
			return new Usuario(id);
		} else {
			return null;
		}
	}

	private boolean esRespuestaCorrecta(Desafio desafio, RespuestaDesafio respuesta) {
		DesafioPasswd desafioPasswd = (DesafioPasswd) desafio;
		RespuestaDesafioPasswd resp = (RespuestaDesafioPasswd) respuesta;

		if (desafioPasswd.getClave().equals(resp.getSolucion()))
			return true;

		return false;
	}

}
