package psp.ud02.pr04;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracion {

  public static final int CRITERIA_DIA = 0;
  private static final String CRITERIA_DIA_STRING = "dia";
  public static final int CRITERIA_MES = 1;
  private static final String CRITERIA_MES_STRING = "mes";
  public static final int CRITERIA_ANYO = 2;
  private static final String CRITERIA_ANYO_STRING = "año";
  
  // Datos del archivo de configuración (nombre de archivo, claves y valores por defecto)
  private static final String PROPERTIES_FILE = "config.properties";
  private static final String INPUT_FOLDER_PROPERTY = "inputfolder";
  private static final String INPUT_FOLDER_DEFAULT_VALUE = ".";
  private static final String OUTPUT_FOLDER_PROPERTY = "outputfolder";
  private static final String OUTPUT_FOLDER_DEFAULT_VALUE = "./output";
  private static final String CRITERIA_PROPERTY = "criteria";
  private static final int CRITERIA_DEFAULT_VALUE = CRITERIA_DIA;
  private static final String CRITERIA_DEFAULT_STRING = "dia";
  
  
  private String inputFolder;
  private String outputFolder;
  private int criteria;
  private Logger log;
  
  private static Configuracion instancia = null;
  
  private Configuracion() {
    log = Logger.getInstance();
  }
  
  public static synchronized Configuracion getInstancia() {
    if (instancia == null) {
      instancia = new Configuracion();
      instancia.leeConfiguracion();
    }
    return instancia;
  }

  private void leeConfiguracion() {
    log.logInfo("Configuracion->Leyendo configuracion");
    Properties prop = new Properties();
    try {
      prop.load(new FileInputStream(PROPERTIES_FILE));
      inputFolder = prop.getProperty(INPUT_FOLDER_PROPERTY, INPUT_FOLDER_DEFAULT_VALUE);
      outputFolder = prop.getProperty(OUTPUT_FOLDER_PROPERTY, OUTPUT_FOLDER_DEFAULT_VALUE);
      criteria = criteriaCadenaAEnum(prop.getProperty(CRITERIA_PROPERTY, CRITERIA_DEFAULT_STRING), CRITERIA_DEFAULT_VALUE);
    } catch (IOException e) {
      log.logWarning("Configuracion->No se pudo acceder al archivo de configuración. Usando valores por defecto");
      inputFolder = INPUT_FOLDER_DEFAULT_VALUE;
      outputFolder = OUTPUT_FOLDER_DEFAULT_VALUE;
      criteria = CRITERIA_DEFAULT_VALUE;
    }
    log.logInfo("Configuracion-> inputFolder = " + inputFolder);
    log.logInfo("Configuracion-> outputFolder = " + outputFolder);
    log.logInfo("Configuracion-> criteria = " + criteria);
  }

  public String getInputFolder() {
    return inputFolder;
  }

  public String getOutputFolder() {
    return outputFolder;
  }

  public int getCriteria() {
    return criteria;
  }

  private int criteriaCadenaAEnum(String property, int criteriaDefaultValue) {
    switch (property) {
      case CRITERIA_DIA_STRING:
        return CRITERIA_DIA;
      case CRITERIA_MES_STRING:
        return CRITERIA_MES;
      case CRITERIA_ANYO_STRING:
        return CRITERIA_ANYO;
      default:
        return criteriaDefaultValue;
    }
  }

}
