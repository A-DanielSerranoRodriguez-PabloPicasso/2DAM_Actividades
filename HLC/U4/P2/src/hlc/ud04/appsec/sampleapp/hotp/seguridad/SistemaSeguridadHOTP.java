package hlc.ud04.appsec.sampleapp.hotp.seguridad;

import java.util.Scanner;

import hlc.ud04.appsec.sampleapp.hotp.auth.DesafioHOTP;
import hlc.ud04.appsec.sampleapp.hotp.auth.RespuestaDesafioHOTP;
import hlc.ud04.appsec.sampleapp.hotp.models.GestorLoginHOTP;
import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;

public class SistemaSeguridadHOTP implements SistemaSeguridad {

	private Autenticador autenticador;
	private ControlAcceso controlAcceso;
	private GestorLoginHOTP gestor;

	public SistemaSeguridadHOTP(Autenticador autenticador, ControlAcceso controlAcceso, GestorLoginHOTP gestor) {
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

		DesafioHOTP desafio = (DesafioHOTP) autenticador.iniciaAutenticacion(texto);
		desafio.setGestorLogin(gestor);

		System.out.print("Secreto: ");
		texto = sc.nextLine();

		return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioHOTP(texto));
	}

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		return controlAcceso.estaPermitido(usuario, operacion, recurso);
	}

}
