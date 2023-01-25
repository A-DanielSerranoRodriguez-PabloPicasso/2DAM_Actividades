package hlc.ud04.appsec.sampleapp.seguridad;

import java.util.Scanner;

import hlc.ud04.appsec.sampleapp.auth.DesafioHotp;
import hlc.ud04.appsec.sampleapp.auth.RespuestaDesafioHopt;
import hlc.ud04.appsec.sampleapp.models.GestorLogin;
import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;

public class SistemaSeguridadHotp implements SistemaSeguridad {

	private Autenticador autenticador;
	private ControlAcceso controlAcceso;
	private GestorLogin gestor;

	public SistemaSeguridadHotp(Autenticador autenticador, ControlAcceso controlAcceso, GestorLogin gestor) {
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

		DesafioHotp desafio = (DesafioHotp) autenticador.iniciaAutenticacion(texto);
		desafio.setGestorLogin(gestor);

		System.out.print("Secreto: ");
		texto = sc.nextLine();

		return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioHopt(texto));
	}

	@Override
	public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
		return controlAcceso.estaPermitido(usuario, operacion, recurso);
	}

}
