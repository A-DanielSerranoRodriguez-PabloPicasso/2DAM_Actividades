package hlc.ud04.appsec.sampleapp.passwd.auth;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

public class RespuestaDesafioPasswd implements RespuestaDesafio {
	private String solucion;

	public RespuestaDesafioPasswd(String solucion) {
		this.solucion = solucion;
	}

	public String getSolucion() {
		return solucion;
	}
}
