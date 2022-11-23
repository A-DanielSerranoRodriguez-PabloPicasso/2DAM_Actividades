package mainApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import utils.FolderWorker;

public class Dispatcher {

	public static void main(String[] args) {
		Properties props = new Properties();
		try {
			props.load(new BufferedReader(new FileReader(new File("config.properties"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File carpeta = new File(props.getProperty("inputFolder"));
		Thread th =null;
		
		String[] archivos = carpeta.list();
		
		for(String archivo : archivos) {
			th = new FolderWorker(carpeta.getAbsolutePath()+ "/" + archivo);
			th.run();
			th.start();
		}
	}

}
