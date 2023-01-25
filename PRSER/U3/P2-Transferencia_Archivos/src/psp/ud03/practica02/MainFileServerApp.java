package psp.ud03.practica02;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import psp.ud03.practica02.models.FileSender;

public class MainFileServerApp {
	private static final int PUERTO_LOCAL = 4321;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(PUERTO_LOCAL);
			while (true) {
				Socket socket = serverSocket.accept();

				FileSender fs = new FileSender(socket);

				fs.start();
			}
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
