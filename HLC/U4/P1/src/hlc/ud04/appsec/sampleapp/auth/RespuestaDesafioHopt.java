package hlc.ud04.appsec.sampleapp.auth;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

public class RespuestaDesafioHopt implements RespuestaDesafio {
	private String solucion;

	public RespuestaDesafioHopt(String solucion) {
		this.solucion = solucion;
	}

	public String getSolucion() {
		return solucion;
	}
}
