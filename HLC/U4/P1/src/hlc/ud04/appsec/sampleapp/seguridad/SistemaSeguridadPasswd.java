package hlc.ud04.appsec.sampleapp.seguridad;

import java.util.Scanner;

import hlc.ud04.appsec.sampleapp.auth.Passwd.DesafioPasswd;
import hlc.ud04.appsec.sampleapp.auth.Passwd.RespuestaDesafioPasswd;
import hlc.ud04.appsec.sampleapp.models.passwd.GestorLoginPasswd;
import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;

public class SistemaSeguridadPasswd implements SistemaSeguridad {

	private Autenticador autenticador;
	private ControlAcceso controlAcceso;
	private GestorLoginPasswd gestor;

	public SistemaSeguridadPasswd(Autenticador autenticador, ControlAcceso controlAcceso, GestorLoginPasswd gestor) {
		super();
		this.autenticador = autenticador;
		this.controlAcceso = controlAcceso;
		this.gestor = gestor;
	}

	@Override
	public Usuario autentica() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String texto;

		System.out.print("Identificador del usuario: ");
		texto = sc.nextLine();

		DesafioPasswd desafio = (DesafioPasswd) autenticador.iniciaAutenticacion(texto);
		desafio.setGestorLogin(gestor);

		System.out.print("Password: ");
		texto = sc.nextLine();

		return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioPasswd(texto));
	}

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		return controlAcceso.estaPermitido(usuario, operacion, recurso);
	}

}
