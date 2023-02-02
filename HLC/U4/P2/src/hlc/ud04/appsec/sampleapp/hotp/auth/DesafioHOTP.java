package hlc.ud04.appsec.sampleapp.hotp.auth;

import hlc.ud04.appsec.sampleapp.hotp.models.GestorLoginHOTP;
import hlc.ud04.appsec.sampleapp.hotp.models.LoginHOTP;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;

public class DesafioHOTP implements Desafio {

	private String identificador;
	private GestorLoginHOTP gestor;
	private LoginHOTP login = null;

	public DesafioHOTP(String identificador) {
		super();
		this.identificador = identificador;
	}

	public void setGestorLogin(GestorLoginHOTP gestor) {
		this.gestor = gestor;
	}

	public String getClave() {
		if(checkLoginNull())
			login = gestor.getLogin(identificador);
		
		return login.getSecretoHotp();
	}
	
	public int getId() {
		if(checkLoginNull())
			login = gestor.getLogin(identificador);
		
		return login.getId();
	}
	
	public String getIdentificador() {
		return identificador;
	}
	
	private boolean checkLoginNull() {
		return login ==null;
	}

}
