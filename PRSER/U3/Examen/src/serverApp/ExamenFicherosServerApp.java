package serverApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import serverApp.models.ServerThread;

public class ExamenFicherosServerApp {

	public static void main(String[] args) {
		// Ponemos un puerto predeterminado
		int puerto = 2121;
		ServerSocket serverSocket = null;
		Properties props = new Properties();
		File archivo = new File("server.properties");

		/*
		 * Si el archivo de propiedades existe, lo cargamos y buscamos la propiedad
		 * "puerto".
		 * 
		 * Si la propiedad existe, cambia el valor de puerto al del archivo, si no se
		 * mantiene el predeterminado.
		 */
		if (archivo.exists()) {
			String prop;

			try {
				props.load(new BufferedReader(new FileReader(archivo)));
			} catch (IOException e) {
				e.printStackTrace();
			}

			prop = props.getProperty("puerto");

			if (props != null)
				puerto = Integer.parseInt(prop);
		}
		
		try {
			serverSocket = new ServerSocket(puerto);
			while (true) {
				Socket socket = serverSocket.accept();

				ServerThread st = new ServerThread(socket);

				st.start();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
			try {
				serverSocket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
