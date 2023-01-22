package psp.ud03.practica02;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import psp.ud03.practica02.utils.ArrayUtils;
import psp.ud03.practica02.utils.StringUtils;

public class MainFileServerApp {
	private static int PUERTO_LOCAL = 4321, PUERTO_REMOTO = 1234, NUCLEOS = Runtime.getRuntime().availableProcessors();

	public static void main(String[] args) {
		BufferedInputStream bis;
		DatagramPacket dgpPeticion, dgpRespuesta;
		byte[] buffer = new byte[1024];

		try (DatagramSocket dgs = new DatagramSocket(PUERTO_LOCAL)) {
			boolean exists;
			String ruta, respuesta = "";
			File archivo;

			dgs.connect(InetAddress.getLocalHost(), PUERTO_REMOTO);

			dgpPeticion = new DatagramPacket(buffer, buffer.length);
			dgs.receive(dgpPeticion);
			ruta = StringUtils.standardUtf8(ArrayUtils.truncar(buffer));

			archivo = new File(ruta);

			if (archivo.exists()) {
				respuesta = "OK";
				exists = true;
			} else {
				respuesta = "ERR";
				exists = false;
			}

			buffer = respuesta.getBytes();
			dgpRespuesta = new DatagramPacket(buffer, buffer.length);
			dgs.send(dgpRespuesta);

			if (exists) {
				bis = new BufferedInputStream(new FileInputStream(archivo));
				buffer = bis.readAllBytes();
				bis.close();

				dgpRespuesta = new DatagramPacket(buffer, buffer.length);
				dgs.send(dgpRespuesta);
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
