package psp.ud03.practica02.models;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class FileSender extends Thread {

	private DatagramSocket dgs;
	private int puerto;
	private String ruta;

	public FileSender(DatagramSocket dgs, int puerto, String ruta) {
		this.dgs = dgs;
		this.puerto = puerto;
		this.ruta = ruta;
	}

	@Override
	public void run() {
		DatagramPacket dgpRespuesta;
		byte[] buffer = new byte[1024];
		File archivo = new File(ruta);
		String respuesta;
		boolean exists = archivo.exists();
		BufferedInputStream bis = null;

		try {
			dgs.connect(InetAddress.getLocalHost(), puerto);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		if (exists) {
			respuesta = "OK";
		} else {
			respuesta = "ERR";
		}

		buffer = respuesta.getBytes();
		dgpRespuesta = new DatagramPacket(buffer, buffer.length);

		try {
			dgs.send(dgpRespuesta);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (exists) {
			try {
				bis = new BufferedInputStream(new FileInputStream(archivo));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			try {
				buffer = bis.readAllBytes();
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			dgpRespuesta = new DatagramPacket(buffer, buffer.length);

			try {
				dgs.send(dgpRespuesta);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
