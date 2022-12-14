package psp.ud02.pr04;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class ProcesaWhatsAppApp {

  public static void main(String[] args) {
    // Creamos el Logger
    Logger log = Logger.getInstance();
    
    log.logInfo("Iniciando aplicación");

    // Leemos la configuración
    Configuracion config = Configuracion.getInstancia();

    // Crea el servicio de observacion
    ServicioMonitorizacionCarpeta servicio = new ServicioMonitorizacionCarpeta(config.getInputFolder());
    
    // Bucle que va tomando archivos y los va procesando
    String archivo;
    log.logInfo("Iniciando monitorizacion de los archivos");
    while ((archivo = servicio.siguienteArchivo()) != null) {
      log.logInfo("Recibido archivo a procesar: " + archivo);
      // Crea el hilo worker y lo arranca
      HiloWorker worker = new HiloWorker(ajustaRutaArchivo(config.getInputFolder(), archivo), config.getOutputFolder(), config.getCriteria());
      worker.start();
    }
    log.logError("Finalizando por error en servicio de monitorización");
  }
  
  private static String ajustaRutaArchivo(String carpeta, String archivo) {
    Path rutaCarpeta = Paths.get(carpeta);
    Path rutaArchivo = rutaCarpeta.resolve(archivo);
    return rutaArchivo.toString();
  }
  
}
