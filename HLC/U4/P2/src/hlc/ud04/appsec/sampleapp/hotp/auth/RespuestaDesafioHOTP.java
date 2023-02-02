package hlc.ud04.appsec.sampleapp.hotp.auth;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

public class RespuestaDesafioHOTP implements RespuestaDesafio {
	private String solucion;

	public RespuestaDesafioHOTP(String solucion) {
		this.solucion = solucion;
	}

	public String getSolucion() {
		return solucion;
	}
}
