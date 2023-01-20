package hlc.ud04.appsec.sampleapp.autenticator;

import hlc.ud04.appsec.seguridad.autenticacion.Desafio;

public class DesafioMath implements Desafio {

  private String identificador;
  private char operacion;
  private int numero;
  
  public DesafioMath(String identificador, int minimo, int maximo) {
    this.identificador = identificador;
    this.operacion = generaOperacion();
    this.numero = generaNumero(minimo, maximo);
  }

  private int generaNumero(int minimo, int maximo) {
    return (int)(Math.random() * (maximo - minimo + 1) + minimo);
  }

  private char generaOperacion() {
    int numero = (int)(Math.random() * 3);
    switch (numero) {
      case 0: return '+';
      case 1: return '-';
      case 2: return '*';
      default: return '+';
    }
  }

  public String getIdentificador() {
    return identificador;
  }

  public char getOperacion() {
    return operacion;
  }

  public int getNumero() {
    return numero;
  }

}
