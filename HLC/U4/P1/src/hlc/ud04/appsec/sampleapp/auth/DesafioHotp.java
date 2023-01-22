package hlc.ud04.appsec.sampleapp.auth;

import hlc.ud04.appsec.sampleapp.models.GestorLogin;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;

public class DesafioHotp implements Desafio {

	private String identificador;
	private GestorLogin gestor;

	public DesafioHotp(String identificador) {
		super();
		this.identificador = identificador;
	}

	public void setGestorLogin(GestorLogin gestor) {
		this.gestor = gestor;
	}

	public String getClave() {
		return gestor.getLogin(identificador).getSecretoHotp();
	}
	
	public String getIdentificador() {
		return identificador;
	}

}
