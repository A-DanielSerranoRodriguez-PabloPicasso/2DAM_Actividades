package hlc.ud04.appsec.sampleapp.autenticator;

import hlc.ud04.appsec.seguridad.autenticacion.RespuestaDesafio;

public class RespuestaDesafioMath implements RespuestaDesafio {
  
  private int solucion;
  
  public RespuestaDesafioMath(int solucion) {
    this.solucion = solucion;
  }

  
  public int getSolucion() {
    return solucion;
  }
}
