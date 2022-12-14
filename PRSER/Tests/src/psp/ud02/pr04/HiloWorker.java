package psp.ud02.pr04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HiloWorker extends Thread {

  private String rutaArchivo;
  private String carpetaSalida;
  private int criteria;
  private Logger log;

  public HiloWorker(String archivo, String carpetaSalida, int criteria) {
    this.rutaArchivo = archivo;
    this.carpetaSalida = carpetaSalida;
    this.criteria = criteria;
    this.log = Logger.getInstance();
  }

  @Override
  public void run() {
    log.logInfo("HiloWorker-> Iniciando hilo");
    ArchivoWhatsApp archivo = new ArchivoWhatsApp(rutaArchivo);
    if (archivo.isValido()) {
      log.logInfo("HiloWorker->Archivo válido. Procesándolo");
      creaCarpetaSiNecesario(archivo);
      mueveArchivo(archivo);
    } else {
      log.logWarning("HiloWorker->El archivo no tiene un nombre válido. Terminando");
    }
    // Lo elimina siempre por si las moscas
    eliminaArchivoEntrada();
    log.logInfo("HiloWorker-> Terminando hilo");
  }
  
  private void creaCarpetaSiNecesario(ArchivoWhatsApp archivo) {
    Path pathCarpeta = getPathCarpeta(archivo);
    if (pathCarpeta != null) {
      try {
        Files.createDirectories(pathCarpeta);
      } catch (IOException e) {
        log.logError("HiloWorker-> No se pudo crear la carpeta " + pathCarpeta.toString());
      }
    }
  }

  private void mueveArchivo(ArchivoWhatsApp archivo) {

    // Obtenemos la ruta al archivo de entrada
    Path pathEntrada = Path.of(rutaArchivo);
    
    // Obtiene la ruta a la carpeta de salida
    Path pathCarpeta = getPathCarpeta(archivo);
    // Añade el nombre del archivo
    Path pathSalida = pathCarpeta.resolve(pathEntrada.getFileName());
    // Realizamos el movimiento
    try {
      Files.move(pathEntrada, pathSalida);
    } catch (IOException e) {
      log.logError("HiloWorker->No se pudo mover el archivo " + pathEntrada.toString() + " al destino " + pathSalida.toString());
    }
  }

  private void eliminaArchivoEntrada() {
    File archivoEntrada = new File(this.rutaArchivo);
    archivoEntrada.delete();
  }

  private Path getPathCarpeta(ArchivoWhatsApp archivo) {
    // Obtenemos la ruta a la carpeta base de salida
    Path pathSalida = Path.of(carpetaSalida);
    // Segun el criterio
    Path pathCarpeta = null;
    if (criteria == Configuracion.CRITERIA_ANYO) {
      pathCarpeta = pathSalida.resolve(archivo.getAnyo());
    } else if (criteria == Configuracion.CRITERIA_MES) {
      pathCarpeta = pathSalida.resolve(archivo.getAnyo()).resolve(archivo.getMes());
    } else if (criteria == Configuracion.CRITERIA_DIA) {
      pathCarpeta = pathSalida.resolve(archivo.getAnyo()).resolve(archivo.getMes()).resolve(archivo.getDia());
    }
    return pathCarpeta;
  }
}
