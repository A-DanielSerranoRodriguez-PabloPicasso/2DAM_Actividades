package mainApp;

import models.Configuracion;
import utils.WatchServiceUtil;

public class ServidorEstadisticaApp {

	public static void main(String[] args) {
		Configuracion config = new Configuracion("servidor.properties");

		WatchServiceUtil.monitorizarCarpeta(config);
	}

}
