package hlc.ud04.appsec.sampleapp.seguridad;

import java.util.Scanner;
import hlc.ud04.appsec.sampleapp.autenticator.DesafioMath;
import hlc.ud04.appsec.sampleapp.autenticator.RespuestaDesafioMath;
import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;
import hlc.ud04.appsec.seguridad.controlacceso.ControlAcceso;
import hlc.ud04.appsec.seguridad.controlacceso.Operacion;
import hlc.ud04.appsec.seguridad.controlacceso.Recurso;
import hlc.ud04.appsec.seguridad.core.SistemaSeguridad;

public class SistemaSeguridadMatematico implements SistemaSeguridad {

  private Autenticador autenticador;
  private ControlAcceso controlAcceso;
  
  public SistemaSeguridadMatematico(Autenticador autenticador, ControlAcceso controlAcceso) {
    this.autenticador = autenticador;
    this.controlAcceso = controlAcceso;
  }
  
  @Override
  public Usuario autentica() {
    
    Scanner sc = new Scanner(System.in);
    
    // Solicita el nombre de usuario
    System.out.print("Introduzca el identificador del usuario: ");
    String usuario = sc.nextLine();
    
    DesafioMath desafio = (DesafioMath) autenticador.iniciaAutenticacion(usuario);
    
    // Muestra el desafio
    System.out.println("Operacion: " + desafio.getOperacion());
    System.out.println("Factor: " + desafio.getNumero());
    // Solicita la respuesta
    System.out.print("Introduzca la respuesta: ");
    String respuesta = sc.nextLine();
    // Termina la autenticacion
    return autenticador.finalizaAutenticacion(desafio, new RespuestaDesafioMath(Integer.parseInt(respuesta)));
  }

  @Override
  public boolean estaPermitido(Usuario usuario, Operacion operacion, Recurso recurso) {
    return controlAcceso.estaPermitido(usuario, operacion, recurso);
  }

}
