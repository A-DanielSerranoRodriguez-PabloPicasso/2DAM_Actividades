package psp.ud02.pr04;

import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArchivoWhatsApp {
  
  private static final String EXPRESION_ARCHIVO = "IMG-([0-9]{4})([0-9]{2})([0-9]{2})-WA[0-9]{4}\\..*";
  
  
  private String anyo;
  private String mes;
  private String dia;
  private boolean valido;
  
  public ArchivoWhatsApp(String rutaArchivo) {
    valido = procesaRutaArchivo(rutaArchivo);
    if (!valido) {
      anyo = null;
      mes = null; 
      dia = null;
    }
  }

  public String getAnyo() {
    return anyo;
  }

  public String getMes() {
    return mes;
  }

  public String getDia() {
    return dia;
  }

  public boolean isValido() {
    return valido;
  }

  private boolean procesaRutaArchivo(String rutaArchivo) {
    // Extrae el nombre del archivo sin ruta
    String nombreArchivo = Path.of(rutaArchivo).getFileName().toString();
    
    // Le aplicamos la expresión regular
    Matcher matcher = Pattern.compile(EXPRESION_ARCHIVO).matcher(nombreArchivo);
    // Si hay correspondencia
    if (matcher.matches()) {
      // Extrae los tres grupos correspondiente a dia, mes y año
      anyo = matcher.group(1);
      mes = matcher.group(2);
      dia = matcher.group(3);
      return true;
    } else {
      // Devuelve error
      return false;
    }
  }
  
  
}
