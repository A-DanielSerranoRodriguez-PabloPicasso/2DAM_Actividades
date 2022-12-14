package psp.ud02.pr04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
  
  public static final int LEVEL_INFO = 0;
  private static final String LEVEL_INFO_NAME = "INFO";
  public static final int LEVEL_WARNING = 1;
  private static final String LEVEL_WARNING_NAME = "WARNING";
  public static final int LEVEL_ERROR = 2;
  private static final String LEVEL_ERROR_NAME = "ERROR";
  
  private static final String ARCHIVO = "filemon.log";
  private static Logger instance = null;
  private PrintWriter out = null;
  
  // Constructor privado para que no se puedan crear instancias desde fuera
  private Logger() {
    try {
      // Accede al archivo
      File file = new File(ARCHIVO);
      // Si no existe
      if (!file.exists()) {
        // Lo crea
        file.createNewFile();
      }
      out = new PrintWriter(new FileWriter(file, true));
    } catch (IOException e) {
      throw new LoggerException("No se puede crear el archivo log");
    }
  }
  
  public static synchronized Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }
    return instance;
  }
  
  
  public void logInfo(String msg) {
    log(LEVEL_INFO, msg);
  }
  
  public void logWarning(String msg) {
    log(LEVEL_WARNING, msg);
  }
  
  public void logError(String msg) {
    log(LEVEL_ERROR, msg);
  }
  
  public synchronized void log(int nivel, String msg) {
    if (out != null) {
      out.printf("[%s] (%s): %s\n", getTimestamp(), nivelToCadena(nivel), msg);
      out.flush();
    }
  }

  private Object getTimestamp() {
    return DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm:ss").format(LocalDateTime.now());
  }

  private String nivelToCadena(int nivel) {
    switch (nivel) {
      case LEVEL_INFO:
        return LEVEL_INFO_NAME;
      case LEVEL_WARNING:
        return LEVEL_WARNING_NAME;
      case LEVEL_ERROR:
        return LEVEL_ERROR_NAME;
      default:
        return LEVEL_ERROR_NAME;
    }
  }

}
