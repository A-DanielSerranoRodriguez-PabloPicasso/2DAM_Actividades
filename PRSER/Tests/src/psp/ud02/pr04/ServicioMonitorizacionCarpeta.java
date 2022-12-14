package psp.ud02.pr04;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

public class ServicioMonitorizacionCarpeta {

  private String carpetaEntrada;
  private WatchService servicio;
  List<WatchEvent<?>> eventos;
  private Logger log; 
  
  public ServicioMonitorizacionCarpeta(String carpetaEntrada) {
    this.log = Logger.getInstance();
    this.carpetaEntrada = carpetaEntrada;
    try {
      log.logInfo("Iniciando registro de servicio de monitorizacion");
      // Crea el servicio
      servicio = FileSystems.getDefault().newWatchService();
      // Lo registra
      Path ruta = Path.of(carpetaEntrada);
      ruta.register(servicio, StandardWatchEventKinds.ENTRY_CREATE);
      log.logInfo("Registro de servicio de monitorizacion realizado con éxito");
      
    } catch (IOException e) {
      log.logError("No se consiguió iniciar monitorización de carpeta. Error: " + e.getMessage());
      servicio = null;
    } finally {
      eventos = new ArrayList<WatchEvent<?>>();
    }
  }
  
  public String siguienteArchivo() {
    
    // Si se ha registrado el servicio
    if (servicio != null) {
      // Mientras no se obtengan más eventos
      while (eventos.isEmpty()) {
        try {
          // Consultamos el servicio. Si no hay eventos se bloquea
          WatchKey key = servicio.take();
          if (key != null) {
            // Si no se ha interrumpido
            // Capturamos la lista de eventos
            eventos = key.pollEvents();
            // Reiniciamos la clave para que se siga procesando el servicio (si no se para)
            key.reset();
          }
        } catch (InterruptedException e) {
          log.logError("ServicioMonitorizacionCarpeta->Interrumpido mientras se monitorizaba carpeta.");
          // Si se nos interrumpe devuelve nada y termina
          return null;
        }
      }
      // En este punto ya tenemos algún evento en la lista
      // Toma el primero y lo elimina de la lista
      Path ruta = (Path) eventos.get(0).context();
      // Y lo quita
      eventos.remove(0);
      // Termina
      return ruta.toString();
    } else {
      log.logWarning("ServicioMonitorizacionCarpeta->Intentando acceder a un monitor no inicializado");
      // El servicio no se ha conseguido iniciar correctamente
      return null;
    }
  }    
  
}
