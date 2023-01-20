package hlc.ud04.appsec.sampleapp.autenticator;

import hlc.ud04.appsec.seguridad.autenticacion.Autenticador;
import hlc.ud04.appsec.seguridad.autenticacion.Desafio;
import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;
import hlc.ud04.appsec.seguridad.autenticacion.Usuario;

public class AutenticadorMath implements Autenticador {

  private static final String ALFABETO = "abcdefghijklmnñopqrstuvwxyz0123456789";
  private static DatosUsuario[] USUARIOS;
  
  private int rangoMinimo;
  private int rangoMaximo;
  
  public AutenticadorMath(int rangoMinimo, int rangoMaximo) {
    this.rangoMinimo = rangoMinimo;
    this.rangoMaximo = rangoMaximo;
    iniciaUsuarios();
  }

  @Override
  public Desafio iniciaAutenticacion(String identificador) {
    return new DesafioMath(identificador, rangoMinimo, rangoMaximo);
  }

  @Override
  public Usuario finalizaAutenticacion(Desafio desafio, RespuestaDesafio respuesta) {
    DesafioMath desafioMath = (DesafioMath)desafio;

    if (esRespuestaCorrecta(desafio, respuesta)) {
      for (int i = 0; i < USUARIOS.length; i++) {
        if (USUARIOS[i].nombre.equals(desafioMath.getIdentificador())) {
          return new Usuario(USUARIOS[i].uid);
        }
      }
      return null;
    } else {
      return null;
    }
  }

  private boolean esRespuestaCorrecta(Desafio desafio, RespuestaDesafio respuesta) {
    DesafioMath desafiom = (DesafioMath)desafio;
    RespuestaDesafioMath respuestam = (RespuestaDesafioMath)respuesta;
    int clave = getClave(desafiom.getIdentificador());
    switch (desafiom.getOperacion()) {
      case '+':
        return respuestam.getSolucion() == clave + desafiom.getNumero();
      case '-':
        return respuestam.getSolucion() == clave - desafiom.getNumero();
      case '*':
        return respuestam.getSolucion() == clave * desafiom.getNumero();
      default: return false;
    }
  }

  private int getClave(String identificador) {
    for (int i = 0; i < USUARIOS.length; i++) {
      if (USUARIOS[i].nombre.equals(identificador)) {
        return USUARIOS[i].clave;
      }
    }
    return -1;
  }

  private void iniciaUsuarios() {
    USUARIOS = new DatosUsuario[4];
    USUARIOS[0] = new DatosUsuario("usuario1", 1000, 1);
    USUARIOS[1] = new DatosUsuario("usuario2", 2000, 2);
    USUARIOS[2] = new DatosUsuario("usuario3", 3000, 3);
    USUARIOS[3] = new DatosUsuario("usuario4", 4000, 4);
  }

}

class DatosUsuario {
  String nombre;
  int clave;
  long uid;
  
  DatosUsuario(String nombre, int clave, long uid) {
    this.nombre = nombre;
    this.clave = clave;
    this.uid = uid;
  }
}
