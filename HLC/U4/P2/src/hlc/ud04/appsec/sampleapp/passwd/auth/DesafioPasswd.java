package hlc.ud04.appsec.sampleapp.passwd.auth;

import hlc.ud04.appsec.sampleapp.passwd.models.GestorLoginPasswd;
import hlc.ud04.appsec.sampleapp.passwd.models.LoginPasswd;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;

public class DesafioPasswd implements Desafio {

	private String identificador;
	private GestorLoginPasswd gestor;
	private LoginPasswd login = null;

	public DesafioPasswd(String identificador) {
		super();
		this.identificador = identificador;
	}

	public GestorLoginPasswd getGestorLogin() {
		return gestor;
	}

	public void setGestorLogin(GestorLoginPasswd gestor) {
		this.gestor = gestor;
	}

	public String getClave() {
		if (checkLoginNull())
			login = gestor.getLogin(identificador);

		return login.getPasswd();
	}

	public String getIdentificador() {
		return identificador;
	}

	public int getId() {
		if (checkLoginNull())
			login = gestor.getLogin(identificador);
		
		return login.getId();
	}

	private boolean checkLoginNull() {
		return login == null;
	}

}
